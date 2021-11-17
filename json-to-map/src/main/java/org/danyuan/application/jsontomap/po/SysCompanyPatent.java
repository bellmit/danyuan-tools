package org.danyuan.application.jsontomap.po;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 文件名 ： SysCompanyParter.java
 * 包 名 ： org.danyuan.application.jsontomap.po
 * 描 述 ： TODO(用一句话描述该文件做什么)
 * 机能名称：
 * 技能ID ：
 * 作 者 ： Administrator
 * 时 间 ： 2021年11月3日 下午2:02:40
 * 版 本 ： V1.0
 */
@Entity
@Table(name = "sys_company_patent")
public class SysCompanyPatent implements Serializable {
	
	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long	serialVersionUID	= 1L;
	
	// 自增长ID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long				id;
	
	// 采集时间
	@Column(name = "create_time", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	@org.hibernate.annotations.CreationTimestamp
	@DateTimeFormat(style = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	protected Date				createTime;
	
	// 数据来源
	protected String			dataFrom;
	
	// FNUM : 1, null : null
	private String				fnum;
	// CPNUM : 0, null : null
	private String				cpnum;
	// DOC_STATUS : , null : null
	private String				docStatus;
	// VID : CN112629238A, null : null
	private String				vid;
	// APSN : CN202000139816400.0001, null : null
	private String				apsn;
	// ID : CN112629238A, null : null
	private String				_id;
	// IC : G01N25/66;F26B21/00;F26B25/00, null : null
	private String				ic;
	// DOC_TYPE : I, null : null
	private String				docType;
	// PNUM : 0, null : null
	private String				pnum;
	// DBCODE : SIPOABS, null : null
	private String				dbcode;
	// AZ : , null : null
	private String				az;
	// AC : , null : null
	private String				ac;
	// AA : , null : null
	private String				aa;
	// PAVIEW : 张家港市国泰华荣化工新材料有限公司;, null : null
	private String				paview;
	// PNSN : CN999999999999000000011262923800A.0000, null : null
	private String				pnsn;
	// AP : CN202011398164, null : null
	private String				ap;
	// LANG : OTHER, null : null
	private String				lang;
	// APO : CN:202011398164:A, APO : 申请号&shy;
	private String				apo;
	// APD : 2020.12.04, AD : 申请日
	private String				apd;
	// PN : CN112629238A, PN : 公开（公告）号&shy;
	private String				pn;
	// PD : 2021.04.09, PD : 公开（公告）日
	private String				pd;
	// TIVIEW : Water removal method for electrolyte barrel, TI : 发明名称
	private String				tiview;
	// ICST : G01N25/66; F26B21/00; F26B25/00, IC : IPC分类号
	private String				icst;
	// INVIEW : 卢云龙;承杨虎;钱臻程;杨波;程勇;, IN : 发明人
	private String				inview;
	// PR : CN202011398164, PR : 优先权号
	private String				pr;
	// PRD : 2020.12.04, PRD : 优先权日
	private String				prd;
	// AGT : , AGT : 代理人
	private String				agt;
	
	private String				abview;
	private String				absimg;
	private String				ownerStatus;
	private String				prsc3Value;
	
	/**
	 * 方法名 ： getAbview
	 * 功 能 ： 返回变量 abview 的值
	 * 
	 * @return: String
	 */
	public String getAbview() {
		return abview;
	}
	
	/**
	 * 方法名 ： setAbview
	 * 功 能 ： 设置变量 abview 的值
	 */
	public void setAbview(String abview) {
		this.abview = abview;
	}
	
	/**
	 * 方法名 ： getAbsimg
	 * 功 能 ： 返回变量 absimg 的值
	 * 
	 * @return: String
	 */
	public String getAbsimg() {
		return absimg;
	}
	
	/**
	 * 方法名 ： setAbsimg
	 * 功 能 ： 设置变量 absimg 的值
	 */
	public void setAbsimg(String absimg) {
		this.absimg = absimg;
	}
	
	/**
	 * 方法名 ： getCpnum
	 * 功 能 ： 返回变量 cpnum 的值
	 * 
	 * @return: String
	 */
	public String getCpnum() {
		return cpnum;
	}
	
	/**
	 * 方法名 ： setCpnum
	 * 功 能 ： 设置变量 cpnum 的值
	 */
	public void setCpnum(String cpnum) {
		this.cpnum = cpnum;
	}
	
	/**
	 * 方法名 ： getOwnerStatus
	 * 功 能 ： 返回变量 ownerStatus 的值
	 * 
	 * @return: String
	 */
	public String getOwnerStatus() {
		return ownerStatus;
	}
	
	/**
	 * 方法名 ： setOwnerStatus
	 * 功 能 ： 设置变量 ownerStatus 的值
	 */
	public void setOwnerStatus(String ownerStatus) {
		this.ownerStatus = ownerStatus;
	}
	
	/**
	 * 方法名 ： getSerialversionuid
	 * 功 能 ： 返回变量 serialVersionUID 的值
	 * 
	 * @return: long
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	/**
	 * 方法名 ： getId
	 * 功 能 ： 返回变量 id 的值
	 * 
	 * @return: Long
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * 方法名 ： setId
	 * 功 能 ： 设置变量 id 的值
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * 方法名 ： getCreateTime
	 * 功 能 ： 返回变量 createTime 的值
	 * 
	 * @return: Date
	 */
	public Date getCreateTime() {
		return createTime;
	}
	
	/**
	 * 方法名 ： setCreateTime
	 * 功 能 ： 设置变量 createTime 的值
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	/**
	 * 方法名 ： getFnum
	 * 功 能 ： 返回变量 fnum 的值
	 * 
	 * @return: String
	 */
	public String getFnum() {
		return fnum;
	}
	
	/**
	 * 方法名 ： setFnum
	 * 功 能 ： 设置变量 fnum 的值
	 */
	public void setFnum(String fnum) {
		this.fnum = fnum;
	}
	
	/**
	 * 方法名 ： getDocStatus
	 * 功 能 ： 返回变量 docStatus 的值
	 * 
	 * @return: String
	 */
	public String getDocStatus() {
		return docStatus;
	}
	
	/**
	 * 方法名 ： setDocStatus
	 * 功 能 ： 设置变量 docStatus 的值
	 */
	public void setDocStatus(String docStatus) {
		this.docStatus = docStatus;
	}
	
	/**
	 * 方法名 ： getVid
	 * 功 能 ： 返回变量 vid 的值
	 * 
	 * @return: String
	 */
	public String getVid() {
		return vid;
	}
	
	/**
	 * 方法名 ： setVid
	 * 功 能 ： 设置变量 vid 的值
	 */
	public void setVid(String vid) {
		this.vid = vid;
	}
	
	/**
	 * 方法名 ： getApsn
	 * 功 能 ： 返回变量 apsn 的值
	 * 
	 * @return: String
	 */
	public String getApsn() {
		return apsn;
	}
	
	/**
	 * 方法名 ： setApsn
	 * 功 能 ： 设置变量 apsn 的值
	 */
	public void setApsn(String apsn) {
		this.apsn = apsn;
	}
	
	/**
	 * 方法名 ： get_id
	 * 功 能 ： 返回变量 _id 的值
	 * 
	 * @return: String
	 */
	public String get_id() {
		return _id;
	}
	
	/**
	 * 方法名 ： set_id
	 * 功 能 ： 设置变量 _id 的值
	 */
	public void set_id(String _id) {
		this._id = _id;
	}
	
	/**
	 * 方法名 ： getIc
	 * 功 能 ： 返回变量 ic 的值
	 * 
	 * @return: String
	 */
	public String getIc() {
		return ic;
	}
	
	/**
	 * 方法名 ： setIc
	 * 功 能 ： 设置变量 ic 的值
	 */
	public void setIc(String ic) {
		this.ic = ic;
	}
	
	/**
	 * 方法名 ： getDocType
	 * 功 能 ： 返回变量 docType 的值
	 * 
	 * @return: String
	 */
	public String getDocType() {
		return docType;
	}
	
	/**
	 * 方法名 ： setDocType
	 * 功 能 ： 设置变量 docType 的值
	 */
	public void setDocType(String docType) {
		this.docType = docType;
	}
	
	/**
	 * 方法名 ： getPnum
	 * 功 能 ： 返回变量 pnum 的值
	 * 
	 * @return: String
	 */
	public String getPnum() {
		return pnum;
	}
	
	/**
	 * 方法名 ： setPnum
	 * 功 能 ： 设置变量 pnum 的值
	 */
	public void setPnum(String pnum) {
		this.pnum = pnum;
	}
	
	/**
	 * 方法名 ： getDbcode
	 * 功 能 ： 返回变量 dbcode 的值
	 * 
	 * @return: String
	 */
	public String getDbcode() {
		return dbcode;
	}
	
	/**
	 * 方法名 ： setDbcode
	 * 功 能 ： 设置变量 dbcode 的值
	 */
	public void setDbcode(String dbcode) {
		this.dbcode = dbcode;
	}
	
	/**
	 * 方法名 ： getAz
	 * 功 能 ： 返回变量 az 的值
	 * 
	 * @return: String
	 */
	public String getAz() {
		return az;
	}
	
	/**
	 * 方法名 ： setAz
	 * 功 能 ： 设置变量 az 的值
	 */
	public void setAz(String az) {
		this.az = az;
	}
	
	/**
	 * 方法名 ： getAc
	 * 功 能 ： 返回变量 ac 的值
	 * 
	 * @return: String
	 */
	public String getAc() {
		return ac;
	}
	
	/**
	 * 方法名 ： setAc
	 * 功 能 ： 设置变量 ac 的值
	 */
	public void setAc(String ac) {
		this.ac = ac;
	}
	
	/**
	 * 方法名 ： getAa
	 * 功 能 ： 返回变量 aa 的值
	 * 
	 * @return: String
	 */
	public String getAa() {
		return aa;
	}
	
	/**
	 * 方法名 ： setAa
	 * 功 能 ： 设置变量 aa 的值
	 */
	public void setAa(String aa) {
		this.aa = aa;
	}
	
	/**
	 * 方法名 ： getPaview
	 * 功 能 ： 返回变量 paview 的值
	 * 
	 * @return: String
	 */
	public String getPaview() {
		return paview;
	}
	
	/**
	 * 方法名 ： setPaview
	 * 功 能 ： 设置变量 paview 的值
	 */
	public void setPaview(String paview) {
		this.paview = paview;
	}
	
	/**
	 * 方法名 ： getPnsn
	 * 功 能 ： 返回变量 pnsn 的值
	 * 
	 * @return: String
	 */
	public String getPnsn() {
		return pnsn;
	}
	
	/**
	 * 方法名 ： setPnsn
	 * 功 能 ： 设置变量 pnsn 的值
	 */
	public void setPnsn(String pnsn) {
		this.pnsn = pnsn;
	}
	
	/**
	 * 方法名 ： getAp
	 * 功 能 ： 返回变量 ap 的值
	 * 
	 * @return: String
	 */
	public String getAp() {
		return ap;
	}
	
	/**
	 * 方法名 ： setAp
	 * 功 能 ： 设置变量 ap 的值
	 */
	public void setAp(String ap) {
		this.ap = ap;
	}
	
	/**
	 * 方法名 ： getLang
	 * 功 能 ： 返回变量 lang 的值
	 * 
	 * @return: String
	 */
	public String getLang() {
		return lang;
	}
	
	/**
	 * 方法名 ： setLang
	 * 功 能 ： 设置变量 lang 的值
	 */
	public void setLang(String lang) {
		this.lang = lang;
	}
	
	/**
	 * 方法名 ： getApo
	 * 功 能 ： 返回变量 apo 的值
	 * 
	 * @return: String
	 */
	public String getApo() {
		return apo;
	}
	
	/**
	 * 方法名 ： setApo
	 * 功 能 ： 设置变量 apo 的值
	 */
	public void setApo(String apo) {
		this.apo = apo;
	}
	
	/**
	 * 方法名 ： getApd
	 * 功 能 ： 返回变量 apd 的值
	 * 
	 * @return: String
	 */
	public String getApd() {
		return apd;
	}
	
	/**
	 * 方法名 ： setApd
	 * 功 能 ： 设置变量 apd 的值
	 */
	public void setApd(String apd) {
		this.apd = apd;
	}
	
	/**
	 * 方法名 ： getPn
	 * 功 能 ： 返回变量 pn 的值
	 * 
	 * @return: String
	 */
	public String getPn() {
		return pn;
	}
	
	/**
	 * 方法名 ： setPn
	 * 功 能 ： 设置变量 pn 的值
	 */
	public void setPn(String pn) {
		this.pn = pn;
	}
	
	/**
	 * 方法名 ： getPd
	 * 功 能 ： 返回变量 pd 的值
	 * 
	 * @return: String
	 */
	public String getPd() {
		return pd;
	}
	
	/**
	 * 方法名 ： setPd
	 * 功 能 ： 设置变量 pd 的值
	 */
	public void setPd(String pd) {
		this.pd = pd;
	}
	
	/**
	 * 方法名 ： getTiview
	 * 功 能 ： 返回变量 tiview 的值
	 * 
	 * @return: String
	 */
	public String getTiview() {
		return tiview;
	}
	
	/**
	 * 方法名 ： setTiview
	 * 功 能 ： 设置变量 tiview 的值
	 */
	public void setTiview(String tiview) {
		this.tiview = tiview;
	}
	
	/**
	 * 方法名 ： getIcst
	 * 功 能 ： 返回变量 icst 的值
	 * 
	 * @return: String
	 */
	public String getIcst() {
		return icst;
	}
	
	/**
	 * 方法名 ： setIcst
	 * 功 能 ： 设置变量 icst 的值
	 */
	public void setIcst(String icst) {
		this.icst = icst;
	}
	
	/**
	 * 方法名 ： getInview
	 * 功 能 ： 返回变量 inview 的值
	 * 
	 * @return: String
	 */
	public String getInview() {
		return inview;
	}
	
	/**
	 * 方法名 ： setInview
	 * 功 能 ： 设置变量 inview 的值
	 */
	public void setInview(String inview) {
		this.inview = inview;
	}
	
	/**
	 * 方法名 ： getPr
	 * 功 能 ： 返回变量 pr 的值
	 * 
	 * @return: String
	 */
	public String getPr() {
		return pr;
	}
	
	/**
	 * 方法名 ： setPr
	 * 功 能 ： 设置变量 pr 的值
	 */
	public void setPr(String pr) {
		this.pr = pr;
	}
	
	/**
	 * 方法名 ： getPrd
	 * 功 能 ： 返回变量 prd 的值
	 * 
	 * @return: String
	 */
	public String getPrd() {
		return prd;
	}
	
	/**
	 * 方法名 ： setPrd
	 * 功 能 ： 设置变量 prd 的值
	 */
	public void setPrd(String prd) {
		this.prd = prd;
	}
	
	/**
	 * 方法名 ： getAgt
	 * 功 能 ： 返回变量 agt 的值
	 * 
	 * @return: String
	 */
	public String getAgt() {
		return agt;
	}
	
	/**
	 * 方法名 ： setAgt
	 * 功 能 ： 设置变量 agt 的值
	 */
	public void setAgt(String agt) {
		this.agt = agt;
	}
	
	/**
	 * 方法名 ： getDataFrom
	 * 功 能 ： 返回变量 dataFrom 的值
	 * 
	 * @return: String
	 */
	public String getDataFrom() {
		return dataFrom;
	}
	
	/**
	 * 方法名 ： setDataFrom
	 * 功 能 ： 设置变量 dataFrom 的值
	 */
	public void setDataFrom(String dataFrom) {
		this.dataFrom = dataFrom;
	}
	
	/**
	 * 方法名 ： getPrsc3Value
	 * 功 能 ： 返回变量 prsc3Value 的值
	 * 
	 * @return: String
	 */
	public String getPrsc3Value() {
		return prsc3Value;
	}
	
	/**
	 * 方法名 ： setPrsc3Value
	 * 功 能 ： 设置变量 prsc3Value 的值
	 */
	public void setPrsc3Value(String prsc3Value) {
		this.prsc3Value = prsc3Value;
	}
	
}
