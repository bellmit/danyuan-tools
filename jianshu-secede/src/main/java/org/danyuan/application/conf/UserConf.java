/**
 *
 */
package org.danyuan.application.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 文件名 ： UserConf.java
 * 包 名 ： org.danyuan.application.conf
 * 描 述 ： TODO(用一句话描述该文件做什么)
 * 机能名称：
 * 技能ID ：
 * 作 者 ： wth
 * 时 间 ： 2021年8月15日 上午10:55:42
 * 版 本 ： V1.0
 */
@Component
@ConfigurationProperties(value = "user")
public class UserConf {
	
	private String	oldPath;
	private String	newPath;
	private String	imgPath;
	private String	rootPath;

	/**
	 * 方法名 ： getOldPath
	 * 功 能 ： 返回变量 oldPath 的值
	 * @return: String
	 */
	public String getOldPath() {
		return oldPath;
	}

	/**
	 * 方法名 ： setOldPath
	 * 功 能 ： 设置变量 oldPath 的值
	 */
	public void setOldPath(String oldPath) {
		this.oldPath = oldPath;
	}

	/**
	 * 方法名 ： getNewPath
	 * 功 能 ： 返回变量 newPath 的值
	 * @return: String
	 */
	public String getNewPath() {
		return newPath;
	}

	/**
	 * 方法名 ： setNewPath
	 * 功 能 ： 设置变量 newPath 的值
	 */
	public void setNewPath(String newPath) {
		this.newPath = newPath;
	}

	/**
	 * 方法名 ： getImgPath
	 * 功 能 ： 返回变量 imgPath 的值
	 * @return: String
	 */
	public String getImgPath() {
		return imgPath;
	}

	/**
	 * 方法名 ： setImgPath
	 * 功 能 ： 设置变量 imgPath 的值
	 */
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	/**
	 * 方法名 ： getRootPath
	 * 功 能 ： 返回变量 rootPath 的值
	 * @return: String
	 */
	public String getRootPath() {
		return rootPath;
	}

	/**
	 * 方法名 ： setRootPath
	 * 功 能 ： 设置变量 rootPath 的值
	 */
	public void setRootPath(String rootPath) {
		this.rootPath = rootPath;
	}

}
