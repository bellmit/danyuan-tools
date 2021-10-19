package org.danyuan.application.common.base;

/**
 * 文件名 ： SearchSymbol.java
 * 包 名 ： org.danyuan.application.common.base
 * 描 述 ： TODO(用一句话描述该文件做什么)
 * 机能名称：
 * 技能ID ：
 * 作 者 ： Administrator
 * 时 间 ： 2021年10月19日 下午3:31:01
 * 版 本 ： V1.0
 */
public enum SearchSymbol {
	
	eq("="), less("<"), lessAndEq("<="), great(">"), greatAndEq(">=")
	// like
	, like("like")
	// in
	, in("in")
	// not in
	, notIn("not in")
	// is null
	, isNull("is null")
	// is not null
	, isNotNull("is not null")
	// is blank
	, isBlank("is blank")
	// include blank and null
	, isEmpty("is empty");
	
	private String symbol;
	
	// 构造方法
	SearchSymbol(String symbol) {
		this.symbol = symbol;
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
	
}
