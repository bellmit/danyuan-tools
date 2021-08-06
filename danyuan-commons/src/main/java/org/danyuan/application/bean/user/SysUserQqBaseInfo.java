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
public class SysUserQqBaseInfo {
	// 用户QQ信息表
	private String TABLE_NAME = "SYS_USER_QQ_BASE_INFO";

	private String uuid;
	private String baseUuid;
	private String 姓名;
	private String qq;
	private String 电子邮箱;
	private String 电话;
	private String 手机号码;
	private String qq号码;
	private String 性别;
	private String 学校名称;
	private String 入学时间;
	private String 学校类型;
	private String 家庭住址;
	private String 省;
	private String 市;
	private String 昵称;
	private String 说说;
	private String 出生日期;
	private String 职业;
	private String 专业名称;
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

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String get电子邮箱() {
		return 电子邮箱;
	}

	public void set电子邮箱(String 电子邮箱) {
		this.电子邮箱 = 电子邮箱;
	}

	public String get电话() {
		return 电话;
	}

	public void set电话(String 电话) {
		this.电话 = 电话;
	}

	public String get手机号码() {
		return 手机号码;
	}

	public void set手机号码(String 手机号码) {
		this.手机号码 = 手机号码;
	}

	public String getQq号码() {
		return qq号码;
	}

	public void setQq号码(String qq号码) {
		this.qq号码 = qq号码;
	}

	public String get性别() {
		return 性别;
	}

	public void set性别(String 性别) {
		this.性别 = 性别;
	}

	public String get学校名称() {
		return 学校名称;
	}

	public void set学校名称(String 学校名称) {
		this.学校名称 = 学校名称;
	}

	public String get入学时间() {
		return 入学时间;
	}

	public void set入学时间(String 入学时间) {
		this.入学时间 = 入学时间;
	}

	public String get学校类型() {
		return 学校类型;
	}

	public void set学校类型(String 学校类型) {
		this.学校类型 = 学校类型;
	}

	public String get家庭住址() {
		return 家庭住址;
	}

	public void set家庭住址(String 家庭住址) {
		this.家庭住址 = 家庭住址;
	}

	public String get省() {
		return 省;
	}

	public void set省(String 省) {
		this.省 = 省;
	}

	public String get市() {
		return 市;
	}

	public void set市(String 市) {
		this.市 = 市;
	}

	public String get昵称() {
		return 昵称;
	}

	public void set昵称(String 昵称) {
		this.昵称 = 昵称;
	}

	public String get说说() {
		return 说说;
	}

	public void set说说(String 说说) {
		this.说说 = 说说;
	}

	public String get出生日期() {
		return 出生日期;
	}

	public void set出生日期(String 出生日期) {
		this.出生日期 = 出生日期;
	}

	public String get职业() {
		return 职业;
	}

	public void set职业(String 职业) {
		this.职业 = 职业;
	}

	public String get专业名称() {
		return 专业名称;
	}

