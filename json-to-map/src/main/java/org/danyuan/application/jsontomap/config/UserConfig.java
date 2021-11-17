package org.danyuan.application.jsontomap.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 文件名 ： UserConfig.java
 * 包 名 ： org.danyuan.application.jsontomap.config
 * 描 述 ： TODO(用一句话描述该文件做什么)
 * 机能名称：
 * 技能ID ：
 * 作 者 ： Administrator
 * 时 间 ： 2021年11月3日 上午10:21:16
 * 版 本 ： V1.0
 */
@Configuration
@ConfigurationProperties(prefix = "user")
public class UserConfig {
	
	private String			path;
	private String			dic;
	private List<String>	files;
	
	/**
	 * 方法名 ： getPath
	 * 功 能 ： 返回变量 path 的值
	 * 
	 * @return: String
	 */
	public String getPath() {
		return path;
	}
	
	/**
	 * 方法名 ： setPath
	 * 功 能 ： 设置变量 path 的值
	 */
	public void setPath(String path) {
		this.path = path;
	}
	
	/**
	 * 方法名 ： getDic
	 * 功 能 ： 返回变量 dic 的值
	 * 
	 * @return: String
	 */
	public String getDic() {
		return dic;
	}
	
	/**
	 * 方法名 ： setDic
	 * 功 能 ： 设置变量 dic 的值
	 */
	public void setDic(String dic) {
		this.dic = dic;
	}
	
	/**
	 * 方法名 ： getFiles
	 * 功 能 ： 返回变量 files 的值
	 * 
	 * @return: List<String>
	 */
	public List<String> getFiles() {
		return files;
	}
	
	/**
	 * 方法名 ： setFiles
	 * 功 能 ： 设置变量 files 的值
	 */
	public void setFiles(List<String> files) {
		this.files = files;
	}
	
	/**
	 * 方法名 ： toString
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @return
	 * 参 考 ： @see java.lang.Object#toString()
	 * 作 者 ： Administrator
	 */
	
	@Override
	public String toString() {
		return "UserConfig [path=" + path + ", dic=" + dic + ", files=" + files + "]";
	}
	
}
