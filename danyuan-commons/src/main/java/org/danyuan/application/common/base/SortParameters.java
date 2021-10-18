package org.danyuan.application.common.base;

/**
 * 文件名 ： OrderParameters.java
 * 包 名 ： org.danyuan.application.common.base
 * 描 述 ： TODO(用一句话描述该文件做什么)
 * 机能名称：
 * 技能ID ：
 * 作 者 ： Administrator
 * 时 间 ： 2021年10月18日 下午5:36:50
 * 版 本 ： V1.0
 */
public class SortParameters {
	
	public Integer	order;		// 顺序
	public String	sortName;	// 排序字段
	public String	sortOrder;	// 排序方式 desc，asc default asc
	
	/**
	 * 方法名 ： getOrder
	 * 功 能 ： 返回变量 order 的值
	 * @return: Integer
	 */
	public Integer getOrder() {
		return order;
	}
	
	/**
	 * 方法名 ： setOrder
	 * 功 能 ： 设置变量 order 的值
	 */
	public void setOrder(Integer order) {
		this.order = order;
	}
	
	/**
	 * 方法名 ： getSortName
	 * 功 能 ： 返回变量 sortName 的值
	 * @return: String
	 */
	public String getSortName() {
		return sortName;
	}
	
	/**
	 * 方法名 ： setSortName
	 * 功 能 ： 设置变量 sortName 的值
	 */
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}
	
	/**
	 * 方法名 ： getSortOrder
	 * 功 能 ： 返回变量 sortOrder 的值
	 * @return: String
	 */
	public String getSortOrder() {
		return sortOrder;
	}
	
	/**
	 * 方法名 ： setSortOrder
	 * 功 能 ： 设置变量 sortOrder 的值
	 */
	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}
	
}
