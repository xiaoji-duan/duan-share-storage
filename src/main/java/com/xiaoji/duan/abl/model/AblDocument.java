package com.xiaoji.duan.abl.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

public class AblDocument implements Serializable {
    private static final long serialVersionUID = -2809879413983206495L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//存储库id
    private String documentName;//文件原始名称
    private String documentPosition;//文件在数据库中的名字
    private String positionX;//一级文件夹
    private String positionY;//二级文件夹
    private String hdPosition;//硬盘位置
    private String storeType;//存储类型
    private String saPrefix;//短应用前缀
    private String groupName;//组织名称
    private Boolean isDel;//是否删除
    private String username;//用户名
    private Date createDate;//创建时间
    private Date updateDate;//修改时间

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getDocumentPosition() {
        return documentPosition;
    }

    public void setDocumentPosition(String documentPosition) {
        this.documentPosition = documentPosition;
    }

    public String getStoreType() {
        return storeType;
    }

    public void setStoreType(String storeType) {
        this.storeType = storeType;
    }

    public String getSaPrefix() {
        return saPrefix;
    }

    public void setSaPrefix(String saPrefix) {
        this.saPrefix = saPrefix;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getPositionX() {
        return positionX;
    }

    public void setPositionX(String positionX) {
        this.positionX = positionX;
    }

    public String getPositionY() {
        return positionY;
    }

    public void setPositionY(String positionY) {
        this.positionY = positionY;
    }

    public String getHdPosition() {
        return hdPosition;
    }

    public void setHdPosition(String hdPosition) {
        this.hdPosition = hdPosition;
    }

    public Boolean getDel() {
        return isDel;
    }

    public void setDel(Boolean del) {
        isDel = del;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
