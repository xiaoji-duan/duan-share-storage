package com.xiaoji.duan.abl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement//开启事务处理
@MapperScan(value = "com.xiaoji.duan.abl.dao")//mapper包扫描
@EnableAsync  //线程池注解
public class AblApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(AblApplication.class, args);
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(AblApplication.class);
	}
}
