package org.danyuan.application.dbms.tabs.dao;

import java.util.List;

import org.danyuan.application.bean.manager.dbms.SysDbmsTabsInfo;
import org.danyuan.application.common.base.BaseDao;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * 文件名 ： SysTableDao.java
 * 包 名 ： tk.ainiyue.danyuan.application.dbm.table.dao
 * 描 述 ： TODO(用一句话描述该文件做什么)
 * 机能名称：
 * 技能ID ：
 * 作 者 ： wang
 * 时 间 ： 2017年8月3日 下午3:54:48
 * 版 本 ： V1.0
 */
@Repository("sysDbmsTabsInfoDao")
@DynamicUpdate(true)
@DynamicInsert(true)
public interface SysDbmsTabsInfoDao extends BaseDao<SysDbmsTabsInfo> {
	
	/**
	 * @param request
	 * @param list
	 * @param string
	 * 方法名： findAllByTableUuid
	 * 功 能： TODO(这里用一句话描述这个方法的作用)
	 * 参 数： @return
	 * 返 回： Page<SysDbmsTabsInfo>
	 * 作 者 ： Administrator
	 * @throws
	 */
	@Query(value = "select UUID() AS uuid,"
			+ "'?1' as jdbc_uuid,'MYSQL' AS db_type,"
			+ " CONCAT(T.`TABLE_SCHEMA`,'.' ,T.`TABLE_NAME`) AS tabs_name,"
			+ "'WEIFENLEI' as type_uuid,t.`TABLE_COMMENT`  AS tabs_desc,t.`TABLE_ROWS` AS tabs_rows   "
			+ " from information_schema.tables t "
			+ " where t.table_schema !='INFORMATION_SCHEMA' "
			+ " and TABLE_TYPE = 'TABLE' "
			+ " and if(?2 !=''|null,table_name  like '?2%',1=1) "
			+ " and if(?3 !=null,table_name   not in (?3),1=1)", nativeQuery = true)
	Page<SysDbmsTabsInfo> findAllByTableUuid(String jdbcUuid,String tableName,  List<String> list, Pageable pageable);
	
}
