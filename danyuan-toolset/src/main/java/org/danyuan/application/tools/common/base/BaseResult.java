package org.danyuan.application.tools.common.base;

/**
 * 文件名： BaseResult.java
 * 包 名： org.danyuan.application.common.base
 * 描 述： 通用数据返回格式
 * 时 间： 2019年1月16日 下午5:18:12
 * 作 者: Administrator
 * 版 本： V1.0
 */
public class BaseResult<T> {

	// 返回代码
	private Integer	code;
	// 返回消息
	private String	msg;
	// 返回数据
	private T		data;
	
	public Integer getCode() {
		return code;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	/**
	 * 方法名 setCode
	 * 功 能: 设置变量 code 的值
	 */
	public void setCode(Integer code) {
		this.code = code;
	}

}
