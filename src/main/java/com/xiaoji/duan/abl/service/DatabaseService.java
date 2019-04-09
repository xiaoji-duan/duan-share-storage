package com.xiaoji.duan.abl.service;

import com.xiaoji.duan.abl.dao.DatabaseMapper;
import com.xiaoji.duan.abl.service.db.AbstractSql;
import com.xiaoji.duan.abl.service.db.CreateTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DatabaseService {

	@Autowired
	private DatabaseMapper databaseMapper;
	
	public void initDatabase() {
		AbstractSql sql = new CreateTable();
		excute(sql.getDdl());
	}
	
	@Transactional
	public void excute(List<String> sqls) {
		for (String sql : sqls) {
			this.databaseMapper.execute(sql);
		}
	}
}
