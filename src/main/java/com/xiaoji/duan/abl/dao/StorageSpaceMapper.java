package com.xiaoji.duan.abl.dao;

import com.xiaoji.duan.abl.model.AblDocument;
import com.xiaoji.duan.abl.model.AblStorageSpace;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

public interface StorageSpaceMapper extends BaseMapper<AblStorageSpace> {
    @Select("select * from abl_storage_space where memory_type = #{memoryType} AND is_used = #{isUsed} AND is_del = #{isDel}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "space_name", property = "spaceName"),
            @Result(column = "space_path", property = "spacePath"),
            @Result(column = "memory_type", property = "memoryType"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(column = "is_used", property = "isUsed"),
            @Result(column = "is_del", property = "isDel"),
            @Result(column = "local_path", property = "localPath"),
            @Result(column = "create_date", property = "createDate"),
            @Result(column = "update_date", property = "updateDate")
    })
    public List<AblStorageSpace> selectSpace(AblStorageSpace storageSpace);

}
