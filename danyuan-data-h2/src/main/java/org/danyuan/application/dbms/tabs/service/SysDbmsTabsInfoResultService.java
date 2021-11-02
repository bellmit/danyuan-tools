package org.danyuan.application.dbms.tabs.service;

import java.util.ArrayList;
import java.util.List;

import org.danyuan.application.bean.manager.dbms.SysDbmsTabsInfo;
import org.danyuan.application.common.base.BaseService;
import org.danyuan.application.common.base.BaseServiceImpl;
import org.danyuan.application.common.base.Pagination;
import org.danyuan.application.dbms.tabs.dao.SysDbmsTabsInfoResultDao;
import org.danyuan.application.dbms.tabs.po.SysDbmsTabsInfoResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
public class SysDbmsTabsInfoResultService extends BaseServiceImpl<SysDbmsTabsInfoResult> implements BaseService<SysDbmsTabsInfoResult> {
	
	//
	private static final Logger	logger	= LoggerFactory.getLogger(SysDbmsTabsInfoResultService.class);
	
	@Autowired
	SysDbmsTabsInfoResultDao	sysDbmsTabsInfoResultDao;
	
	/**
	 * 方法名： findAllByTableUuid
	 * 功 能： TODO(这里用一句话描述这个方法的作用)
	 * 参 数： @param vo
	 * 参 数： @return
	 * 返 回： Page<SysDbmsTabsInfo>
	 * 作 者 ： Administrator
	 * @throws
	 */
	public Page<SysDbmsTabsInfoResult> findAllByTableUuid(Pagination<SysDbmsTabsInfo> vo) {
		logger.info("微服务访问{}开始。", vo.getInfo().getJdbcUuid());
		String tableName = vo.getInfo().getTabsName() != null ? vo.getInfo().getTabsName().toUpperCase() : null;
		
		List<String> list = null;
		if (vo.getList() != null) {
			for (SysDbmsTabsInfo sysDbmsTabsInfo : vo.getList()) {
				if (list == null) {
					list = new ArrayList<>();
				}
				list.add(sysDbmsTabsInfo.getTabsName());
			}
		}
		PageRequest request = PageRequest.of(vo.getPageNumber() - 1, vo.getPageSize());
		Page<SysDbmsTabsInfoResult> page = sysDbmsTabsInfoResultDao.findAllByTableUuid(vo.getInfo().getJdbcUuid(), tableName, list, request);
		return page;
	}
	
}
