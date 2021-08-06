package org.danyuan.application.tools.dbms.tabs.controller;

import java.util.List;
import java.util.UUID;

import org.danyuan.application.tools.common.base.Pagination;
import org.danyuan.application.tools.dbms.tabs.po.SysDbmsTabsColsInfo;
import org.danyuan.application.tools.dbms.tabs.service.SysDbmsTabsColsInfoService;
import org.danyuan.application.tools.dbms.tabs.vo.SysDbmsTabsColsInfoVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 文件名 ： SysDbmsTabsColsInfoController.java 
 * 包 名 ：
 * tk.ainiyue.danyuan.application.dbm.column.controller 
 * 描 述 ： TODO(用一句话描述该文件做什么)
 * 机能名称： 
 * 技能ID ： 
 * 作 者 ： wang 
 * 时 间 ： 2017年8月3日 下午3:51:35 
 * 版 本 ： V1.0
 */
public class SysDbmsTabsColsInfoController {
	//
	private static final Logger logger = LoggerFactory.getLogger(SysDbmsTabsColsInfoController.class);

	//
	@Autowired
	private SysDbmsTabsColsInfoService sysDbmsTabsColsInfoService;

	@Autowired
	JdbcTemplate jdbcTemplate;

	/**
	 * 方法名： findAll 
	 * 功 能： TODO(这里用一句话描述这个方法的作用) 
	 * 参 数： 返 回 : 
	 * 返 回：List<SysSeedInfo> 
	 * 作 者 ： Tenghui.Wang 
	 * 
	 */
	public Page<SysDbmsTabsColsInfo> findAll(int pageNumber, int pageSize, String searchText, String uuid) {
		logger.info("findAll", SysDbmsTabsColsInfoController.class);
		return sysDbmsTabsColsInfoService.findAllByTableUuid(pageNumber, pageSize, searchText, uuid);
	}

	public Page<SysDbmsTabsColsInfo> page(Pagination<SysDbmsTabsColsInfo> vo) {
		logger.info("page", SysDbmsTabsColsInfoController.class);
		return sysDbmsTabsColsInfoService.page(vo);
	}

	public List<SysDbmsTabsColsInfo> pagev(Pagination<SysDbmsTabsColsInfo> vo) {
		logger.info("pagev", SysDbmsTabsColsInfoController.class);

		return sysDbmsTabsColsInfoService.pagev(vo.getInfo().getTabsUuid());

	}

	public Page<SysDbmsTabsColsInfo> findAll1(SysDbmsTabsColsInfoVo vo) {
		logger.info("findAll", SysDbmsTabsColsInfoController.class);
		return sysDbmsTabsColsInfoService.findAllByTableUuid(vo.getPageNumber(), vo.getPageSize(), vo.getSearchText(),
				vo.getUuid());
	}

	public List<SysDbmsTabsColsInfo> findAllBySysDbmsTabsColsInfo(SysDbmsTabsColsInfo info) {
		logger.info("findAll", SysDbmsTabsColsInfoController.class);
		return sysDbmsTabsColsInfoService.findAllBySysDbmsTabsColsInfo(info);
	}

	public Page<SysDbmsTabsColsInfo> saveSysDbmsTabsColsInfo(SysDbmsTabsColsInfo info) {
		logger.info("saveSysDbmsTabsColsInfo", SysDbmsTabsColsInfoController.class);
		sysDbmsTabsColsInfoService.change(info);
		return sysDbmsTabsColsInfoService.findAllByTableUuid(1, 10, "", info.getTabsUuid());

	}

	public String save(SysDbmsTabsColsInfo info) {
		logger.info("saveSysDbmsTabsColsInfo", SysDbmsTabsColsInfoController.class);
		sysDbmsTabsColsInfoService.save(info);
		return "1";

	}

	public Page<SysDbmsTabsColsInfo> saveSysColumnVo(SysDbmsTabsColsInfoVo vo) {
		logger.info("saveSysColumnVo", SysDbmsTabsColsInfoController.class);
		sysDbmsTabsColsInfoService.saveAll(vo.getList());
		return sysDbmsTabsColsInfoService.findAllByTableUuid(1, 20, "", vo.getList().get(0).getTabsUuid());
	}

	public String savev(SysDbmsTabsColsInfoVo vo) {
		logger.info("savev", SysDbmsTabsColsInfoController.class);
		for (SysDbmsTabsColsInfo info : vo.getList()) {
			info.setUuid(UUID.randomUUID().toString());
			info.setDeleteFlag(0);
			info.setCreateUser(vo.getUsername());
			info.setColsAlign("center");
			info.setColsValign("middle");
			info.setColsSwitchable(true);
			info.setColsWidth(150);
			info.setColsVisible(true);
			info.setCreateUser(vo.getUsername());
			info.setUpdateUser(vo.getUsername());
			sysDbmsTabsColsInfoService.save(info);
		}
		return "1";
	}

	public String delete(SysDbmsTabsColsInfoVo vo) {
		logger.info("delete", SysDbmsTabsColsInfoController.class);
		sysDbmsTabsColsInfoService.deleteAll(vo.getList());
		return "1";

	}

}
