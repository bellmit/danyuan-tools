package org.danyuan.application.task.init;

import org.danyuan.application.bean.manager.dbms.SysDbmsTabsJdbcInfo;
import org.danyuan.application.fegin.ServeFegin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * 文件名 ： AppInfo.java
 * 包 名 ： org.danyuan.application.task.init
 * 描 述 ： TODO(用一句话描述该文件做什么)
 * 机能名称：
 * 技能ID ：
 * 作 者 ： Administrator
 * 时 间 ： 2021年9月6日 下午3:16:08
 * 版 本 ： V1.0
 */
@Component
public class AppInfo implements ApplicationRunner {
	
	@Value("${spring.datasource.platform}")
	private String		plantform;
	@Value("${spring.datasource.driver-class-name}")
	private String		driverClassName;
	@Value("${spring.datasource.url}")
	private String		url;
	@Value("${spring.datasource.username}")
	private String		username;
	@Value("${spring.datasource.password}")
	private String		password;
	@Value("${server.ip:'localhost'}")
	private String		ip;
	@Value("${server.port:''}")
	private String		port;
	@Value("${spring.application.name}")
	private String		id;
	
	@Autowired
	private ServeFegin	serveFegin;
	
	/**
	 * 方法名 ： run
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @param args
	 * 参 数 ： @throws Exception
	 * 参 考 ： @see org.springframework.boot.ApplicationRunner#run(org.springframework.boot.ApplicationArguments)
	 * 作 者 ： Administrator
	 */
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		SysDbmsTabsJdbcInfo info = new SysDbmsTabsJdbcInfo();
		info.setUuid(id);
		info.setDbType(plantform);
		info.setDriver(driverClassName);
		info.setUsername(username);
		info.setPassword(password);
		info.setIp(ip);
		info.setPort(port);
		
		serveFegin.save(info);
		
	}
	
}
