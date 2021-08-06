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
public class SysUserWorkExperience {
	// 用户工作履历
	private String TABLE_NAME = "SYS_USER_WORK_EXPERIENCE";

	private String uuid;
	private String baseUuid;
	private String 姓名;
	private String 单位名称;
	private String 企业行业;
	private String 职务类型;
	private String 职位名称;
	private String 工作内容;
	private String 岗位;
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

	public String get单位名称() {
		return 单位名称;
	}

	public void set单位名称(String 单位名称) {
		this.单位名称 = 单位名称;
	}

	public String get企业行业() {
		return 企业行业;
	}

	public void set企业行业(String 企业行业) {
		this.企业行业 = 企业行业;
	}

	public String get职务类型() {
		return 职务类型;
	}

	public void set职务类型(String 职务类型) {
		this.职务类型 = 职务类型;
	}

	public String get职位名称() {
		return 职位名称;
	}

	public void set职位名称(String 职位名称) {
		this.职位名称 = 职位名称;
	}

	public String get工作内容() {
		return 工作内容;
	}

	public void set工作内容(String 工作内容) {
		this.工作内容 = 工作内容;
	}

	public String get岗位() {
		return 岗位;
	}

	public void set岗位(String 岗位) {
		this.岗位 = 岗位;
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

	public SysUserWorkExperience() {
		super();
	}

	public SysUserWorkExperience(String uuid) {
		super();
		this.uuid = uuid;
	}

	public SysUserWorkExperience(String uuid, String baseUuid) {
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
		if (this.单位名称 != null) {
			sb.append(",单位名称='" + this.单位名称 + "'");
		}
		if (this.企业行业 != null) {
			sb.append(",企业行业='" + this.企业行业 + "'");
		}
		if (this.职务类型 != null) {
			sb.append(",职务类型='" + this.职务类型 + "'");
		}
		if (this.职位名称 != null) {
			sb.append(",职位名称='" + this.职位名称 + "'");
		}
		if (this.工作内容 != null) {
			sb.append(",工作内容='" + this.工作内容 + "'");
		}
		if (this.岗位 != null) {
			sb.append(",岗位='" + this.岗位 + "'");
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
		if (this.单位名称 != null) {
			sb.append(",单位名称");
		}
		if (this.企业行业 != null) {
			sb.append(",企业行业");
		}
		if (this.职务类型 != null) {
			sb.append(",职务类型");
		}
		if (this.职位名称 != null) {
			sb.append(",职位名称");
		}
		if (this.工作内容 != null) {
			sb.append(",工作内容");
		}
		if (this.岗位 != null) {
			sb.append(",岗位");
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
		if (this.单位名称 != null) {
			sb.append(",'" + this.单位名称 + "'");
		}
		if (this.企业行业 != null) {
			sb.append(",'" + this.企业行业 + "'");
		}
		if (this.职务类型 != null) {
			sb.append(",'" + this.职务类型 + "'");
		}
		if (this.职位名称 != null) {
			sb.append(",'" + this.职位名称 + "'");
		}
		if (this.工作内容 != null) {
			sb.append(",'" + this.工作内容 + "'");
		}
		if (this.岗位 != null) {
			sb.append(",'" + this.岗位 + "'");
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
