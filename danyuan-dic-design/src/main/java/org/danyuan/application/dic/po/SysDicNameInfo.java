package org.danyuan.application.dic.po;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.danyuan.application.common.base.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 文件名 ： SysDicNameInfo.java
 * 包 名 ： org.danyuan.application.dic.po
 * 描 述 ： TODO(用一句话描述该文件做什么)
 * 机能名称：
 * 技能ID ：
 * 作 者 ： Administrator
 * 时 间 ： 2021年9月10日 下午3:04:13
 * 版 本 ： V1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "sys_dic_name_info")
@NamedQuery(name = "SysDicNameInfo.findAll", query = "SELECT s FROM SysDicNameInfo s")
public class SysDicNameInfo extends BaseEntity implements Serializable {
	private static final long	serialVersionUID	= 1L;
	
	private String				name;
	private String				code;
	private String				label;
	
}
