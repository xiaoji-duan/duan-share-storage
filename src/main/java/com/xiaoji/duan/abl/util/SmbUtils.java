package com.xiaoji.duan.abl.util;

import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileInputStream;
import jcifs.smb.SmbFileOutputStream;
import net.coobird.thumbnailator.Thumbnails;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.net.UnknownHostException;

public class SmbUtils {
    /**
     * 创建文件夹
     * @param folderName
     * @return
     */
    public static void smbMkDir(String folderName) {
        SmbFile smbFile;
        try {
            // smb://userName:passWord@host/path/folderName
            smbFile = new SmbFile(folderName);
            if (!smbFile.exists()) {
                smbFile.mkdirs();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (SmbException e) {
            e.printStackTrace();
        }
    }

    /**
     * 上传文件
     * @param shareFolderPath
     * @param fileName
     * @param fileInputStream
     */
    public static void uploadFileToSharedFolder(String shareFolderPath, InputStream fileInputStream, String fileName) {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
//            File localFile = file;
            inputStream = fileInputStream;
            // smb://userName:passWord@host/path/shareFolderPath/fileName
            SmbFile smbFile = new SmbFile(shareFolderPath  + fileName);
            smbMkDir(shareFolderPath);
            smbFile.connect();
            outputStream = new SmbFileOutputStream(smbFile);
            byte[] buffer = new byte[4096];
            int len = 0; // 读取长度
            while ((len = inputStream.read(buffer, 0, buffer.length)) != -1) {
                outputStream.write(buffer, 0, len);
            }
            // 刷新缓冲的输出流
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("上传失败");
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException("上传失败");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("上传失败");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("上传失败");
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 下载文件到浏览器
     * @param httpServletResponse
     * @param remoteUrl
     * @param shareFolderPath
     * @param fileName
     */
    public static void downloadFileToBrowser(HttpServletResponse httpServletResponse, String remoteUrl, String shareFolderPath, String DocumentPosition,String fileName) {
        SmbFile smbFile;
        SmbFileInputStream smbFileInputStream = null;
        OutputStream outputStream = null;
        try {
            // smb://userName:passWord@host/path/shareFolderPath/fileName
            smbFile = new SmbFile(remoteUrl + shareFolderPath + "/" + DocumentPosition);
            smbFileInputStream = new SmbFileInputStream(smbFile);
            httpServletResponse.setHeader("content-type", "application/octet-stream");
            httpServletResponse.setContentType("application/json;charset=UTF-8");
            httpServletResponse.setHeader("Content-disposition", "attachment; filename=" + fileName);
            // 处理空格转为加号的问题
            httpServletResponse.setHeader("Content-Disposition", "attachment; fileName=" + fileName + ";filename*=utf-8''" + URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20"));
            outputStream = httpServletResponse.getOutputStream();
            byte[] buff = new byte[2048];
            int len;
            while ((len = smbFileInputStream.read(buff)) != -1) {
                outputStream.write(buff, 0, len);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException(" 下载失败");
        } catch (SmbException e) {
            e.printStackTrace();
            throw new RuntimeException("下载失败");
        } catch (UnknownHostException e) {
            e.printStackTrace();
            throw new RuntimeException("下载失败");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("下载失败");
        } finally {
            try {
                if(outputStream!=null){
                    outputStream.flush();
                    outputStream.close();
                }
                if(smbFileInputStream!=null){
                    smbFileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void showSnapshotToBrowser(HttpServletResponse httpServletResponse, String remoteUrl, String shareFolderPath, String DocumentPosition,String fileName) {
        SmbFile smbFile;
        SmbFileInputStream smbFileInputStream = null;
        OutputStream outputStream = null;
        try {
            // smb://userName:passWord@host/path/shareFolderPath/fileName
            smbFile = new SmbFile(remoteUrl + shareFolderPath + "/" + DocumentPosition);
            smbFileInputStream = new SmbFileInputStream(smbFile);
            System.out.println(fileName);
            if(fileName.endsWith("json")){
                httpServletResponse.setContentType("application/json;charset=UTF-8");
            }else{
                httpServletResponse.setContentType("text/html; charset=UTF-8");
                httpServletResponse.setContentType("*/*");
            }
            // 处理空格转为加号的问题
            outputStream = httpServletResponse.getOutputStream();
//            byte[] buff = new byte[1048576];
//            int len;
//            while ((len = smbFileInputStream.read(buff)) != -1) {
//                outputStream.write(buff, 0, len);
//            }
            Thumbnails.of(smbFileInputStream).outputQuality(1d).size(256, 256).toOutputStream(outputStream);

        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException(" 获取失败");
        } catch (SmbException e) {
            e.printStackTrace();
            throw new RuntimeException("获取失败");
        } catch (UnknownHostException e) {
            e.printStackTrace();
            throw new RuntimeException("获取失败");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("获取失败");
        } finally {
            try {
                if(outputStream!=null){
                    outputStream.close();
                }
                if(smbFileInputStream!=null){
                    smbFileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void showFileToBrowser(HttpServletResponse httpServletResponse, String remoteUrl, String shareFolderPath, String DocumentPosition,String fileName) {
        SmbFile smbFile;
        SmbFileInputStream smbFileInputStream = null;
        OutputStream outputStream = null;
        try {
            // smb://userName:passWord@host/path/shareFolderPath/fileName
            smbFile = new SmbFile(remoteUrl + shareFolderPath + "/" + DocumentPosition);
            smbFileInputStream = new SmbFileInputStream(smbFile);
            System.out.println(fileName);
            if(fileName.endsWith("json")){
                httpServletResponse.setContentType("application/json;charset=UTF-8");
            }else{
                httpServletResponse.setContentType("text/html; charset=UTF-8");
                httpServletResponse.setContentType("*/*");
            }
            // 处理空格转为加号的问题
            outputStream = httpServletResponse.getOutputStream();
            byte[] buff = new byte[1048576];
            int len;
            while ((len = smbFileInputStream.read(buff)) != -1) {
                outputStream.write(buff, 0, len);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException(" 获取失败");
        } catch (SmbException e) {
            e.printStackTrace();
            throw new RuntimeException("获取失败");
        } catch (UnknownHostException e) {
            e.printStackTrace();
            throw new RuntimeException("获取失败");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("获取失败");
        } finally {
            try {
                if(outputStream!=null){
                    outputStream.close();
                }
                if(smbFileInputStream!=null){
                    smbFileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void deleteFile(String path) {
        SmbFile smbFile;
        try {
            // smb://userName:passWord@host/path/shareFolderPath/fileName
            smbFile = new SmbFile(path);
            if (smbFile.exists()) {
                smbFile.delete();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (SmbException e) {
            e.printStackTrace();
        }
    }
}
