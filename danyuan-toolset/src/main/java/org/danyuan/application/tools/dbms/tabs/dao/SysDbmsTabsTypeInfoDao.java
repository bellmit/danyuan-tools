package org.danyuan.application.tools.dbms.tabs.dao;

import org.danyuan.application.tools.common.base.BaseDao;
import org.danyuan.application.tools.dbms.tabs.po.SysDbmsTabsTypeInfo;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.stereotype.Repository;

/**
 * 文件名 ： SysTableTypeDao.java <br/>
 * 包 名 ： {@link tk.ainiyue.danyuan.application.dbm.type.dao} <br/>
 * 描 述 ： TODO(用一句话描述该文件做什么) <br/>
 * 机能名称： <br/>
 * 技能ID ：
 * 作 者 ： wang <br/>
 * 时 间 ： 2017年8月3日 下午3:58:14 <br/>
 * 版 本 ： V1.0 <br/>
 */
@Repository("sysDbmsTabsTypeInfoDao")
@DynamicUpdate(true)
@DynamicInsert(true)
public interface SysDbmsTabsTypeInfoDao extends BaseDao<SysDbmsTabsTypeInfo> {

}
