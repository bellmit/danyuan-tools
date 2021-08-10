package org.danyuan.application.dbms.tabs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.danyuan.application.bean.manager.dbms.SysDbmsTabsColsInfo;
import org.danyuan.application.bean.manager.dbms.SysDbmsTabsInfo;
import org.danyuan.application.common.base.BaseService;
import org.danyuan.application.common.base.BaseServiceImpl;
import org.danyuan.application.common.base.Pagination;
import org.danyuan.application.dbms.tabs.dao.SysDbmsTabsColsInfoDao;
import org.danyuan.application.dbms.tabs.dao.SysDbmsTabsInfoDao;
import org.danyuan.application.dbms.tabs.vo.MulteityParam;
import org.danyuan.application.dbms.tabs.vo.SysDbmsTabsInfoVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * 文件名 ： SysTableServiceImpl.java
 * 包 名 ： tk.ainiyue.danyuan.application.dbm.table.service.impl
 * 描 述 ： TODO(用一句话描述该文件做什么)
 * 机能名称：
 * 技能ID ：
 * 作 者 ： wang
 * 时 间 ： 2017年8月3日 下午3:55:43
 * 版 本 ： V1.0
 */
@Service("sysDbmsTabsInfoService")
public class SysDbmsTabsInfoService extends BaseServiceImpl<SysDbmsTabsInfo> implements BaseService<SysDbmsTabsInfo> {
	
	private static final Logger		logger	= LoggerFactory.getLogger(SysDbmsTabsInfoService.class);
	//
	@Autowired
	private SysDbmsTabsInfoDao		sysDbmsTabsInfoDao;
	@Autowired
	private SysDbmsTabsColsInfoDao	sysDbmsTabsColsInfoDao;
	@Autowired
	JdbcTemplate					jdbcTemplate;
	
	public List<SysDbmsTabsInfo> findAll() {
		return sysDbmsTabsInfoDao.findAll();
	}
	
	/**
	 * 方法名 ： save
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @param info
	 * 参 考 ： @see tk.ainiyue.danyuan.application.common.base.BaseService#save(java.lang.Object)
	 * 作 者 ： wang
	 */
	@Override
	public SysDbmsTabsInfo save(SysDbmsTabsInfo info) {
		// 保存表配信息
		sysDbmsTabsInfoDao.save(info);
		// 动态生成表
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("CREATE TABLE ");
		sBuilder.append(info.getTabsName());
		sBuilder.append("(md5 varchar(36) comment 'url的md5值' )");
		
		jdbcTemplate.execute(sBuilder.toString());
		
		// 保存列的配置信息
		sysDbmsTabsColsInfoDao.save(new SysDbmsTabsColsInfo(UUID.randomUUID().toString(), info.getUuid(), "md5", "md5值", "VARCHAR", 0, 1, 1, "center", "middle", 150, true, true, 0));
		// sysDbmsTabsColsInfoDao.save(new SysDbmsTabsColsInfo(UUID.randomUUID().toString(), 2000, "url地址", "url", 2, "VARCHAR", "url地址", info.getUuid()));
		// sysDbmsTabsColsInfoDao.save(new SysDbmsTabsColsInfo(UUID.randomUUID().toString(), 50, "数据来源", "数据来源", 3, "VARCHAR", "数据来源", info.getUuid()));
		// sysDbmsTabsColsInfoDao.save(new SysDbmsTabsColsInfo(UUID.randomUUID().toString(), 6, "采集时间", "datetime", 4, "date", "采集时间", info.getUuid()));
		// 返回表配置信息
		return info;
	}
	
	public SysDbmsTabsInfo findSysDbmsTabsInofByUuid(String uuid) {
		return sysDbmsTabsInfoDao.findSysDbmsTabsInfoByUuid(uuid);
	}
	
