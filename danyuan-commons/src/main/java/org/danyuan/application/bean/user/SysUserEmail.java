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
public class SysUserEmail {
	// 用户邮箱信息
	private String TABLE_NAME = "SYS_USER_EMAIL";

	private String uuid;
	private String baseUuid;
	private String 姓名;
	private String email;
	private String 密码提示答案;
	private String 密码提示问题;
	private String 注册时间;
	private String 密码;
	private String 入库时间;
	private String 数据来源;
	private Date insertDate;
	private Date updateDate;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String get密码提示答案() {
		return 密码提示答案;
	}

	public void set密码提示答案(String 密码提示答案) {
		this.密码提示答案 = 密码提示答案;
	}

	public String get密码提示问题() {
		return 密码提示问题;
	}

	public void set密码提示问题(String 密码提示问题) {
		this.密码提示问题 = 密码提示问题;
	}

	public String get注册时间() {
		return 注册时间;
	}

	public void set注册时间(String 注册时间) {
		this.注册时间 = 注册时间;
	}

	public String get密码() {
		return 密码;
	}

	public void set密码(String 密码) {
		this.密码 = 密码;
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

	public SysUserEmail() {
		super();
	}

	public SysUserEmail(String uuid) {
		super();
		this.uuid = uuid;
	}

	public SysUserEmail(String uuid, String baseUuid) {
		super();
		this.uuid = uuid;
		this.baseUuid = baseUuid;
	}

	@Override
	public String toString() {
		return "SysUserEmail [uuid=" + uuid + ", baseUuid=" + baseUuid + ", 姓名=" + 姓名 + ", EMAIL=" + email + ", 密码提示答案=" + 密码提示答案 + ", 密码提示问题=" + 密码提示问题 + ", 注册时间=" + 注册时间 + ", 密码=" + 密码 + ", 入库时间=" + 入库时间 + ", 数据来源=" + 数据来源 + ", insertDate=" + insertDate + ", updateDate=" + updateDate + "]";
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
		if (this.email != null) {
			sb.append(",EMAIL='" + this.email + "'");
		}
		if (this.密码提示答案 != null) {
			sb.append(",密码提示答案='" + this.密码提示答案 + "'");
		}
		if (this.密码提示问题 != null) {
			sb.append(",密码提示问题='" + this.密码提示问题 + "'");
		}
		if (this.注册时间 != null) {
			sb.append(",注册时间='" + this.注册时间 + "'");
		}
		if (this.密码 != null) {
			sb.append(",密码='" + this.密码 + "'");
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
		if (this.email != null) {
			sb.append(",EMAIL");
		}
		if (this.密码提示答案 != null) {
			sb.append(",密码提示答案");
		}
		if (this.密码提示问题 != null) {
			sb.append(",密码提示问题");
		}
		if (this.注册时间 != null) {
			sb.append(",注册时间");
		}
		if (this.密码 != null) {
			sb.append(",密码");
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
		if (this.email != null) {
			sb.append(",'" + this.email + "'");
		}
		if (this.密码提示答案 != null) {
			sb.append(",'" + this.密码提示答案 + "'");
		}
		if (this.密码提示问题 != null) {
			sb.append(",'" + this.密码提示问题 + "'");
		}
		if (this.注册时间 != null) {
			sb.append(",'" + this.注册时间 + "'");
		}
		if (this.密码 != null) {
			sb.append(",'" + this.密码 + "'");
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
