package org.danyuan.application.job;

import java.util.UUID;

import javax.persistence.Id;

/**
 * @文件名 XiaoShuo.java
 * @包名 org.danyuan.application.job
 * @描述 TODO(用一句话描述该文件做什么)
 * @时间 2019年11月1日 上午11:21:59
 * @author Administrator
 * @版本 V1.0
 */
//@EntiTY
//@TABLE(NAME = "xiao_suo")
public class XiaoShuo {
	@Id
	private String	id;
	private String	nameString;
	private String	autherString;
	private String	msgString;
	private String	instroString;
	private String	urlString;
	private String	picString;

	/**
	 * @方法名 getNameString
	 * @功能 返回变量 nameString 的值
	 * @return String
	 */
	public String getNameString() {
		return nameString;
	}

	/**
	 * @方法名 setNameString
	 * @功能 设置变量 nameString 的值
	 */
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}

	/**
	 * @方法名 getAutherString
	 * @功能 返回变量 autherString 的值
	 * @return String
	 */
	public String getAutherString() {
		return autherString;
	}

	/**
	 * @方法名 setAutherString
	 * @功能 设置变量 autherString 的值
	 */
	public void setAutherString(String autherString) {
		this.autherString = autherString;
	}

	/**
	 * @方法名 getInstroString
	 * @功能 返回变量 instroString 的值
	 * @return String
	 */
	public String getInstroString() {
		return instroString;
	}

	/**
	 * @方法名 setInstroString
	 * @功能 设置变量 instroString 的值
	 */
	public void setInstroString(String instroString) {
		this.instroString = instroString;
	}

	/**
	 * @方法名 getPicString
	 * @功能 返回变量 picString 的值
	 * @return String
	 */
	public String getPicString() {
		return picString;
	}

	/**
	 * @方法名 setPicString
	 * @功能 设置变量 picString 的值
	 */
	public void setPicString(String picString) {
		this.picString = picString;
	}
	
	/**
	 * @方法名 getUrlString
	 * @功能 返回变量 urlString 的值
	 * @return String
	 */
	public String getUrlString() {
		return urlString;
	}
	
	/**
	 * @方法名 setUrlString
	 * @功能 设置变量 urlString 的值
	 */
	public void setUrlString(String urlString) {
		this.urlString = urlString;
	}

	/**
	 * @方法名 getMsgString
	 * @功能 返回变量 msgString 的值
	 * @return String
	 */
	public String getMsgString() {
		return msgString;
	}

	/**
	 * @方法名 setMsgString
	 * @功能 设置变量 msgString 的值
	 */
	public void setMsgString(String msgString) {
		this.msgString = msgString;
	}
	
	/**
	 * @方法名 getId
	 * @功能 返回变量 id 的值
	 * @return String
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * @方法名 setId
	 * @功能 设置变量 id 的值
	 */
	public void setId(String id) {
		if (id == null) {
			this.id = UUID.randomUUID().toString();
		}
		this.id = id;
	}
	
	/**
	 * TODO(这里用一句话描述这个方法的作用)
	 *
	 * @方法名 toString
	 * @参数 @return
	 * @参考 @see java.lang.Object#toString()
	 * @author Administrator
	 */
	
	@Override
	public String toString() {
		return "XiaoShuo [nameString=" + nameString + ", autherString=" + autherString + ", msgString=" + msgString + ", instroString=" + instroString + ", urlString=" + urlString + ", picString=" + picString + "]";
	}

}
