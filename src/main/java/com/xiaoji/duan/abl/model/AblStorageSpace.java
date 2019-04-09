package com.xiaoji.duan.abl.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

public class AblStorageSpace implements Serializable {
    private static final long serialVersionUID = 760746998511050073L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//存储库id
    private String spaceName;//存储空间名称
    private String spacePath;//存储空间路径
    private String memoryType;//存储类型
    private String username;//存储空间访问账号
    private String password;//存储空间访问密码
    private String localPath;//mount路径
    private Boolean isUsed;//是否启用
    private Boolean isDel;//是否删除
    private Date createDate;//创建时间
    private Date updateDate;//修改时间

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpaceName() {
        return spaceName;
    }

    public void setSpaceName(String spaceName) {
        this.spaceName = spaceName;
    }

    public String getSpacePath() {
        return spacePath;
    }

    public void setSpacePath(String spacePath) {
        this.spacePath = spacePath;
    }

    public String getMemoryType() {
        return memoryType;
    }

    public void setMemoryType(String memoryType) {
        this.memoryType = memoryType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLocalPath() {
        return localPath;
    }

    public void setLocalPath(String localPath) {
        this.localPath = localPath;
    }

    public Boolean getUsed() {
        return isUsed;
    }

    public void setUsed(Boolean used) {
        isUsed = used;
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

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
