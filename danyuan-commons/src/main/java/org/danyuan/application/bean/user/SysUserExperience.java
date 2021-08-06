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
public class SysUserExperience {
	// 用户培训经历
	private String TABLE_NAME = "SYS_USER_EXPERIENCE";

	private String uuid;
	private String baseUuid;
	private String 姓名;
	private String 项目名称;
	private String 开始时间;
	private String 结束时间;
	private String 系统环境;
	private String 开发工具;
	private String 数据库;
	private String 框架;
	private String 职责;
	private String 工作内容;
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

	public String get项目名称() {
		return 项目名称;
	}

	public void set项目名称(String 项目名称) {
		this.项目名称 = 项目名称;
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

	public String get系统环境() {
		return 系统环境;
	}

	public void set系统环境(String 系统环境) {
		this.系统环境 = 系统环境;
	}

	public String get开发工具() {
		return 开发工具;
	}

	public void set开发工具(String 开发工具) {
		this.开发工具 = 开发工具;
	}

	public String get数据库() {
		return 数据库;
	}

	public void set数据库(String 数据库) {
		this.数据库 = 数据库;
	}

	public String get框架() {
		return 框架;
	}

	public void set框架(String 框架) {
		this.框架 = 框架;
	}

	public String get职责() {
		return 职责;
	}

	public void set职责(String 职责) {
		this.职责 = 职责;
	}

	public String get工作内容() {
		return 工作内容;
	}

	public void set工作内容(String 工作内容) {
		this.工作内容 = 工作内容;
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

	public SysUserExperience() {
		super();
	}

	public SysUserExperience(String uuid) {
		super();
		this.uuid = uuid;
	}

	public SysUserExperience(String uuid, String baseUuid) {
		super();
		this.uuid = uuid;
		this.baseUuid = baseUuid;
	}

	@Override
	public String toString() {
		return "SysUserExperience [uuid=" + uuid + ", baseUuid=" + baseUuid + ", 姓名=" + 姓名 + ", 项目名称=" + 项目名称 + ", 开始时间=" + 开始时间 + ", 结束时间=" + 结束时间 + ", 系统环境=" + 系统环境 + ", 开发工具=" + 开发工具 + ", 数据库=" + 数据库 + ", 框架=" + 框架 + ", 职责=" + 职责 + ", 工作内容=" + 工作内容 + ", 入库时间=" + 入库时间 + ", 数据来源=" + 数据来源 + ", insertDate=" + insertDate + ", updateDate=" + updateDate + "]";
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
		if (this.项目名称 != null) {
			sb.append(",项目名称='" + this.项目名称 + "'");
		}
		if (this.开始时间 != null) {
			sb.append(",开始时间='" + this.开始时间 + "'");
		}
		if (this.结束时间 != null) {
			sb.append(",结束时间='" + this.结束时间 + "'");
		}
		if (this.系统环境 != null) {
			sb.append(",系统环境='" + this.系统环境 + "'");
		}
		if (this.开发工具 != null) {
			sb.append(",开发工具='" + this.开发工具 + "'");
		}
		if (this.数据库 != null) {
			sb.append(",数据库='" + this.数据库 + "'");
		}
		if (this.框架 != null) {
			sb.append(",框架='" + this.框架 + "'");
		}
		if (this.职责 != null) {
			sb.append(",职责='" + this.职责 + "'");
		}
		if (this.工作内容 != null) {
			sb.append(",工作内容='" + this.工作内容 + "'");
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
		if (this.项目名称 != null) {
			sb.append(",项目名称");
		}
		if (this.开始时间 != null) {
			sb.append(",开始时间");
		}
		if (this.结束时间 != null) {
			sb.append(",结束时间");
		}
		if (this.系统环境 != null) {
			sb.append(",系统环境");
		}
		if (this.开发工具 != null) {
			sb.append(",开发工具");
		}
		if (this.数据库 != null) {
			sb.append(",数据库");
		}
		if (this.框架 != null) {
			sb.append(",框架");
		}
		if (this.职责 != null) {
			sb.append(",职责");
		}
		if (this.工作内容 != null) {
			sb.append(",工作内容");
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
		if (this.项目名称 != null) {
			sb.append(",'" + this.项目名称 + "'");
		}
		if (this.开始时间 != null) {
			sb.append(",'" + this.开始时间 + "'");
		}
		if (this.结束时间 != null) {
			sb.append(",'" + this.结束时间 + "'");
		}
		if (this.系统环境 != null) {
			sb.append(",'" + this.系统环境 + "'");
		}
		if (this.开发工具 != null) {
			sb.append(",'" + this.开发工具 + "'");
		}
		if (this.数据库 != null) {
			sb.append(",'" + this.数据库 + "'");
		}
		if (this.框架 != null) {
			sb.append(",'" + this.框架 + "'");
		}
		if (this.职责 != null) {
			sb.append(",'" + this.职责 + "'");
		}
		if (this.工作内容 != null) {
			sb.append(",'" + this.工作内容 + "'");
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