	public List<SysDbmsTabsInfo> updateSysTableInfo(SysDbmsTabsInfoVo vo) {
		// 旧数据
		SysDbmsTabsInfo info = vo.getOld();
		SysDbmsTabsInfo sysDbmsTabsInfo = vo.getNow();
		
		if (!info.getTabsName().equals(sysDbmsTabsInfo.getTabsName())) {
			// 修改表名
			String sql = "ALTER TABLE " + info.getTabsName() + "  RENAME TO  " + sysDbmsTabsInfo.getTabsName();
			jdbcTemplate.execute(sql);
		}
		if (sysDbmsTabsInfo.getTabsName() != null) {
			// 修改注释
			String sql = "ALTER TABLE " + sysDbmsTabsInfo.getTabsName() + "  COMMENT='" + sysDbmsTabsInfo.getTabsDesc() + "'";
			jdbcTemplate.execute(sql);
		}
		// 修改配置信息
		sysDbmsTabsInfoDao.save(sysDbmsTabsInfo);
		
		return sysDbmsTabsInfoDao.findAll();
	}
	
	/**
	 * 方法名 ： findOne
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @param info
	 * 参 数 ： @return
	 * 参 考 ： @see tk.ainiyue.danyuan.application.common.base.BaseService#findOne(java.lang.Object)
	 * 作 者 ： wang
	 */
	
	@Override
	public SysDbmsTabsInfo findOne(SysDbmsTabsInfo info) {
		Example<SysDbmsTabsInfo> example = Example.of(info);
		Optional<SysDbmsTabsInfo> info2 = sysDbmsTabsInfoDao.findOne(example);
		if (info2.isPresent()) {
			return info2.get();
		}
		return null;
	}
	
	/**
	 * 方法名 ： page
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @param pageNumber
	 * 参 数 ： @param pageSize
	 * 参 数 ： @param info
	 * 参 数 ： @param map
	 * 参 数 ： @param order
	 * 参 数 ： @return
	 * 参 考 ： @see tk.ainiyue.danyuan.application.common.base.BaseService#page(int, int, java.lang.Object, java.util.Map, org.springframework.data.domain.Sort.Order[])
	 * 作 者 ： wang
	 */
	
	@Override
	public Page<SysDbmsTabsInfo> page(Pagination<SysDbmsTabsInfo> vo) {
		List<Order> orders = new ArrayList<>();
		
		if (vo.getSortName() != null) {
			Order order;
			if (vo.getSortOrder().equals("desc")) {
				order = Order.desc(vo.getSortName());
			} else {
				order = Order.asc(vo.getSortName());
			}
			orders.add(order);
		} else {
			Order order1 = new Order(Direction.ASC, "tabsOrder");
			orders.add(order1);
			Order order2 = new Order(Direction.DESC, "createTime");
			orders.add(order2);
		}
		if (vo.getInfo() == null) {
			vo.setInfo(new SysDbmsTabsInfo());
		}
		
		Sort sort = Sort.by(orders);
		PageRequest request = PageRequest.of(vo.getPageNumber() - 1, vo.getPageSize(), sort);
		Page<SysDbmsTabsInfo> page = sysDbmsTabsInfoDao.findAll(new Specification<SysDbmsTabsInfo>() {
			
			/**
			 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
			 */
			private static final long serialVersionUID = 1L;
			
			@Override
			public Predicate toPredicate(Root<SysDbmsTabsInfo> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> list = new ArrayList<>();
				if (vo.getInfo().getJdbcUuid() != null && !"".equals(vo.getInfo().getJdbcUuid())) {
					list.add(criteriaBuilder.equal(root.get("jdbcUuid"), vo.getInfo().getJdbcUuid()));
				}
				if (vo.getInfo().getTypeUuid() != null && !"".equals(vo.getInfo().getTypeUuid())) {
					list.add(criteriaBuilder.equal(root.get("typeUuid"), vo.getInfo().getTypeUuid()));
				}
				if (vo.getInfo().getTabsName() != null && !"".equals(vo.getInfo().getTabsName())) {
					list.add(criteriaBuilder.like(root.get("tabsName"), "%" + vo.getInfo().getTabsName() + "%"));
				}
				if (vo.getInfo().getTabsDesc() != null && !"".equals(vo.getInfo().getTabsDesc())) {
					list.add(criteriaBuilder.like(root.get("tabsDesc"), "%" + vo.getInfo().getTabsDesc() + "%"));
				}
				return criteriaBuilder.and(list.toArray(new Predicate[list.size()]));
			}
		}, request);
		return page;
	}
	