	public void set专业名称(String 专业名称) {
		this.专业名称 = 专业名称;
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

	public SysUserQqBaseInfo() {
		super();
	}

	public SysUserQqBaseInfo(String uuid) {
		super();
		this.uuid = uuid;
	}

	public SysUserQqBaseInfo(String uuid, String baseUuid) {
		super();
		this.uuid = uuid;
		this.baseUuid = baseUuid;
	}

	@Override
	public String toString() {
		return "SysUserQqBaseInfo [uuid=" + uuid + ", baseUuid=" + baseUuid + ", 姓名=" + 姓名 + ", qq=" + qq + ", 电子邮箱=" + 电子邮箱 + ", 电话=" + 电话 + ", 手机号码=" + 手机号码 + ", qq号码=" + qq号码 + ", 性别=" + 性别 + ", 学校名称=" + 学校名称 + ", 入学时间=" + 入学时间 + ", 学校类型=" + 学校类型 + ", 家庭住址=" + 家庭住址 + ", 省=" + 省 + ", 市=" + 市 + ", 昵称=" + 昵称 + ", 说说=" + 说说 + ", 出生日期=" + 出生日期 + ", 职业=" + 职业 + ", 专业名称=" + 专业名称 + ", 入库时间=" + 入库时间 + ", 数据来源=" + 数据来源 + ", insertDate=" + insertDate + ", updateDate=" + updateDate + "]";
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
		if (this.qq != null) {
			sb.append(",qq='" + this.qq + "'");
		}
		if (this.电子邮箱 != null) {
			sb.append(",电子邮箱='" + this.电子邮箱 + "'");
		}
		if (this.电话 != null) {
			sb.append(",电话='" + this.电话 + "'");
		}
		if (this.手机号码 != null) {
			sb.append(",手机号码='" + this.手机号码 + "'");
		}
		if (this.qq号码 != null) {
			sb.append(",qq号码='" + this.qq号码 + "'");
		}
		if (this.性别 != null) {
			sb.append(",性别='" + this.性别 + "'");
		}
		if (this.学校名称 != null) {
			sb.append(",学校名称='" + this.学校名称 + "'");
		}
		if (this.入学时间 != null) {
			sb.append(",入学时间='" + this.入学时间 + "'");
		}
		if (this.学校类型 != null) {
			sb.append(",学校类型='" + this.学校类型 + "'");
		}
		if (this.家庭住址 != null) {
			sb.append(",家庭住址='" + this.家庭住址 + "'");
		}
		if (this.省 != null) {
			sb.append(",省='" + this.省 + "'");
		}
		if (this.市 != null) {
			sb.append(",市='" + this.市 + "'");
		}
		if (this.昵称 != null) {
			sb.append(",昵称='" + this.昵称 + "'");
		}
		if (this.说说 != null) {
			sb.append(",说说='" + this.说说 + "'");
		}
		if (this.出生日期 != null) {
			sb.append(",出生日期='" + this.出生日期 + "'");
		}
		if (this.职业 != null) {
			sb.append(",职业='" + this.职业 + "'");
		}
		if (this.专业名称 != null) {
			sb.append(",专业名称='" + this.专业名称 + "'");
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
		if (this.qq != null) {
			sb.append(",qq");
		}
		if (this.电子邮箱 != null) {
			sb.append(",电子邮箱");
		}
		if (this.电话 != null) {
			sb.append(",电话");
		}
		if (this.手机号码 != null) {
			sb.append(",手机号码");
		}
		if (this.qq号码 != null) {
			sb.append(",qq号码");
		}
		if (this.性别 != null) {
			sb.append(",性别");
		}
		if (this.学校名称 != null) {
			sb.append(",学校名称");
		}
		if (this.入学时间 != null) {
			sb.append(",入学时间");
		}
		if (this.学校类型 != null) {
			sb.append(",学校类型");
		}
		if (this.家庭住址 != null) {
			sb.append(",家庭住址");
		}
		if (this.省 != null) {
			sb.append(",省");
		}
		if (this.市 != null) {
			sb.append(",市");
		}
		if (this.昵称 != null) {
			sb.append(",昵称");
		}
		if (this.说说 != null) {
			sb.append(",说说");
		}
		if (this.出生日期 != null) {
			sb.append(",出生日期");
		}
		if (this.职业 != null) {
			sb.append(",职业");
		}
		if (this.专业名称 != null) {
			sb.append(",专业名称");
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
		if (this.qq != null) {
			sb.append(",'" + this.qq + "'");
		}
		if (this.电子邮箱 != null) {
			sb.append(",'" + this.电子邮箱 + "'");
		}
		if (this.电话 != null) {
			sb.append(",'" + this.电话 + "'");
		}
		if (this.手机号码 != null) {
			sb.append(",'" + this.手机号码 + "'");
		}
		if (this.qq号码 != null) {
			sb.append(",'" + this.qq号码 + "'");
		}
		if (this.性别 != null) {
			sb.append(",'" + this.性别 + "'");
		}
		if (this.学校名称 != null) {
			sb.append(",'" + this.学校名称 + "'");
		}
		if (this.入学时间 != null) {
			sb.append(",'" + this.入学时间 + "'");
		}
		if (this.学校类型 != null) {
			sb.append(",'" + this.学校类型 + "'");
		}
		if (this.家庭住址 != null) {
			sb.append(",'" + this.家庭住址 + "'");
		}
		if (this.省 != null) {
			sb.append(",'" + this.省 + "'");
		}
		if (this.市 != null) {
			sb.append(",'" + this.市 + "'");
		}
		if (this.昵称 != null) {
			sb.append(",'" + this.昵称 + "'");
		}
		if (this.说说 != null) {
			sb.append(",'" + this.说说 + "'");
		}
		if (this.出生日期 != null) {
			sb.append(",'" + this.出生日期 + "'");
		}
		if (this.职业 != null) {
			sb.append(",'" + this.职业 + "'");
		}
		if (this.专业名称 != null) {
			sb.append(",'" + this.专业名称 + "'");
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
