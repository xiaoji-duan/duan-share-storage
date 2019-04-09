package com.xiaoji.duan.abl.service.impl;

import com.xiaoji.duan.abl.configuration.exception.ServiceException;
import com.xiaoji.duan.abl.dao.DocumentMapper;
import com.xiaoji.duan.abl.dao.StorageSpaceMapper;
import com.xiaoji.duan.abl.model.AblDocument;
import com.xiaoji.duan.abl.model.AblStorageSpace;
import com.xiaoji.duan.abl.service.StoreService;
import com.xiaoji.duan.abl.util.SmbUtils;
import com.xiaoji.duan.abl.util.StringUtil;
import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.ArrayUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class StroeServiceImpl implements StoreService {
    public String folderName = "smb://192.168.0.158/fileshare/abl/";
    @Autowired
    private DocumentMapper documentMapper;
    private StorageSpaceMapper spaceMapper;

    @Override
    public Long upload(List<MultipartFile> files, String saPrefix, String group, String storeTtype, String username) {
        if (saPrefix == null || "".equals(saPrefix)) {
            throw new ServiceException("短应用不存在");
        }
        if (group == null || "".equals(group)) {
            throw new ServiceException("组织不存在");
        }
        Date currentTime = new Date();
        if (files != null && files.size() > 0) {
            MultipartFile multipartFile = files.get(0);
            String oldName = multipartFile.getOriginalFilename();
            String positionY = StringUtil.stringToSha(oldName, "sha-256");
            String positionX = positionY.substring(0, 2);
            String newFolderName = folderName + positionX + "/" + positionY + "/";
            String newName = UUID.randomUUID().toString() + "-" + currentTime.getTime() + "." + oldName.substring(oldName.lastIndexOf(".") + 1);
            if (storeTtype != null && !"".equals(storeTtype)) {
                try {
                    SmbUtils.uploadFileToSharedFolder(newFolderName, multipartFile.getInputStream(), newName);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            AblDocument document = new AblDocument();
            document.setDocumentName(oldName);
            document.setPositionX(positionX);
            document.setPositionY(positionY);
            document.setDocumentPosition(newName);
            document.setDel(false);
            document.setCreateDate(currentTime);
            document.setUsername(username);
            document.setUpdateDate(currentTime);
            document.setHdPosition(folderName);
            document.setSaPrefix(saPrefix);
            document.setGroupName(group);
            document.setStoreType(storeTtype == null || "".equals(storeTtype) ? "文件存储" : storeTtype);
            documentMapper.insertDocInfo(document);
            Long id = document.getId();
            return id;
        }
        return null;
    }

    @Override
    public AblDocument selectDocById(Long id) {
        if (id == null || id == 0) {
            throw new ServiceException("文件不存在");
        }
        AblDocument document = documentMapper.selectDocById(id);
        return document;
    }

    @Override
    public List<AblDocument> selectIdsByGroup(String group,String username) {
        List<AblDocument> documents = null;
        if (group != null && !("".equals(group))) {
            documents = documentMapper.selectIdByGroup(group,username);
        }
        return documents;
    }

    @Override
    public void delDocById(Long id, String group) {
        Date date = new Date();
        AblDocument documentO = new AblDocument();
        documentO.setId(id);
        documentO.setGroupName(group);
        documentO.setDel(false);
        AblDocument document = documentMapper.selectOne(documentO);
        if (document != null) {
            String path = document.getHdPosition() + document.getPositionX() + "/" + document.getPositionY() + "/" + document.getDocumentPosition();
            SmbUtils.deleteFile(path);
            System.out.println(path);
            document.setDel(true);
            document.setUpdateDate(date);
            documentMapper.updateByPrimaryKey(document);
        }
    }

}
