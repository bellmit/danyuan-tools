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
public class SysUserBankCard {
	// 用户银行卡号
	private String TABLE_NAME = "SYS_USER_BANK_CARD";
	private String uuid;
	private String baseUuid;
	private String 姓名;
	private String 银行;
	private String 银行卡号;
	private String 银行名称;
	private String 注册时间;
	private String 账号;
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

	public String get银行() {
		return 银行;
	}

	public void set银行(String 银行) {
		this.银行 = 银行;
	}

	public String get银行卡号() {
		return 银行卡号;
	}

	public void set银行卡号(String 银行卡号) {
		this.银行卡号 = 银行卡号;
	}

	public String get银行名称() {
		return 银行名称;
	}

	public void set银行名称(String 银行名称) {
		this.银行名称 = 银行名称;
	}

	public String get注册时间() {
		return 注册时间;
	}

	public void set注册时间(String 注册时间) {
		this.注册时间 = 注册时间;
	}

	public String get账号() {
		return 账号;
	}

	public void set账号(String 账号) {
		this.账号 = 账号;
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

	public SysUserBankCard() {
		super();
	}

	public SysUserBankCard(String baseUuid) {
		super();
		this.baseUuid = baseUuid;
	}

	public SysUserBankCard(String uuid, String baseUuid) {
		super();
		this.uuid = uuid;
		this.baseUuid = baseUuid;
	}

	@Override
	public String toString() {
		return "SysUserBankCard [uuid=" + uuid + ", baseUuid=" + baseUuid + ", 姓名=" + 姓名 + ", 银行=" + 银行 + ", 银行卡号=" + 银行卡号 + ", 银行名称=" + 银行名称 + ", 注册时间=" + 注册时间 + ", 账号=" + 账号 + ", 入库时间=" + 入库时间 + ", 数据来源=" + 数据来源 + "]";
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
		if (this.银行 != null) {
			sb.append(",银行='" + this.银行 + "'");
		}
		if (this.银行卡号 != null) {
			sb.append(",银行卡号='" + this.银行卡号 + "'");
		}
		if (this.银行名称 != null) {
			sb.append(",银行名称='" + this.银行名称 + "'");
		}
		if (this.注册时间 != null) {
			sb.append(",注册时间='" + this.注册时间 + "'");
		}
		if (this.账号 != null) {
			sb.append(",账号='" + this.账号 + "'");
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
		if (this.银行 != null) {
			sb.append(",银行");
		}
		if (this.银行卡号 != null) {
			sb.append(",银行卡号");
		}
		if (this.银行名称 != null) {
			sb.append(",银行名称");
		}
		if (this.注册时间 != null) {
			sb.append(",注册时间");
		}
		if (this.账号 != null) {
			sb.append(",账号");
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
		if (this.银行 != null) {
			sb.append(",'" + this.银行 + "'");
		}
		if (this.银行卡号 != null) {
			sb.append(",'" + this.银行卡号 + "'");
		}
		if (this.银行名称 != null) {
			sb.append(",'" + this.银行名称 + "'");
		}
		if (this.注册时间 != null) {
			sb.append(",'" + this.注册时间 + "'");
		}
		if (this.账号 != null) {
			sb.append(",'" + this.账号 + "'");
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
