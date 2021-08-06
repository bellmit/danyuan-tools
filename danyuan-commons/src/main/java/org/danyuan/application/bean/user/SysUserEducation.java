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
public class SysUserEducation {
	// 用户学历信息
	private String TABLE_NAME = "SYS_USER_EDUCATION";

	private String uuid;
	private String baseUuid;
	private String 姓名;
	private String 学校;
	private String 入学时间;
	private String 毕业时间;
	private String 专业;
	private String 离校时间;
	private String 离校类型;
	private String 离校方向;
	private String 离校原因;
	private String 进校时间;
	private String 就读方式;
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

	public String get学校() {
		return 学校;
	}

	public void set学校(String 学校) {
		this.学校 = 学校;
	}

	public String get入学时间() {
		return 入学时间;
	}

	public void set入学时间(String 入学时间) {
		this.入学时间 = 入学时间;
	}

	public String get毕业时间() {
		return 毕业时间;
	}

	public void set毕业时间(String 毕业时间) {
		this.毕业时间 = 毕业时间;
	}

	public String get专业() {
		return 专业;
	}

	public void set专业(String 专业) {
		this.专业 = 专业;
	}

	public String get离校时间() {
		return 离校时间;
	}

	public void set离校时间(String 离校时间) {
		this.离校时间 = 离校时间;
	}

	public String get离校类型() {
		return 离校类型;
	}

	public void set离校类型(String 离校类型) {
		this.离校类型 = 离校类型;
	}

	public String get离校方向() {
		return 离校方向;
	}

	public void set离校方向(String 离校方向) {
		this.离校方向 = 离校方向;
	}

	public String get离校原因() {
		return 离校原因;
	}

	public void set离校原因(String 离校原因) {
		this.离校原因 = 离校原因;
	}

	public String get进校时间() {
		return 进校时间;
	}

	public void set进校时间(String 进校时间) {
		this.进校时间 = 进校时间;
	}

	public String get就读方式() {
		return 就读方式;
	}

	public void set就读方式(String 就读方式) {
		this.就读方式 = 就读方式;
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

	public SysUserEducation() {
		super();
	}

	public SysUserEducation(String uuid) {
		super();
		this.uuid = uuid;
	}

	public SysUserEducation(String uuid, String baseUuid) {
		super();
		this.uuid = uuid;
		this.baseUuid = baseUuid;
	}

	@Override
	public String toString() {
		return "SysUserEducation [uuid=" + uuid + ", baseUuid=" + baseUuid + ", 姓名=" + 姓名 + ", 学校=" + 学校 + ", 入学时间=" + 入学时间 + ", 毕业时间=" + 毕业时间 + ", 专业=" + 专业 + ", 离校时间=" + 离校时间 + ", 离校类型=" + 离校类型 + ", 离校方向=" + 离校方向 + ", 离校原因=" + 离校原因 + ", 进校时间=" + 进校时间 + ", 就读方式=" + 就读方式 + ", 入库时间=" + 入库时间 + ", 数据来源=" + 数据来源 + ", insertDate=" + insertDate + ", updateDate=" + updateDate + "]";
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
		if (this.学校 != null) {
			sb.append(",学校='" + this.学校 + "'");
		}
		if (this.入学时间 != null) {
			sb.append(",入学时间='" + this.入学时间 + "'");
		}
		if (this.毕业时间 != null) {
			sb.append(",毕业时间='" + this.毕业时间 + "'");
		}
		if (this.专业 != null) {
			sb.append(",专业='" + this.专业 + "'");
		}
		if (this.离校时间 != null) {
			sb.append(",离校时间='" + this.离校时间 + "'");
		}
		if (this.离校类型 != null) {
			sb.append(",离校类型='" + this.离校类型 + "'");
		}
		if (this.离校方向 != null) {
			sb.append(",离校方向='" + this.离校方向 + "'");
		}
		if (this.离校原因 != null) {
			sb.append(",离校原因='" + this.离校原因 + "'");
		}
		if (this.进校时间 != null) {
			sb.append(",进校时间='" + this.进校时间 + "'");
		}
		if (this.就读方式 != null) {
			sb.append(",就读方式='" + this.就读方式 + "'");
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
		if (this.学校 != null) {
			sb.append(",学校");
		}
		if (this.入学时间 != null) {
			sb.append(",入学时间");
		}
		if (this.毕业时间 != null) {
			sb.append(",毕业时间");
		}
		if (this.专业 != null) {
			sb.append(",专业");
		}
		if (this.离校时间 != null) {
			sb.append(",离校时间");
		}
		if (this.离校类型 != null) {
			sb.append(",离校类型");
		}
		if (this.离校方向 != null) {
			sb.append(",离校方向");
		}
		if (this.离校原因 != null) {
			sb.append(",离校原因");
		}
		if (this.进校时间 != null) {
			sb.append(",进校时间");
		}
		if (this.就读方式 != null) {
			sb.append(",就读方式");
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
		if (this.学校 != null) {
			sb.append(",'" + this.学校 + "'");
		}
		if (this.入学时间 != null) {
			sb.append(",'" + this.入学时间 + "'");
		}
		if (this.毕业时间 != null) {
			sb.append(",'" + this.毕业时间 + "'");
		}
		if (this.专业 != null) {
			sb.append(",'" + this.专业 + "'");
		}
		if (this.离校时间 != null) {
			sb.append(",'" + this.离校时间 + "'");
		}
		if (this.离校类型 != null) {
			sb.append(",'" + this.离校类型 + "'");
		}
		if (this.离校方向 != null) {
			sb.append(",'" + this.离校方向 + "'");
		}
		if (this.离校原因 != null) {
			sb.append(",'" + this.离校原因 + "'");
		}
		if (this.进校时间 != null) {
			sb.append(",'" + this.进校时间 + "'");
		}
		if (this.就读方式 != null) {
			sb.append(",'" + this.就读方式 + "'");
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
