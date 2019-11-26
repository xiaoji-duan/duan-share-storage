package com.xiaoji.duan.abl.controller;

import com.alibaba.fastjson.JSONObject;
import com.xiaoji.duan.abl.model.AblDocument;
import com.xiaoji.duan.abl.service.HttpService;
import com.xiaoji.duan.abl.service.StoreService;
import com.xiaoji.duan.abl.util.MessageResult;
import com.xiaoji.duan.abl.util.ResultResponse;
import com.xiaoji.duan.abl.util.SmbUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletInputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/store")
public class StoreController {
    @Autowired
    private StoreService storeService;
    @Autowired
    private HttpService httpauth;
    @Value("${zuul.authorize.url}")
    private URL authurl;
    @Value("${zuul.authorize.path}")
    private String authpath;

    @Value("${zuul.groupuser.url}")
    private URL groupuserurl;
    @Value("${zuul.groupuser.path}")
    private String groupuserpath;


    @RequestMapping(value = "/remote/upload", method = RequestMethod.POST)
    public MessageResult<Long> writeDocRe(@RequestParam("file") MultipartFile file, @RequestParam("saPrefix") String saPrefix,
                                          @RequestParam(value = "group") String group,
                                          @RequestParam(value = "storeType",required = false) String storeType, @RequestParam("username") String username){
        if (storeType == null || "".equals(storeType)) {
            storeType = "文件存储";
        }
        List<MultipartFile> files = new ArrayList<>();
        files.add(file);
        Long id = storeService.upload(files, saPrefix, group, storeType, username);
        return ResultResponse.makeOKRsp(id);
    }

    @RequestMapping(value = "/remote/download", produces = "application/json;charset=UTF-8")
    public MessageResult readDocRe(@RequestParam("id") Long id,@RequestParam(value = "group") String group,@RequestParam("username") String username,HttpServletResponse resp) {

        if (id != null && id>0) {
            AblDocument document = storeService.selectDocById(id);
            if (document != null) {
                String fileName = document.getDocumentName();

                SmbUtils.downloadFileToBrowser(resp, document.getHdPosition(), document.getPositionX() + "/" + document.getPositionY(), document.getDocumentPosition(), fileName);

                return ResultResponse.makeOKRsp("开始下载");
            }
        }

        return ResultResponse.makeErrRsp("文件不存在");
    }

    @RequestMapping(value = "/local/upload", method = RequestMethod.POST)
    public MessageResult<Long> writeDocLo(HttpServletRequest req) {
        String token = req.getParameter("token");
        String openid = req.getParameter("openid");
        String username = req.getParameter("username");
        String host = req.getHeader("x-forwarded-host");
        String subdomain = host.substring(0, host.indexOf('.'));
        Cookie[] cookies = req.getCookies();
        if (cookies != null && (token == null || "".equals(token) || openid == null || "".equals(openid))) {
            for (Cookie cookie : cookies) {
                switch (cookie.getName()) {
                    case "authorized_user":
                        token = cookie.getValue();
                        break;
                    case "authorized_openid":
                        openid = cookie.getValue();
                        break;
                    default:
                        break;
                }
            }
        }

        JSONObject userinfo = new JSONObject();

        if (token != null && !"".equals(token) && openid != null && !"".equals(openid)) {
            Map<String, String[]> data = new HashMap<String, String[]>();
            Map<String, Object> res = httpauth.https(authurl + "/" + openid + "/info", data);
            if (res != null && res.get("data") != null && !((JSONObject) res.get("data")).isEmpty()) {
                Map<String, Object> res1 = (Map<String, Object>) res.get("data");
                if (res1.get("name") != null) {
                    username = res1.get("name").toString();
                }
            }
        }
        if (openid != null && !"".equals(openid)) {
            Map<String, String[]> data = new HashMap<String, String[]>();
            data.put("token", new String[]{token});
            data.put("openid", new String[]{openid});
            Map<String, Object> res = httpauth.https(groupuserurl + "/" + subdomain + "/username", data);

            System.out.println(res);
            if (res != null && res.get("data") != null && !((JSONObject) res.get("data")).isEmpty()) {
                Map<String, Object> res1 = (Map<String, Object>) res.get("data");
                if (res1.get("name") != null) {
                    username = res1.get("name").toString();
                }
            }
        }
        System.out.println("---------------------" + username + "---------------------");
//        String subdomain = "group";
        List<MultipartFile> files = ((MultipartHttpServletRequest) req).getFiles("formData");
        Long id = storeService.upload(files, "abl", subdomain, "文件存储", username);
        return ResultResponse.makeOKRsp(id);
    }