	/**
	 * 方法名 ： delete
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @param list
	 * 参 考 ： @see tk.ainiyue.danyuan.application.common.base.BaseService#delete(java.util.List)
	 * 作 者 ： wang
	 */
	
	public void drop(List<SysDbmsTabsInfo> list) {
		for (SysDbmsTabsInfo info : list) {
			try {
				StringBuilder sBuilder = new StringBuilder();
				sBuilder.append("drop table " + info.getTabsName());
				jdbcTemplate.execute(sBuilder.toString());
			} catch (Exception e) {
				logger.error(info.getTabsName() + "表不存在", SysDbmsTabsInfoService.class);
			} finally {
				sysDbmsTabsColsInfoDao.deleteByTabsUuid(info.getUuid());
				sysDbmsTabsInfoDao.delete(info);
			}
		}
	}
	
	@Override
	public void deleteAll(List<SysDbmsTabsInfo> list) {
		for (SysDbmsTabsInfo info : list) {
			sysDbmsTabsColsInfoDao.deleteByTabsUuid(info.getUuid());
			sysDbmsTabsInfoDao.delete(info);
		}
	}
	
	/**
	 * 方法名 ： findAll
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @param info
	 * 参 数 ： @return
	 * 参 考 ： @see tk.ainiyue.danyuan.application.common.base.BaseService#findAll(java.lang.Object)
	 * 作 者 ： wang
	 */
	
	@Override
	public List<SysDbmsTabsInfo> findAll(SysDbmsTabsInfo info) {
		Example<SysDbmsTabsInfo> example = Example.of(info);
		return sysDbmsTabsInfoDao.findAll(example);
	}
	
	/**
	 * 方法名： findAllTable
	 * 功 能： TODO(这里用一句话描述这个方法的作用)
	 * 参 数： @param username
	 * 参 数： @param userindex
	 * 参 数： @param uservalue
	 * 参 数： @return
	 * 返 回： List<SysZhcxTab>
	 * 作 者 ： Administrator
	 * @throws
	 */
	public List<SysDbmsTabsInfo> findAllTable(SysDbmsTabsInfoVo vo) {
		
		if (vo.getParamList() == null || vo.getParamList().size() == 0) {
			// 无条件查询
			return sysDbmsTabsInfoDao.findAllByUserIndexAndTypeUuid(vo.getUserindex(), vo.getTypeUuid());
		} else {
			// 多条件时循环查询并找出userindex都有的表
			List<SysDbmsTabsInfo> minusList = null;
			for (MulteityParam val : vo.getParamList()) {
				List<SysDbmsTabsInfo> tabsList = sysDbmsTabsInfoDao.findAllByUserIndexAndTypeUuid(val.getUserIndex(), vo.getTypeUuid());
				if (tabsList == null) {
					return null;
				}
				if (minusList == null) {
					minusList = tabsList;
				} else {
					List<SysDbmsTabsInfo> existsList = new ArrayList<>();
					// 多个userindex对比找到相同表
					for (SysDbmsTabsInfo sysZhcxTab : minusList) {
						for (SysDbmsTabsInfo sysZhcxTab2 : tabsList) {
							if (sysZhcxTab.getUuid().equals(sysZhcxTab2.getUuid())) {
								existsList.add(sysZhcxTab);
							}
						}
					}
					minusList = existsList;
					if (minusList.size() == 0) {
						return null;
					}
				}
			}
			
			// 多条件查询
			return minusList;
		}
	}
	
