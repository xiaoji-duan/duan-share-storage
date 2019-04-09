package com.xiaoji.duan.abl.service.db;

public class CreateTable extends AbstractSql {

    public CreateTable() {
        initDdl();
    }

    private void initDdl() {
        ddl.add("CREATE TABLE IF NOT EXISTS `abl_document` (\n" +
                " `id` int(11) NOT NULL AUTO_INCREMENT,\n" +
                "  `document_name` varchar(128) NOT NULL,\n" +
                "  `document_position` varchar(1024) NOT NULL,\n" +
                "  `position_x` varchar(2) NOT NULL,\n" +
                "  `position_y` varchar(64) NOT NULL,\n" +
                "  `create_date` datetime DEFAULT NULL,\n" +
                "  `update_date` datetime DEFAULT NULL,\n" +
                "  `hd_position` varchar(128) NOT NULL,\n" +
                "  `is_del` int(11) NOT NULL,\n" +
                "  `sa_prefix` varchar(128) NOT NULL,\n" +
                "  `group_name` varchar(128) NOT NULL,\n" +
                "  `store_type` varchar(128) DEFAULT NULL,\n" +
                "  `username` varchar(128) NOT NULL,\n" +
                "  PRIMARY KEY (`id`)\n" +
                ") ENGINE=InnoDB AUTO_INCREMENT=126 DEFAULT CHARSET=utf8");

    }
}
