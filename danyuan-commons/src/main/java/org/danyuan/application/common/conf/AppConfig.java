package org.danyuan.application.common.conf;

import java.util.Date;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 文件名 ： AppConfig.java
 * 包 名 ： org.danyuan.application.common.conf
 * 描 述 ： TODO(用一句话描述该文件做什么)
 * 机能名称：
 * 技能ID ：
 * 作 者 ： Administrator
 * 时 间 ： 2021年8月11日 上午8:37:24
 * 版 本 ： V1.0
 */
@Component
@ConfigurationProperties(prefix = "app")
public class AppConfig {
	
	private String	name;
	private String	version;
	private String	developer;
	private String	springBootVersion;
	private String	springCloudVersion;
	private Date	buildTime;
	private Date	runTime	= new Date();
	
	/**
	 * 方法名 ： getName
	 * 功 能 ： 返回变量 name 的值
	 * 
	 * @return: String
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 方法名 ： setName
	 * 功 能 ： 设置变量 name 的值
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 方法名 ： getVersion
	 * 功 能 ： 返回变量 version 的值
	 * 
	 * @return: String
	 */
	public String getVersion() {
		return version;
	}
	
	/**
	 * 方法名 ： setVersion
	 * 功 能 ： 设置变量 version 的值
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	
	/**
	 * 方法名 ： getDeveloper
	 * 功 能 ： 返回变量 developer 的值
	 * 
	 * @return: String
	 */
	public String getDeveloper() {
		return developer;
	}
	
	/**
	 * 方法名 ： setDeveloper
	 * 功 能 ： 设置变量 developer 的值
	 */
	public void setDeveloper(String developer) {
		this.developer = developer;
	}
	
	/**
	 * 方法名 ： getSpringBootVersion
	 * 功 能 ： 返回变量 springBootVersion 的值
	 * 
	 * @return: String
	 */
	public String getSpringBootVersion() {
		return springBootVersion;
	}
	
	/**
	 * 方法名 ： setSpringBootVersion
	 * 功 能 ： 设置变量 springBootVersion 的值
	 */
	public void setSpringBootVersion(String springBootVersion) {
		this.springBootVersion = springBootVersion;
	}
	
	/**
	 * 方法名 ： getSpringCloudVersion
	 * 功 能 ： 返回变量 springCloudVersion 的值
	 * 
	 * @return: String
	 */
	public String getSpringCloudVersion() {
		return springCloudVersion;
	}
	
	/**
	 * 方法名 ： setSpringCloudVersion
	 * 功 能 ： 设置变量 springCloudVersion 的值
	 */
	public void setSpringCloudVersion(String springCloudVersion) {
		this.springCloudVersion = springCloudVersion;
	}
	
	/**
	 * 方法名 ： getBuildTime
	 * 功 能 ： 返回变量 buildTime 的值
	 * 
	 * @return: Date
	 */
	public Date getBuildTime() {
		return buildTime;
	}
	
	/**
	 * 方法名 ： setBuildTime
	 * 功 能 ： 设置变量 buildTime 的值
	 */
	public void setBuildTime(Date buildTime) {
		this.buildTime = buildTime;
	}
	
	/**
	 * 方法名 ： getRunTime
	 * 功 能 ： 返回变量 runTime 的值
	 * 
	 * @return: Date
	 */
	public Date getRunTime() {
		return runTime;
	}
	
	/**
	 * 方法名 ： setRunTime
	 * 功 能 ： 设置变量 runTime 的值
	 */
	public void setRunTime(Date runTime) {
		this.runTime = runTime;
	}
	
}
