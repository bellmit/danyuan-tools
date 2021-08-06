/**
 * 
 */
package org.danyuan.application.bean.user;

import java.util.Date;
import java.util.UUID;

import org.danyuan.application.common.utils.DateUtils;

/**
 * @author Administrator
 *
 */
public class SysUserTrain {
	// 用户培训经历
	private String TABLE_NAME = "SYS_USER_TRAIN";

	private String uuid;
	private String baseUuid;
	private String 姓名;
	private String 开始时间;
	private String 结束时间;
	private String 培训学校;
	private String 培训内容;
	private String 证书;
	private String 说明;
	private String 入库时间;
	private String 数据来源;
	private Date insertDate;
	private Date updateDate;

	public String getTABLE_NAME() {
		return TABLE_NAME;
	}

	public void setTABLE_NAME(String tABLE_NAME) {
		TABLE_NAME = tABLE_NAME;
	}

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

	public String get开始时间() {
		return 开始时间;
	}

	public void set开始时间(String 开始时间) {
		this.开始时间 = 开始时间;
	}

	public String get结束时间() {
		return 结束时间;
	}

	public void set结束时间(String 结束时间) {
		this.结束时间 = 结束时间;
	}

	public String get培训学校() {
		return 培训学校;
	}

	public void set培训学校(String 培训学校) {
		this.培训学校 = 培训学校;
	}

	public String get培训内容() {
		return 培训内容;
	}

	public void set培训内容(String 培训内容) {
		this.培训内容 = 培训内容;
	}

	public String get证书() {
		return 证书;
	}

	public void set证书(String 证书) {
		this.证书 = 证书;
	}

	public String get说明() {
		return 说明;
	}

	public void set说明(String 说明) {
		this.说明 = 说明;
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

	@Override
	public String toString() {
		return "SysUserTrain [TABLE_NAME=" + TABLE_NAME + ", uuid=" + uuid + ", baseUuid=" + baseUuid + ", 姓名=" + 姓名 + ", 开始时间=" + 开始时间 + ", 结束时间=" + 结束时间 + ", 培训学校=" + 培训学校 + ", 培训内容=" + 培训内容 + ", 证书=" + 证书 + ", 说明=" + 说明 + ", 入库时间=" + 入库时间 + ", 数据来源=" + 数据来源 + ", insertDate=" + insertDate + ", updateDate=" + updateDate + "]";
	}

	public SysUserTrain() {
		super();
	}

	public SysUserTrain(String uuid) {
		super();
		this.uuid = uuid;
	}

	public SysUserTrain(String uuid, String baseUuid) {
		super();
		this.uuid = uuid;
		this.baseUuid = baseUuid;
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
		if (this.开始时间 != null) {
			sb.append(",开始时间='" + this.开始时间 + "'");
		}
		if (this.结束时间 != null) {
			sb.append(",结束时间='" + this.结束时间 + "'");
		}
		if (this.培训学校 != null) {
			sb.append(",培训学校='" + this.培训学校 + "'");
		}
		if (this.培训内容 != null) {
			sb.append(",培训内容='" + this.培训内容 + "'");
		}
		if (this.证书 != null) {
			sb.append(",证书='" + this.证书 + "'");
		}
		if (this.说明 != null) {
			sb.append(",说明='" + this.说明 + "'");
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
		if (this.开始时间 != null) {
			sb.append(",开始时间");
		}
		if (this.结束时间 != null) {
			sb.append(",结束时间");
		}
		if (this.培训学校 != null) {
			sb.append(",培训学校");
		}
		if (this.培训内容 != null) {
			sb.append(",培训内容");
		}
		if (this.证书 != null) {
			sb.append(",证书");
		}
		if (this.说明 != null) {
			sb.append(",说明");
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
		if (this.开始时间 != null) {
			sb.append(",'" + this.开始时间 + "'");
		}
		if (this.结束时间 != null) {
			sb.append(",'" + this.结束时间 + "'");
		}
		if (this.培训学校 != null) {
			sb.append(",'" + this.培训学校 + "'");
		}
		if (this.培训内容 != null) {
			sb.append(",'" + this.培训内容 + "'");
		}
		if (this.证书 != null) {
			sb.append(",'" + this.证书 + "'");
		}
		if (this.说明 != null) {
			sb.append(",'" + this.说明 + "'");
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