    @RequestMapping(value = "/local/getPath/{type}/{username}")
    public MessageResult<List<AblDocument>> readDocLo(HttpServletRequest req, HttpServletResponse resp, @PathVariable("type") String type, @PathVariable("username") String username) {
        String host = req.getHeader("x-forwarded-host");
        String subdomain = host.substring(0, host.indexOf('.'));
        String[] imgType = {"jpg", "jpeg", "gif", "png", "bmp"};
        String[] docType = {"txt", "doc", "xls", "xml", "xlsx"};
        String[] videoType = {"wmv", "avi", "dat", "mp4", "rmvb", "rm", "flv"};
//        String subdomain = "group";
        List<AblDocument> documents = storeService.selectIdsByGroup(subdomain, username);
        List<AblDocument> out = new ArrayList<>();
        switch (type) {
            case "img":
                for (AblDocument document : documents) {
                    String documentName = document.getDocumentName();
                    if (Arrays.asList(imgType).contains(documentName.substring(documentName.indexOf(".") + 1).toLowerCase())) {
                        out.add(document);
                    }
                }
                break;
            case "video":
                for (AblDocument document : documents) {
                    String documentName = document.getDocumentName();
                    if (Arrays.asList(videoType).contains(documentName.substring(documentName.indexOf(".") + 1).toLowerCase())) {
                        out.add(document);
                    }
                }
                break;
            case "doc":
                for (AblDocument document : documents) {
                    String documentName = document.getDocumentName();
                    if (Arrays.asList(docType).contains(documentName.substring(documentName.indexOf(".") + 1).toLowerCase())) {
                        out.add(document);
                    }
                }
                break;
            default:
                break;
        }
        return ResultResponse.makeOKRsp(out);
    }

    @RequestMapping(value = "/local/getContent/{id}", method = RequestMethod.GET)
    public MessageResult getContent(HttpServletRequest req, HttpServletResponse resp, @PathVariable("id") Long id) {
        AblDocument document = storeService.selectDocById(id);
        if (document != null) {
            String fileName = document.getDocumentName();
            SmbUtils.showFileToBrowser(resp, document.getHdPosition(), document.getPositionX() + "/" + document.getPositionY(), document.getDocumentPosition(), fileName);
            return ResultResponse.makeOKRsp("开始下载");
        }
        return ResultResponse.makeErrRsp("文件不存在");
    }

    @RequestMapping(value = "/local/getSnapshot/{id}", method = RequestMethod.GET)
    public MessageResult getSnapshot(HttpServletRequest req, HttpServletResponse resp, @PathVariable("id") Long id) {
        AblDocument document = storeService.selectDocById(id);
        if (document != null) {
            String fileName = document.getDocumentName();
            if (fileName.toLowerCase().endsWith("jpg")
            		|| fileName.toLowerCase().endsWith("jpeg")
            		|| fileName.toLowerCase().endsWith("gif")
            		|| fileName.toLowerCase().endsWith("png")
            		|| fileName.toLowerCase().endsWith("bmp")) {
                SmbUtils.showSnapshotToBrowser(resp, document.getHdPosition(), document.getPositionX() + "/" + document.getPositionY(), document.getDocumentPosition(), fileName);
            } else {
                SmbUtils.showFileToBrowser(resp, document.getHdPosition(), document.getPositionX() + "/" + document.getPositionY(), document.getDocumentPosition(), fileName);
            }
            return ResultResponse.makeOKRsp("开始下载");
        }
        return ResultResponse.makeErrRsp("文件不存在");
    }

    @RequestMapping(value = "/local/deleteItem/{id}")
    public MessageResult deleteItem(HttpServletRequest req, HttpServletResponse resp, @PathVariable("id") Long id) {
        System.out.println(id);
        String host = req.getHeader("x-forwarded-host");
        String subdomain = host.substring(0, host.indexOf('.'));
//        String subdomain = "group";
        storeService.delDocById(id, subdomain);
        return ResultResponse.makeErrRsp("删除成功");
    }
}