	/**
	 * 方法名： change
	 * 功 能： TODO(这里用一句话描述这个方法的作用)
	 * 参 数： @param vo
	 * 返 回： void
	 * 作 者 ： Administrator
	 * @throws
	 */
	public void change(SysDbmsTabsInfoVo vo) {
		// 保存表配信息
		// 动态生成表
		try {
			SysDbmsTabsInfo info = vo.getOld();
			SysDbmsTabsInfo sysDbmsTabsInfo = vo.getNow();
			if (!info.getTabsName().equals(sysDbmsTabsInfo.getTabsName())) {
				StringBuilder sBuilder = new StringBuilder();
				sBuilder.append("ALTER TABLE ");
				sBuilder.append(vo.getOld().getTabsName());
				sBuilder.append(" RENAME TO ");
				sBuilder.append(vo.getNow().getTabsName());
				
				jdbcTemplate.execute(sBuilder.toString());
			}
			if (sysDbmsTabsInfo.getTabsName() != null) {
				sysDbmsTabsInfoDao.change(vo.getNow().getTabsName(), vo.getNow().getTabsDesc(), vo.getNow().getTypeUuid(), vo.getNow().getJdbcUuid(), vo.getNow().getUuid(), vo.getUsername());
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(), SysDbmsTabsInfoService.class);
		}
		
	}
	
	/**
	 * @方法名 findAllTableByUser
	 * @功能 TODO(这里用一句话描述这个方法的作用)
	 * @参数 @param vo
	 * @参数 @return
	 * @返回 List<SysDbmsTabsInfo>
	 * @author Administrator
	 * @throws
	 */
	public List<SysDbmsTabsInfo> findAllTableByUser(SysDbmsTabsInfoVo vo) {
		// 多条件时循环查询并找出userindex都有的表
		List<SysDbmsTabsInfo> minusList = null;
		for (MulteityParam val : vo.getParamList()) {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("select distinct * from sys_dbms_tabs_info a ");
			stringBuilder.append("  where a.uuid in ( ");
			stringBuilder.append("   select b.tabs_id from sys_roles_tabs_info b ");
			stringBuilder.append("    where b.role_id in (");
			stringBuilder.append("     select c.roles_id from sys_user_roles_info c");
			stringBuilder.append("      where c.user_id in ( ");
			stringBuilder.append("       select d.uuid from sys_user_base_info d");
			stringBuilder.append("        where d.user_name = '" + vo.getUsername() + "'");
			stringBuilder.append("      ) and c.checked = 1");
			stringBuilder.append("    ) ");
			stringBuilder.append("  ) and a.delete_flag = 0");
			stringBuilder.append("  and a.type_uuid='" + vo.getTypeUuid() + "' ");
			stringBuilder.append("  and a.uuid in  ( ");
			stringBuilder.append("  select c.tabs_uuid from sys_dbms_tabs_cols_info c ");
			stringBuilder.append("   where c.user_index='" + val.getUserIndex() + "' ");
			stringBuilder.append("   and c.delete_flag = 0  ");
			stringBuilder.append("  ) ");
			stringBuilder.append("  order by a.tabs_order ");
			NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
			List<SysDbmsTabsInfo> tabsList = template.query(stringBuilder.toString(), new BeanPropertyRowMapper<>(SysDbmsTabsInfo.class));
			
			// List<SysDbmsTabsInfo> tabsList = sysDbmsTabsInfoDao.findAllByUserIndexAndTypeUuid(val.getUserIndex(), vo.getTypeUuid());
			if (tabsList == null) {
				return null;
			}
			if (minusList == null) {
				minusList = tabsList;
			} else {
				List<SysDbmsTabsInfo> existsList = new ArrayList<>();
				// 多个userindex对比找到相同表
				for (SysDbmsTabsInfo sysZhcxTab : minusList) {
					for (SysDbmsTabsInfo sysZhcxTab2 : tabsList) {
						if (sysZhcxTab.getUuid().equals(sysZhcxTab2.getUuid())) {
							existsList.add(sysZhcxTab);
						}
					}
				}
				minusList = existsList;
				if (minusList.size() == 0) {
					return null;
				}
			}
		}
		
		// 多条件查询
		return minusList;
	}
	
