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
public class SysUserBaseInfo {
	// 用户基本信息
	private String TABLE_NAME = "SYS_USER_BASE_INFO";
	private String uuid;
	private String 姓名;
	private String sfzh18;
	private String 籍贯省;
	private String 籍贯市;
	private String 籍贯县;
	private String id_出生日期;
	private String id_性别;
	private String id_生肖;
	private String id_星座;
	private String 籍贯编码;
	private String 地址;
	private String 电话;
	private String qq号码;
	private String 电子邮箱;
	private String 用户名;
	private String 学历;
	private String 公示时间;
	private String 区号;
	private String 工作单位;
	private String 手机号码;
	private String 昵称;
	private String ip地址;
	private String msn;
	private String 网址;
	private String 民族;
	private String 拼音;
	private String 籍贯邮编;
	private String position;
	private String 身高_cm;
	private String 血型;
	private String 现住地;
	private String 地区;
	private String 曾用名;
	private String 体重;
	private String 婚姻;
	private String 政治面貌;
	private String 特长;
	private String 账号;
	private String 传真;
	private String 号码归属地;

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

	public String get籍贯省() {
		return 籍贯省;
	}

	public void set籍贯省(String 籍贯省) {
		this.籍贯省 = 籍贯省;
	}

	public String get籍贯市() {
		return 籍贯市;
	}

	public void set籍贯市(String 籍贯市) {
		this.籍贯市 = 籍贯市;
	}

	public String get籍贯县() {
		return 籍贯县;
	}

	public void set籍贯县(String 籍贯县) {
		this.籍贯县 = 籍贯县;
	}

	public String getId_出生日期() {
		return id_出生日期;
	}

	public void setId_出生日期(String id_出生日期) {
		this.id_出生日期 = id_出生日期;
	}

	public String getId_性别() {
		return id_性别;
	}

	public void setId_性别(String id_性别) {
		this.id_性别 = id_性别;
	}

	public String getId_生肖() {
		return id_生肖;
	}

	public void setId_生肖(String id_生肖) {
		this.id_生肖 = id_生肖;
	}

	public String getId_星座() {
		return id_星座;
	}

	public void setId_星座(String id_星座) {
		this.id_星座 = id_星座;
	}

	public String get籍贯编码() {
		return 籍贯编码;
	}

	public void set籍贯编码(String 籍贯编码) {
		this.籍贯编码 = 籍贯编码;
	}

	public String get地址() {
		return 地址;
	}

	public void set地址(String 地址) {
		this.地址 = 地址;
	}

	public String get电话() {
		return 电话;
	}

	public void set电话(String 电话) {
		this.电话 = 电话;
	}

	public String getQq号码() {
		return qq号码;
	}

	public void setQq号码(String qq号码) {
		this.qq号码 = qq号码;
	}

	public String get电子邮箱() {
		return 电子邮箱;
	}

	public void set电子邮箱(String 电子邮箱) {
		this.电子邮箱 = 电子邮箱;
	}

	public String get用户名() {
		return 用户名;
	}

	public void set用户名(String 用户名) {
		this.用户名 = 用户名;
	}

	public String get学历() {
		return 学历;
	}

	public void set学历(String 学历) {
		this.学历 = 学历;
	}

	public String get公示时间() {
		return 公示时间;
	}

	public void set公示时间(String 公示时间) {
		this.公示时间 = 公示时间;
	}

	public String get区号() {
		return 区号;
	}

	public void set区号(String 区号) {
		this.区号 = 区号;
	}

	public String get工作单位() {
		return 工作单位;
	}

	public void set工作单位(String 工作单位) {
		this.工作单位 = 工作单位;
	}

	public String get手机号码() {
		return 手机号码;
	}

	public void set手机号码(String 手机号码) {
		this.手机号码 = 手机号码;
	}

	public String get昵称() {
		return 昵称;
	}

	public void set昵称(String 昵称) {
		this.昵称 = 昵称;
	}

	public String getIp地址() {
		return ip地址;
	}

