/**
 * 
 */
package org.danyuan.application.bean.user;

import java.util.Date;
import java.util.UUID;

import org.danyuan.application.common.utils.string.DateUtils;

/**
 * @author Administrator
 */
public class SysUserCarInfo {
	// 用户车辆车型信息
	private String	TABLE_NAME	= "SYS_USER_CAR_INFO";
	private String	uuid;
	private String	baseUuid;
	private String	姓名;
	private String	准驾车型;
	private String	入库时间;
	private String	数据来源;
	private Date	insertDate;
	private Date	updateDate;
	
	public String getUuid() {
		return uuid;
	}
	
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public String getBaseUuid() {
		return baseUuid;
	}
	
	public void setBaseUuid(String baseUuid) {
		this.baseUuid = baseUuid;
	}
	
	public String get姓名() {
		return 姓名;
	}
	
	public void set姓名(String 姓名) {
		this.姓名 = 姓名;
	}
	
	public String get准驾车型() {
		return 准驾车型;
	}
	
	public void set准驾车型(String 准驾车型) {
		this.准驾车型 = 准驾车型;
	}
	
	public String get入库时间() {
		return 入库时间;
	}
	
	public void set入库时间(String 入库时间) {
		this.入库时间 = 入库时间;
	}
	
	public String get数据来源() {
		return 数据来源;
	}
	
	public void set数据来源(String 数据来源) {
		this.数据来源 = 数据来源;
	}
	
	public Date getInsertDate() {
		return insertDate;
	}
	
	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}
	
	public Date getUpdateDate() {
		return updateDate;
	}
	
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	public SysUserCarInfo() {
		super();
	}
	
	public SysUserCarInfo(String baseUuid) {
		super();
		this.baseUuid = baseUuid;
	}
	
	public SysUserCarInfo(String uuid, String baseUuid) {
		super();
		this.uuid = uuid;
		this.baseUuid = baseUuid;
	}
	
	@Override
	public String toString() {
		return "SysUserCarInfo [uuid=" + uuid + ", baseUuid=" + baseUuid + ", 姓名=" + 姓名 + ", 准驾车型=" + 准驾车型 + ", 入库时间=" + 入库时间 + ", 数据来源=" + 数据来源 + "]";
	}
	
	public String saveOrUpdateSql() {
		if (this.uuid == null) {
			return this.saveSql(UUID.randomUUID().toString().replace("-", ""));
		} else {
			return this.updateSql();
		}
	}
	
	private String updateSql() {
		if (this.uuid == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE " + this.TABLE_NAME + " SET UPDATE_DATE='" + DateUtils.getDateTime() + "'");
		if (this.baseUuid != null) {
			sb.append(",BASE_UUID='" + this.baseUuid + "'");
		}
		if (this.姓名 != null) {
			sb.append(",姓名='" + this.姓名 + "'");
		}
		if (this.准驾车型 != null) {
			sb.append(",准驾车型='" + this.准驾车型 + "'");
		}
		if (this.入库时间 != null) {
			sb.append(",入库时间='" + this.入库时间 + "'");
		}
		if (this.数据来源 != null) {
			sb.append(",数据来源='" + this.数据来源 + "'");
		}
		sb.append(" WHERE UUID='" + this.uuid + "'");
		
		return sb.toString();
	}
	
	private String saveSql(String uuid) {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO " + this.TABLE_NAME + "(UUID");
		if (this.baseUuid != null) {
			sb.append(",BASE_UUID");
		}
		if (this.姓名 != null) {
			sb.append(",姓名");
		}
		if (this.准驾车型 != null) {
			sb.append(",准驾车型");
		}
		if (this.入库时间 != null) {
			sb.append(",入库时间");
		}
		if (this.数据来源 != null) {
			sb.append(",数据来源");
		}
		sb.append(",INSERT_DATE ) VALUES('" + uuid + "'");
		if (this.baseUuid != null) {
			sb.append(",'" + this.baseUuid + "'");
		}
		if (this.姓名 != null) {
			sb.append(",'" + this.姓名 + "'");
		}
		if (this.准驾车型 != null) {
			sb.append(",'" + this.准驾车型 + "'");
		}
		if (this.入库时间 != null) {
			sb.append(",'" + this.入库时间 + "'");
		}
		if (this.数据来源 != null) {
			sb.append(",'" + this.数据来源 + "'");
		}
		sb.append(",'" + DateUtils.getDateTime() + "')");
		return sb.toString();
	}
	
	/** 标准结构表 含有主键字段为 "uuid" */
	public String delSql(String uuid, String tableName) {
		return " DELETE FROM " + tableName + " WHERE UUID='" + uuid + "'";
	}
	
	/** 安身份证号拼写查询语句 */
	public String selectSql() {
		return "SELECT * FROM " + this.TABLE_NAME + " WHERE base_uuid='" + this.baseUuid + "'";
	}
	
}
