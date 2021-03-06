package org.danyuan.application.bean.manager;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.danyuan.application.common.base.BaseEntity;
import org.springframework.data.annotation.Transient;

/**
 * @文件名 SysMenuInfo.java
 * @包名 org.danyuan.application.softm.sysmenu.po
 * @描述 sys_menu_info的实体类
 * @时间 2020年04月25日 16:38:22
 * @author test
 * @版本 V1.0
 */
@Entity
@Table(name = "sys_menu_info")
@NamedQuery(name = "SysMenuInfo.findAll", query = "SELECT s FROM SysMenuInfo s")
public class SysMenuInfo extends BaseEntity implements Serializable {
	private static final long	serialVersionUID	= 1L;
	
	// 地址资源
	@Column(name = "uri")
	private String				uri;
	
	// 显示图标样式
	@Column(name = "checked", precision = 3)
	private Integer				checked;
	
	// 系统id
	@Column(name = "system_id")
	private String				systemId;
	
	// 显示图标样式
	@Column(name = "icon")
	private String				icon;
	
	// 排序
	@Column(name = "sort", precision = 10)
	private Integer				sort;
	
	// 地址名称
	@Column(name = "name")
	private String				name;
	
	// 父id
	@Column(name = "parents_id")
	private String				parentsId;
	
	// 首页
	@Column(name = "home_page", precision = 3)
	private Boolean				homePage;
	
	// 菜单还是方法
	@Column(name = "type")
	private String				type;
	
	// 显示图标样式
	@Column(name = "icon_skin")
	private String				iconSkin;
	
	@Transient
	private String				moveType;
	
	/**
	 * 构造方法：
	 * 描 述： 默认构造函数
	 * 参 数：
	 * 作 者 ： test
	 * @throws
	 */
	public SysMenuInfo() {
		super();
	}
	
	/**
	 * 方法名 ： getUri
	 * 功 能 ： 返回变量 uri 地址资源 的值
	 * @return: String
	 */
	public String getUri() {
		return uri;
	}
	
	/**
	 * 方法名 ： setUri
	 * 功 能 ： 设置变量 uri 地址资源 的值
	 */
	public void setUri(String uri) {
		this.uri = uri;
	}
	
	/**
	 * 方法名 ： getChecked
	 * 功 能 ： 返回变量 checked 显示图标样式 的值
	 * @return: String
	 */
	public Integer getChecked() {
		return checked;
	}
	
	/**
	 * 方法名 ： setChecked
	 * 功 能 ： 设置变量 checked 显示图标样式 的值
	 */
	public void setChecked(Integer checked) {
		this.checked = checked;
	}
	
	/**
	 * 方法名 ： getSystemId
	 * 功 能 ： 返回变量 systemId 系统id 的值
	 * @return: String
	 */
	public String getSystemId() {
		return systemId;
	}
	
	/**
	 * 方法名 ： setSystemId
	 * 功 能 ： 设置变量 systemId 系统id 的值
	 */
	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}
	
	/**
	 * 方法名 ： getIcon
	 * 功 能 ： 返回变量 icon 显示图标样式 的值
	 * @return: String
	 */
	public String getIcon() {
		return icon;
	}
	
	/**
	 * 方法名 ： setIcon
	 * 功 能 ： 设置变量 icon 显示图标样式 的值
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	/**
	 * 方法名 ： getSort
	 * 功 能 ： 返回变量 sort 排序 的值
	 * @return: String
	 */
	public Integer getSort() {
		return sort;
	}
	
	/**
	 * 方法名 ： setSort
	 * 功 能 ： 设置变量 sort 排序 的值
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
	/**
	 * 方法名 ： getName
	 * 功 能 ： 返回变量 name 地址名称 的值
	 * @return: String
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 方法名 ： setName
	 * 功 能 ： 设置变量 name 地址名称 的值
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 方法名 ： getParentsId
	 * 功 能 ： 返回变量 parentsId 父id 的值
	 * @return: String
	 */
	public String getParentsId() {
		return parentsId;
	}
	
	/**
	 * 方法名 ： setParentsId
	 * 功 能 ： 设置变量 parentsId 父id 的值
	 */
	public void setParentsId(String parentsId) {
		this.parentsId = parentsId;
	}
	
	/**
	 * 方法名 ： getMoveType
	 * 功 能 ： 返回变量 moveType 的值
	 * @return: String
	 */
	public String getMoveType() {
		return moveType;
	}
	
	/**
	 * 方法名 ： setMoveType
	 * 功 能 ： 设置变量 moveType 的值
	 */
	public void setMoveType(String moveType) {
		this.moveType = moveType;
	}
	
	/**
	 * 方法名 ： getHomePage
	 * 功 能 ： 返回变量 homePage 首页 的值
	 * @return: String
	 */
	public Boolean getHomePage() {
		return homePage;
	}
	
	/**
	 * 方法名 ： setHomePage
	 * 功 能 ： 设置变量 homePage 首页 的值
	 */
	public void setHomePage(Boolean homePage) {
		this.homePage = homePage;
	}
	
	/**
	 * 方法名 ： getType
	 * 功 能 ： 返回变量 type 菜单还是方法 的值
	 * @return: String
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * 方法名 ： setType
	 * 功 能 ： 设置变量 type 菜单还是方法 的值
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * 方法名 ： getIconSkin
	 * 功 能 ： 返回变量 iconSkin 显示图标样式 的值
	 * @return: String
	 */
	public String getIconSkin() {
		return iconSkin;
	}
	
	/**
	 * 方法名 ： setIconSkin
	 * 功 能 ： 设置变量 iconSkin 显示图标样式 的值
	 */
	public void setIconSkin(String iconSkin) {
		this.iconSkin = iconSkin;
	}
	
	@Override
	public String toString() {
		return "SysMenuInfo [uuid=" + uuid + ", systemId=" + systemId + ", parentsId=" + parentsId + ", name=" + name + ", uri=" + uri + ", icon=" + icon + ", sort=" + sort + ", discription=" + discription + ", insertDatetime=" + super.createTime + ", insertUser=" + super.createUser + ", updateTime=" + updateTime + ", updateUser=" + updateUser + ", deleteFlag=" + deleteFlag + ", type=" + type + ", iconSkin=" + iconSkin + ", checked=" + checked + ", homePage=" + homePage + ", moveType=" + moveType + "]";
	}
	
}
