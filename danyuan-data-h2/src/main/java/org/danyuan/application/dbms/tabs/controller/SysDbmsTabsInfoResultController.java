package org.danyuan.application.dbms.tabs.controller;

import org.danyuan.application.bean.manager.dbms.SysDbmsTabsInfo;
import org.danyuan.application.common.base.BaseController;
import org.danyuan.application.common.base.BaseControllerImpl;
import org.danyuan.application.common.base.BaseResult;
import org.danyuan.application.common.base.Pagination;
import org.danyuan.application.common.base.ResultUtil;
import org.danyuan.application.dbms.tabs.po.SysDbmsTabsInfoResult;
import org.danyuan.application.dbms.tabs.service.SysDbmsTabsInfoResultService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 文件名 ： SysDbmsTabsInfoController.java
 * 包 名 ： tk.ainiyue.danyuan.application.dbm.table.controller
 * 描 述 ： TODO(用一句话描述该文件做什么)
 * 机能名称：
 * 技能ID ：
 * 作 者 ： wang
 * 时 间 ： 2017年8月3日 下午3:54:36
 * 版 本 ： V1.0
 */
@RestController
@RequestMapping("/sysDbmsTabsInfo")
public class SysDbmsTabsInfoResultController extends BaseControllerImpl<SysDbmsTabsInfoResult> implements BaseController<SysDbmsTabsInfoResult> {
	
	private static final Logger		logger	= LoggerFactory.getLogger(SysDbmsTabsInfoResultController.class);
	
	@Autowired
	SysDbmsTabsInfoResultService	sysDbmsTabsInfoResultService;
	
	@RequestMapping(value = "/findAllByTableUuid", method = { RequestMethod.POST })
	public BaseResult<Page<SysDbmsTabsInfoResult>> findAllByTableUuid(@RequestBody Pagination<SysDbmsTabsInfo> vo) {
		logger.info("数据库表信息查询：{}", vo.toString());
		Page<SysDbmsTabsInfoResult> page = sysDbmsTabsInfoResultService.findAllByTableUuid(vo);
		return ResultUtil.success(page);
	}
	
}
