package com.xiaoji.duan.abl.service;

import com.xiaoji.duan.abl.model.AblDocument;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

/**
 * @author xielingjun
 */
public interface StoreService {
    Long upload(List<MultipartFile> files,String saPrefix,String group,String storeTtype,String username);
    AblDocument selectDocById(Long id);
    List<AblDocument> selectIdsByGroup(String group,String username);
    void delDocById(Long id,String group);
}
