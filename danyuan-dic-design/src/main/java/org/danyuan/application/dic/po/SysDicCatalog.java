package org.danyuan.application.dic.po;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.danyuan.application.common.base.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 文件名 ： SysDicCatalog.java
 * 包 名 ： org.danyuan.application.dic.po
 * 描 述 ： TODO(用一句话描述该文件做什么)
 * 机能名称：
 * 技能ID ：
 * 作 者 ： Administrator
 * 时 间 ： 2021年9月10日 下午3:08:34
 * 版 本 ： V1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "sys_dic_catalog")
@NamedQuery(name = "SysDicCatalog.findAll", query = "SELECT s FROM SysDicCatalog s")
public class SysDicCatalog extends BaseEntity implements Serializable {
	private static final long	serialVersionUID	= 1L;
	
	private String				catalog;
	private String				nameId;
	private String				code;
	private String				parent;
	private Integer				sort;
	
}
