package com.xiaoji.duan.abl.dao;

import com.xiaoji.duan.abl.model.AblDocument;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;
import java.util.Map;

public interface DocumentMapper extends BaseMapper<AblDocument> {
    @Insert("INSERT INTO abl_document (document_name, document_position, position_x, position_y, create_date, update_date, hd_position, is_del, sa_prefix, group_name, store_type,username) " +
            "VALUES (#{documentName}, #{documentPosition}, #{positionX}, #{positionY}, #{createDate}, #{updateDate}, #{hdPosition}, #{isDel}, #{saPrefix}, #{groupName}, #{storeType},#{username});")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    public Long insertDocInfo(AblDocument document);

    @Select("select * from abl_document where id=#{id} and is_del = 0")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "document_name", property = "documentName"),
            @Result(column = "document_position", property = "documentPosition"),
            @Result(column = "position_x", property = "positionX"),
            @Result(column = "position_y", property = "positionY"),
            @Result(column = "hd_position", property = "hdPosition"),
            @Result(column = "store_type", property = "storeType"),
            @Result(column = "sa_prefix", property = "saPrefix"),
            @Result(column = "group_name", property = "groupName"),
            @Result(column = "username", property = "username"),
            @Result(column = "is_del", property = "isDel"),
            @Result(column = "create_date", property = "createDate"),
            @Result(column = "update_date", property = "updateDate")
    })
    public AblDocument selectDocById(@Param("id") Long id);

    @Select("<script>select id,document_name,username from abl_document where group_name=#{groupName} and is_del = 0 and sa_prefix='abl' <if test=\" username!=null and username!='' and username!='null'\"> and username = #{username}</if></script>")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "document_name", property = "documentName"),
            @Result(column = "username", property = "username")
    })
    public List<AblDocument> selectIdByGroup(@Param("groupName") String groupName,@Param("username") String username);
}
