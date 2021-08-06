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
public class SysUserHkxx {
	// 用户户口
	private String TABLE_NAME = "SYS_USER_HKXX";
	private String uuid;
	private String baseUuid;
	private String 姓名;
	private String sfzh18;
	private String 户号;
	private String 户籍地址;
	private String 户口所在地;
	private String 户籍类型;
	private String 血型;
	private String 曾用名;
	private String 婚姻;
	private String 政治面貌;
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

	public String getSfzh18() {
		return sfzh18;
	}

	public void setSfzh18(String sfzh18) {
		this.sfzh18 = sfzh18;
	}

	public String get户号() {
		return 户号;
	}

	public void set户号(String 户号) {
		this.户号 = 户号;
	}

	public String get户籍地址() {
		return 户籍地址;
	}

	public void set户籍地址(String 户籍地址) {
		this.户籍地址 = 户籍地址;
	}

	public String get户口所在地() {
		return 户口所在地;
	}

	public void set户口所在地(String 户口所在地) {
		this.户口所在地 = 户口所在地;
	}

	public String get户籍类型() {
		return 户籍类型;
	}

	public void set户籍类型(String 户籍类型) {
		this.户籍类型 = 户籍类型;
	}

	public String get血型() {
		return 血型;
	}

	public void set血型(String 血型) {
		this.血型 = 血型;
	}

	public String get曾用名() {
		return 曾用名;
	}

	public void set曾用名(String 曾用名) {
		this.曾用名 = 曾用名;
	}

	public String get婚姻() {
		return 婚姻;
	}

	public void set婚姻(String 婚姻) {
		this.婚姻 = 婚姻;
	}

	public String get政治面貌() {
		return 政治面貌;
	}

	public void set政治面貌(String 政治面貌) {
		this.政治面貌 = 政治面貌;
	}

	public String get数据来源() {
		return 数据来源;
	}

	public void set数据来源(String 数据来源) {
		this.数据来源 = 数据来源;
	}

	public String get入库时间() {
		return 入库时间;
	}

	public void set入库时间(String 入库时间) {
		this.入库时间 = 入库时间;
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

	public SysUserHkxx() {
		super();
	}

	public SysUserHkxx(String uuid) {
		super();
		this.uuid = uuid;
	}

	public SysUserHkxx(String uuid, String baseUuid) {
		super();
		this.uuid = uuid;
		this.baseUuid = baseUuid;
	}

	@Override
	public String toString() {
		return "SysUserHkxx [uuid=" + uuid + ", baseUuid=" + baseUuid + ", 姓名=" + 姓名 + ", sfzh18=" + sfzh18 + ", 户号=" + 户号 + ", 户籍地址=" + 户籍地址 + ", 户口所在地=" + 户口所在地 + ", 户籍类型=" + 户籍类型 + ", 血型=" + 血型 + ", 曾用名=" + 曾用名 + ", 婚姻=" + 婚姻 + ", 政治面貌=" + 政治面貌 + ", 数据来源=" + 数据来源 + ", 入库时间=" + 入库时间 + "]";
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
		if (this.sfzh18 != null) {
			sb.append(",SFZH18='" + this.sfzh18 + "'");
		}
		if (this.户号 != null) {
			sb.append(",户号='" + this.户号 + "'");
		}
		if (this.户籍地址 != null) {
			sb.append(",户籍地址='" + this.户籍地址 + "'");
		}
		if (this.户口所在地 != null) {
			sb.append(",户口所在地='" + this.户口所在地 + "'");
		}
		if (this.户籍类型 != null) {
			sb.append(",户籍类型='" + this.户籍类型 + "'");
		}
		if (this.血型 != null) {
			sb.append(",血型='" + this.血型 + "'");
		}
		if (this.曾用名 != null) {
			sb.append(",曾用名='" + this.曾用名 + "'");
		}
		if (this.婚姻 != null) {
			sb.append(",婚姻='" + this.婚姻 + "'");
		}
		if (this.政治面貌 != null) {
			sb.append(",政治面貌='" + this.政治面貌 + "'");
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
		if (this.姓名 != null) {
			sb.append(",姓名='" + this.姓名 + "'");
		}
		if (this.sfzh18 != null) {
			sb.append(",SFZH18='" + this.sfzh18 + "'");
		}
		if (this.户号 != null) {
			sb.append(",户号");
		}
		if (this.户籍地址 != null) {
			sb.append(",户籍地址");
		}
		if (this.户口所在地 != null) {
			sb.append(",户口所在地");
		}
		if (this.户籍类型 != null) {
			sb.append(",户籍类型");
		}
		if (this.血型 != null) {
			sb.append(",血型");
		}
		if (this.曾用名 != null) {
			sb.append(",曾用名");
		}
		if (this.婚姻 != null) {
			sb.append(",婚姻");
		}
		if (this.政治面貌 != null) {
			sb.append(",政治面貌");
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
		if (this.sfzh18 != null) {
			sb.append(",'" + this.sfzh18 + "'");
		}
		if (this.户号 != null) {
			sb.append(",'" + this.户号 + "'");
		}
		if (this.户籍地址 != null) {
			sb.append(",'" + this.户籍地址 + "'");
		}
		if (this.户口所在地 != null) {
			sb.append(",'" + this.户口所在地 + "'");
		}
		if (this.户籍类型 != null) {
			sb.append(",'" + this.户籍类型 + "'");
		}
		if (this.血型 != null) {
			sb.append(",'" + this.血型 + "'");
		}
		if (this.曾用名 != null) {
			sb.append(",'" + this.曾用名 + "'");
		}
		if (this.婚姻 != null) {
			sb.append(",'" + this.婚姻 + "'");
		}
		if (this.政治面貌 != null) {
			sb.append(",'" + this.政治面貌 + "'");
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
