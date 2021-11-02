package org.danyuan.application.dbms.tabs.po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 文件名 ： SysDbmsTabsInfoResult.java
 * 包 名 ： org.danyuan.application.dbms.tabs.po
 * 描 述 ： TODO(用一句话描述该文件做什么)
 * 机能名称：
 * 技能ID ：
 * 作 者 ： Administrator
 * 时 间 ： 2021年11月2日 下午4:22:19
 * 版 本 ： V1.0
 */
@Entity
public class SysDbmsTabsInfoResult implements Serializable {
	
	@Id
	@Column(name = "uuid")
	private String	uuid;
	// 数据库表空间大小
	@Column(name = "db_type")
	private String	dbType;
	
	// 数据库表id
	@Column(name = "jdbc_uuid")
	private String	jdbcUuid;
	
	// 数据库表数据量
	@Column(name = "tabs_rows", precision = 10)
	private Integer	tabsRows;
	
	// 数据库表名
	@Column(name = "tabs_name")
	private String	tabsName;
	
	// 数据库表类型id
	@Column(name = "type_uuid")
	private String	typeUuid;
	
	// 表的含义
	@Column(name = "tabs_desc")
	private String	tabsDesc;
	
	/**
	 * 方法名 ： getUuid
	 * 功 能 ： 返回变量 uuid 的值
	 * 
	 * @return: String
	 */
	public String getUuid() {
		return uuid;
	}
	
	/**
	 * 方法名 ： setUuid
	 * 功 能 ： 设置变量 uuid 的值
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	/**
	 * 方法名 ： getDbType
	 * 功 能 ： 返回变量 dbType 的值
	 * 
	 * @return: String
	 */
	public String getDbType() {
		return dbType;
	}
	
	/**
	 * 方法名 ： setDbType
	 * 功 能 ： 设置变量 dbType 的值
	 */
	public void setDbType(String dbType) {
		this.dbType = dbType;
	}
	
	/**
	 * 方法名 ： getJdbcUuid
	 * 功 能 ： 返回变量 jdbcUuid 的值
	 * 
	 * @return: String
	 */
	public String getJdbcUuid() {
		return jdbcUuid;
	}
	
	/**
	 * 方法名 ： setJdbcUuid
	 * 功 能 ： 设置变量 jdbcUuid 的值
	 */
	public void setJdbcUuid(String jdbcUuid) {
		this.jdbcUuid = jdbcUuid;
	}
	
	/**
	 * 方法名 ： getTabsRows
	 * 功 能 ： 返回变量 tabsRows 的值
	 * 
	 * @return: Integer
	 */
	public Integer getTabsRows() {
		return tabsRows;
	}
	
	/**
	 * 方法名 ： setTabsRows
	 * 功 能 ： 设置变量 tabsRows 的值
	 */
	public void setTabsRows(Integer tabsRows) {
		this.tabsRows = tabsRows;
	}
	
	/**
	 * 方法名 ： getTabsName
	 * 功 能 ： 返回变量 tabsName 的值
	 * 
	 * @return: String
	 */
	public String getTabsName() {
		return tabsName;
	}
	
	/**
	 * 方法名 ： setTabsName
	 * 功 能 ： 设置变量 tabsName 的值
	 */
	public void setTabsName(String tabsName) {
		this.tabsName = tabsName;
	}
	
	/**
	 * 方法名 ： getTypeUuid
	 * 功 能 ： 返回变量 typeUuid 的值
	 * 
	 * @return: String
	 */
	public String getTypeUuid() {
		return typeUuid;
	}
	
	/**
	 * 方法名 ： setTypeUuid
	 * 功 能 ： 设置变量 typeUuid 的值
	 */
	public void setTypeUuid(String typeUuid) {
		this.typeUuid = typeUuid;
	}
	
	/**
	 * 方法名 ： getTabsDesc
	 * 功 能 ： 返回变量 tabsDesc 的值
	 * 
	 * @return: String
	 */
	public String getTabsDesc() {
		return tabsDesc;
	}
	
	/**
	 * 方法名 ： setTabsDesc
	 * 功 能 ： 设置变量 tabsDesc 的值
	 */
	public void setTabsDesc(String tabsDesc) {
		this.tabsDesc = tabsDesc;
	}
	
}