	public void setIp地址(String ip地址) {
		this.ip地址 = ip地址;
	}

	public String getMsn() {
		return msn;
	}

	public void setMsn(String msn) {
		this.msn = msn;
	}

	public String get网址() {
		return 网址;
	}

	public void set网址(String 网址) {
		this.网址 = 网址;
	}

	public String get民族() {
		return 民族;
	}

	public void set民族(String 民族) {
		this.民族 = 民族;
	}

	public String get拼音() {
		return 拼音;
	}

	public void set拼音(String 拼音) {
		this.拼音 = 拼音;
	}

	public String get籍贯邮编() {
		return 籍贯邮编;
	}

	public void set籍贯邮编(String 籍贯邮编) {
		this.籍贯邮编 = 籍贯邮编;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String get身高_cm() {
		return 身高_cm;
	}

	public void set身高_cm(String 身高_cm) {
		this.身高_cm = 身高_cm;
	}

	public String get血型() {
		return 血型;
	}

	public void set血型(String 血型) {
		this.血型 = 血型;
	}

	public String get现住地() {
		return 现住地;
	}

	public void set现住地(String 现住地) {
		this.现住地 = 现住地;
	}

	public String get地区() {
		return 地区;
	}

	public void set地区(String 地区) {
		this.地区 = 地区;
	}

	public String get曾用名() {
		return 曾用名;
	}

	public void set曾用名(String 曾用名) {
		this.曾用名 = 曾用名;
	}

	public String get体重() {
		return 体重;
	}

	public void set体重(String 体重) {
		this.体重 = 体重;
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

	public String get特长() {
		return 特长;
	}

	public void set特长(String 特长) {
		this.特长 = 特长;
	}

	public String get账号() {
		return 账号;
	}

	public void set账号(String 账号) {
		this.账号 = 账号;
	}

	public String get传真() {
		return 传真;
	}

	public void set传真(String 传真) {
		this.传真 = 传真;
	}

	public String get号码归属地() {
		return 号码归属地;
	}

	public void set号码归属地(String 号码归属地) {
		this.号码归属地 = 号码归属地;
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
		return "SysUserBaseInfo [uuid=" + uuid + ", 姓名=" + 姓名 + ", sfzh18=" + sfzh18 + ", 籍贯省=" + 籍贯省 + ", 籍贯市=" + 籍贯市 + ", 籍贯县=" + 籍贯县 + ", id_出生日期=" + id_出生日期 + ", id_性别=" + id_性别 + ", id_生肖=" + id_生肖 + ", id_星座=" + id_星座 + ", 籍贯编码=" + 籍贯编码 + ", 地址=" + 地址 + ", 电话=" + 电话 + ", qq号码=" + qq号码 + ", 电子邮箱=" + 电子邮箱 + ", 用户名=" + 用户名 + ", 学历=" + 学历 + ", 公示时间=" + 公示时间 + ", 区号=" + 区号 + ", 工作单位=" + 工作单位 + ", 手机号码=" + 手机号码 + ", 昵称=" + 昵称 + ", ip地址=" + ip地址 + ", msn=" + msn + ", 网址=" + 网址 + ", 民族=" + 民族 + ", 拼音=" + 拼音 + ", 籍贯邮编=" + 籍贯邮编 + ", position=" + position + ", 身高_cm=" + 身高_cm + ", 血型=" + 血型 + ", 现住地=" + 现住地 + ", 地区=" + 地区 + ", 曾用名=" + 曾用名 + ", 体重=" + 体重 + ", 婚姻=" + 婚姻 + ", 政治面貌=" + 政治面貌 + ", 特长=" + 特长 + ", 账号=" + 账号 + ", 传真=" + 传真 + ", 号码归属地=" + 号码归属地 + ", 入库时间=" + 入库时间 + ", 数据来源=" + 数据来源 + "]";
	}

	public SysUserBaseInfo() {
		super();
	}

	public SysUserBaseInfo(String uuid) {
		super();
		this.uuid = uuid;
	}

	public SysUserBaseInfo sfzh(String sfzh) {
		// 1.整理号码统一为18位
		// 2.查询库中是否有历史数据
		// 3.没有的通过工具类整理出 性别，生日，生效，星座，地区，省，市，随机主键id

		return this;
	}

	/** 更新插入语句判断 生成 */
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
		if (this.姓名 != null) {
			sb.append(",姓名='" + this.姓名 + "'");
		}
		if (this.sfzh18 != null) {
			sb.append(",SFZH18='" + this.sfzh18 + "'");
		}
		if (this.籍贯省 != null) {
			sb.append(",籍贯省='" + this.籍贯省 + "'");
		}
		if (this.籍贯市 != null) {
			sb.append(",籍贯市='" + this.籍贯市 + "'");
		}
		if (this.籍贯县 != null) {
			sb.append(",籍贯县='" + this.籍贯县 + "'");
		}
		if (this.id_出生日期 != null) {
			sb.append(",ID_出生日期='" + this.id_出生日期 + "'");
		}
		if (this.id_性别 != null) {
			sb.append(",ID_性别='" + this.id_性别 + "'");
		}
		if (this.id_生肖 != null) {
			sb.append(",ID_生肖='" + this.id_生肖 + "'");
		}
		if (this.id_星座 != null) {
			sb.append(",ID_星座='" + this.id_星座 + "'");
		}
		if (this.籍贯编码 != null) {
			sb.append(",籍贯编码='" + this.籍贯编码 + "'");
		}
		if (this.地址 != null) {
			sb.append(",地址='" + this.地址 + "'");
		}
		if (this.电话 != null) {
			sb.append(",电话='" + this.电话 + "'");
		}
		if (this.qq号码 != null) {
			sb.append(",QQ号码='" + this.qq号码 + "'");
		}
		if (this.电子邮箱 != null) {
			sb.append(",电子邮箱='" + this.电子邮箱 + "'");
		}
		if (this.用户名 != null) {
			sb.append(",用户名='" + this.用户名 + "'");
		}
		if (this.学历 != null) {
			sb.append(",学历='" + this.学历 + "'");
		}
		if (this.公示时间 != null) {
			sb.append(",公示时间='" + this.公示时间 + "'");
		}
		if (this.区号 != null) {
			sb.append(",区号='" + this.区号 + "'");
		}
		if (this.工作单位 != null) {
			sb.append(",工作单位='" + this.工作单位 + "'");
		}
		if (this.手机号码 != null) {
			sb.append(",手机号码='" + this.手机号码 + "'");
		}
		if (this.昵称 != null) {
			sb.append(",昵称='" + this.昵称 + "'");
		}
		if (this.ip地址 != null) {
			sb.append(",IP地址='" + this.ip地址 + "'");
		}
		if (this.msn != null) {
			sb.append(",MSN='" + this.msn + "'");
		}
		if (this.网址 != null) {
			sb.append(",网址='" + this.网址 + "'");
		}
		if (this.民族 != null) {
			sb.append(",民族='" + this.民族 + "'");
		}
		if (this.拼音 != null) {
			sb.append(",拼音='" + this.拼音 + "'");
		}
		if (this.籍贯邮编 != null) {
			sb.append(",籍贯邮编='" + this.籍贯邮编 + "'");
		}
		if (this.position != null) {
			sb.append(",POSITION='" + this.position + "'");
		}
		if (this.身高_cm != null) {
			sb.append(",身高_CM='" + this.身高_cm + "'");
		}
		if (this.血型 != null) {
			sb.append(",血型='" + this.血型 + "'");
		}
		if (this.现住地 != null) {
			sb.append(",现住地='" + this.现住地 + "'");
		}
		if (this.地区 != null) {
			sb.append(",地区='" + this.地区 + "'");
		}
		if (this.曾用名 != null) {
			sb.append(",曾用名='" + this.曾用名 + "'");
		}
		if (this.体重 != null) {
			sb.append(",体重='" + this.体重 + "'");
		}
		if (this.婚姻 != null) {
			sb.append(",婚姻='" + this.婚姻 + "'");
		}
		if (this.政治面貌 != null) {
			sb.append(",政治面貌='" + this.政治面貌 + "'");
		}
		if (this.特长 != null) {
			sb.append(",特长='" + this.特长 + "'");
		}
		if (this.账号 != null) {
			sb.append(",账号='" + this.账号 + "'");
		}
		if (this.传真 != null) {
			sb.append(",传真='" + this.传真 + "'");
		}
		if (this.号码归属地 != null) {
			sb.append(",号码归属地='" + this.号码归属地 + "'");
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
		if (this.姓名 != null) {
			sb.append(",姓名");
		}
		if (this.sfzh18 != null) {
			sb.append(",SFZH18");
		}
		if (this.籍贯省 != null) {
			sb.append(",籍贯省");
		}
		if (this.籍贯市 != null) {
			sb.append(",籍贯市");
		}
		if (this.籍贯县 != null) {
			sb.append(",籍贯县");
		}
		if (this.id_出生日期 != null) {
			sb.append(",ID_出生日期");
		}
		if (this.id_性别 != null) {
			sb.append(",ID_性别");
		}
		if (this.id_生肖 != null) {
			sb.append(",ID_生肖");
		}
		if (this.id_星座 != null) {
			sb.append(",ID_星座");
		}
		if (this.籍贯编码 != null) {
			sb.append(",籍贯编码");
		}
		if (this.地址 != null) {
			sb.append(",地址");
		}
		if (this.电话 != null) {
			sb.append(",电话");
		}
		if (this.qq号码 != null) {
			sb.append(",QQ号码");
		}
		if (this.电子邮箱 != null) {
			sb.append(",电子邮箱");
		}
		if (this.用户名 != null) {
			sb.append(",用户名");
		}
		if (this.学历 != null) {
			sb.append(",学历");
		}
		if (this.公示时间 != null) {
			sb.append(",公示时间");
		}
		if (this.区号 != null) {
			sb.append(",区号");
		}
		if (this.工作单位 != null) {
			sb.append(",工作单位");
		}
		if (this.手机号码 != null) {
			sb.append(",手机号码");
		}
		if (this.昵称 != null) {
			sb.append(",昵称");
		}
		if (this.ip地址 != null) {
			sb.append(",IP地址");
		}
		if (this.msn != null) {
			sb.append(",MSN");
		}
		if (this.网址 != null) {
			sb.append(",网址");
		}
		if (this.民族 != null) {
			sb.append(",民族");
		}
		if (this.拼音 != null) {
			sb.append(",拼音");
		}
		if (this.籍贯邮编 != null) {
			sb.append(",籍贯邮编");
		}
		if (this.position != null) {
			sb.append(",POSITION");
		}
		if (this.身高_cm != null) {
			sb.append(",身高_CM");
		}
		if (this.血型 != null) {
			sb.append(",血型");
		}
		if (this.现住地 != null) {
			sb.append(",现住地");
		}
		if (this.地区 != null) {
			sb.append(",地区");
		}
		if (this.曾用名 != null) {
			sb.append(",曾用名");
		}
		if (this.体重 != null) {
			sb.append(",体重");
		}
		if (this.婚姻 != null) {
			sb.append(",婚姻");
		}
		if (this.政治面貌 != null) {
			sb.append(",政治面貌");
		}
		if (this.特长 != null) {
			sb.append(",特长");
		}
		if (this.账号 != null) {
			sb.append(",账号");
		}
		if (this.传真 != null) {
			sb.append(",传真");
		}
		if (this.号码归属地 != null) {
			sb.append(",号码归属地");
		}
		if (this.入库时间 != null) {
			sb.append(",入库时间");
		}
		if (this.数据来源 != null) {
			sb.append(",数据来源");
		}
		sb.append(",INSERT_DATE ) VALUES('" + uuid + "'");
		if (this.姓名 != null) {
			sb.append(",'" + this.姓名 + "'");
		}
		if (this.sfzh18 != null) {
			sb.append(",'" + this.sfzh18 + "'");
		}
		if (this.籍贯省 != null) {
			sb.append(",'" + this.籍贯省 + "'");
		}
		if (this.籍贯市 != null) {
			sb.append(",'" + this.籍贯市 + "'");
		}
		if (this.籍贯县 != null) {
			sb.append(",'" + this.籍贯县 + "'");
		}
		if (this.id_出生日期 != null) {
			sb.append(",'" + this.id_出生日期 + "'");
		}
		if (this.id_性别 != null) {
			sb.append(",'" + this.id_性别 + "'");
		}
		if (this.id_生肖 != null) {
			sb.append(",'" + this.id_生肖 + "'");
		}
		if (this.id_星座 != null) {
			sb.append(",'" + this.id_星座 + "'");
		}
		if (this.籍贯编码 != null) {
			sb.append(",'" + this.籍贯编码 + "'");
		}
		if (this.地址 != null) {
			sb.append(",'" + this.地址 + "'");
		}
		if (this.电话 != null) {
			sb.append(",'" + this.电话 + "'");
		}
		if (this.qq号码 != null) {
			sb.append(",'" + this.qq号码 + "'");
		}
		if (this.电子邮箱 != null) {
			sb.append(",'" + this.电子邮箱 + "'");
		}
		if (this.用户名 != null) {
			sb.append(",'" + this.用户名 + "'");
		}
		if (this.学历 != null) {
			sb.append(",'" + this.学历 + "'");
		}
		if (this.公示时间 != null) {
			sb.append(",'" + this.公示时间 + "'");
		}
		if (this.区号 != null) {
			sb.append(",'" + this.区号 + "'");
		}
		if (this.工作单位 != null) {
			sb.append(",'" + this.工作单位 + "'");
		}
		if (this.手机号码 != null) {
			sb.append(",'" + this.手机号码 + "'");
		}
		if (this.昵称 != null) {
			sb.append(",'" + this.昵称 + "'");
		}
		if (this.ip地址 != null) {
			sb.append(",'" + this.ip地址 + "'");
		}
		if (this.msn != null) {
			sb.append(",'" + this.msn + "'");
		}
		if (this.网址 != null) {
			sb.append(",'" + this.网址 + "'");
		}
		if (this.民族 != null) {
			sb.append(",'" + this.民族 + "'");
		}
		if (this.拼音 != null) {
			sb.append(",'" + this.拼音 + "'");
		}
		if (this.籍贯邮编 != null) {
			sb.append(",'" + this.籍贯邮编 + "'");
		}
		if (this.position != null) {
			sb.append(",'" + this.position + "'");
		}
		if (this.身高_cm != null) {
			sb.append(",'" + this.身高_cm + "'");
		}
		if (this.血型 != null) {
			sb.append(",'" + this.血型 + "'");
		}
		if (this.现住地 != null) {
			sb.append(",'" + this.现住地 + "'");
		}
		if (this.地区 != null) {
			sb.append(",'" + this.地区 + "'");
		}
		if (this.曾用名 != null) {
			sb.append(",'" + this.曾用名 + "'");
		}
		if (this.体重 != null) {
			sb.append(",'" + this.体重 + "'");
		}
		if (this.婚姻 != null) {
			sb.append(",'" + this.婚姻 + "'");
		}
		if (this.政治面貌 != null) {
			sb.append(",'" + this.政治面貌 + "'");
		}
		if (this.特长 != null) {
			sb.append(",'" + this.特长 + "'");
		}
		if (this.账号 != null) {
			sb.append(",'" + this.账号 + "'");
		}
		if (this.传真 != null) {
			sb.append(",'" + this.传真 + "'");
		}
		if (this.号码归属地 != null) {
			sb.append(",'" + this.号码归属地 + "'");
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
		return "SELECT * FROM " + this.TABLE_NAME + " WHERE sfzh18='" + this.sfzh18 + "'";
	}

}
