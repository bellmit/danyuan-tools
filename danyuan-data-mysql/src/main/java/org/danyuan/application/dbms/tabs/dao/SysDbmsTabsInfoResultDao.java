package org.danyuan.application.dbms.tabs.dao;

import java.util.List;

import org.danyuan.application.common.base.BaseDao;
import org.danyuan.application.dbms.tabs.po.SysDbmsTabsInfoResult;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
public interface SysDbmsTabsInfoResultDao extends BaseDao<SysDbmsTabsInfoResult> {

	/**
	 * @param request
	 * @param list
	 * @param string
	 *            方法名： findAllByTableUuid
	 *            功 能： TODO(这里用一句话描述这个方法的作用)
	 *            参 数： @return
	 *            返 回： Page<SysDbmsTabsInfo>
	 *            作 者 ： Administrator
	 * @throws
	 */
	@Query(value = "select UUID() AS uuid," + " :jdbcUuid as jdbc_uuid,'MYSQL' AS db_type," + " CONCAT(t.`TABLE_SCHEMA`,'.' ,t.`TABLE_NAME`) AS tabs_name," + "'WEIFENLEI' as type_uuid,t.`TABLE_COMMENT`  AS tabs_desc,t.`TABLE_ROWS` AS tabs_rows   " + " from information_schema.tables t " + " where t.table_schema not in ('INFORMATION_SCHEMA','performance_schema','mysql' ,'sys') " + " and TABLE_TYPE = 'BASE TABLE' " + " and if(:tableName !=null,table_name  like concat('%',:tableName,'%'),1=1) " + " and if(:list !=null,table_name   not in (:list),1=1) ", countQuery = "select count(:jdbcUuid) as l " + " from information_schema.tables t " + " where t.table_schema not in ('INFORMATION_SCHEMA','performance_schema','mysql' ,'sys') " + " and TABLE_TYPE = 'BASE TABLE' " + " and if(:tableName !=null,table_name  like concat('%',:tableName,'%'),1=1) " + " and if(:list !=null,table_name   not in (:list),1=1) ", nativeQuery = true)
	Page<SysDbmsTabsInfoResult> findAllByTableUuid(@Param("jdbcUuid") String jdbcUuid, @Param("tableName") String tableName, @Param("list") List<String> list, Pageable pageable);

}
