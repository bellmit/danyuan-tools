package org.danyuan.application.common.base;

import java.util.List;

/**
 * 文件名 ： SearchParameters.java
 * 包 名 ： org.danyuan.application.common.base
 * 描 述 ： TODO(用一句话描述该文件做什么)
 * 机能名称：
 * 技能ID ：
 * 作 者 ： Administrator
 * 时 间 ： 2021年10月18日 下午5:30:15
 * 版 本 ： V1.0
 */
public class SearchParameters {
	
	// 连接运算符 and、or
	private String					operator;
	// 字段名
	private String					column;
	// 字段名
	private String					title;
	// 连接符号
	private String					symbol;
	// 查询数据
	private String					data;
	// 括号里面的其他同条件查询
	private List<SearchParameters>	subParameters;
	
	/**
	 * 方法名 ： getOperator
	 * 功 能 ： 返回变量 operator 的值
	 * 
	 * @return: String
	 */
	public String getOperator() {
		return operator;
	}
	
	/**
	 * 方法名 ： setOperator
	 * 功 能 ： 设置变量 operator 的值
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	/**
	 * 方法名 ： getColumn
	 * 功 能 ： 返回变量 column 的值
	 * 
	 * @return: String
	 */
	public String getColumn() {
		return column;
	}
	
	/**
	 * 方法名 ： setColumn
	 * 功 能 ： 设置变量 column 的值
	 */
	public void setColumn(String column) {
		this.column = column;
	}
	
	/**
	 * 方法名 ： getSymbol
	 * 功 能 ： 返回变量 symbol 的值
	 * 
	 * @return: String
	 */
	public String getSymbol() {
		return symbol;
	}
	
	/**
	 * 方法名 ： setSymbol
	 * 功 能 ： 设置变量 symbol 的值
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	/**
	 * 方法名 ： getData
	 * 功 能 ： 返回变量 data 的值
	 * 
	 * @return: String
	 */
	public String getData() {
		return data;
	}
	
	/**
	 * 方法名 ： setData
	 * 功 能 ： 设置变量 data 的值
	 */
	public void setData(String data) {
		this.data = data;
	}
	
	/**
	 * 方法名 ： getSubParameters
	 * 功 能 ： 返回变量 subParameters 的值
	 * 
	 * @return: List<SearchParameters>
	 */
	public List<SearchParameters> getSubParameters() {
		return subParameters;
	}
	
	/**
	 * 方法名 ： setSubParameters
	 * 功 能 ： 设置变量 subParameters 的值
	 */
	public void setSubParameters(List<SearchParameters> subParameters) {
		this.subParameters = subParameters;
	}
	
	/**
	 * 方法名 ： getTitle
	 * 功 能 ： 返回变量 title 的值
	 * 
	 * @return: String
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * 方法名 ： setTitle
	 * 功 能 ： 设置变量 title 的值
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
}