	public List<SysDbmsTabsInfo> findAllTableByTypeUuidAndUsername(SysDbmsTabsInfoVo vo) {
		// 多条件时循环查询并找出userindex都有的表
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select distinct * from sys_dbms_tabs_info a ");
		stringBuilder.append("  where a.uuid in ( ");
		stringBuilder.append("   select b.tabs_id from sys_roles_tabs_info b ");
		stringBuilder.append("    where b.role_id in (");
		stringBuilder.append("     select c.roles_id from sys_user_roles_info c");
		stringBuilder.append("      where c.user_id in ( ");
		stringBuilder.append("       select d.uuid from sys_user_base_info d");
		stringBuilder.append("        where d.user_name = '" + vo.getUsername() + "'");
		stringBuilder.append("      ) and c.checked = 1");
		stringBuilder.append("    ) ");
		stringBuilder.append("  ) and a.delete_flag = 0");
		stringBuilder.append("  and a.type_uuid='" + vo.getInfo().getTypeUuid() + "' ");
		stringBuilder.append("  order by a.tabs_order ");
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		List<SysDbmsTabsInfo> tabsList = template.query(stringBuilder.toString(), new BeanPropertyRowMapper<>(SysDbmsTabsInfo.class));
		// 多条件查询
		return tabsList;
	}
	
	/**
	 * @方法名 findAllBySysTableInfoAndUsername
	 * @功能 TODO(这里用一句话描述这个方法的作用)
	 * @参数 @param sysDbmsTabsInfo
	 * @参数 @return
	 * @返回 List<SysDbmsTabsInfo>
	 * @author Administrator
	 * @throws
	 */
	public List<SysDbmsTabsInfo> findAllBySysTableInfoAndUsername(SysDbmsTabsInfo sysDbmsTabsInfo) {
		// 多条件时循环查询并找出userindex都有的表
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select distinct * from sys_dbms_tabs_info a ");
		stringBuilder.append("  where a.uuid in ( ");
		stringBuilder.append("   select b.tabs_id from sys_roles_tabs_info b ");
		stringBuilder.append("    where b.role_id in (");
		stringBuilder.append("     select c.roles_id from sys_user_roles_info c");
		stringBuilder.append("      where c.user_id in ( ");
		stringBuilder.append("       select d.uuid from sys_user_base_info d");
		stringBuilder.append("        where d.user_name = '" + sysDbmsTabsInfo.getCreateUser() + "'");
		stringBuilder.append("      ) and c.checked = 1");
		stringBuilder.append("    ) ");
		stringBuilder.append("  ) and a.delete_flag = 0");
		if (sysDbmsTabsInfo.getTypeUuid() != null && !"".equals(sysDbmsTabsInfo.getTypeUuid())) {
			stringBuilder.append("  and a.type_uuid = '" + sysDbmsTabsInfo.getTypeUuid() + "' ");
		}
		
		if (sysDbmsTabsInfo.getJdbcUuid() != null && !"".equals(sysDbmsTabsInfo.getJdbcUuid())) {
			stringBuilder.append("  and a.jdbc_uuid = '" + sysDbmsTabsInfo.getJdbcUuid() + "' ");
		}
		stringBuilder.append("  order by a.tabs_order ");
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		List<SysDbmsTabsInfo> tabsList = template.query(stringBuilder.toString(), new BeanPropertyRowMapper<>(SysDbmsTabsInfo.class));
		// 多条件查询
		return tabsList;
	}
	
}
