package org.danyuan.application.dbms.tabs.controller;

import org.danyuan.application.bean.manager.dbms.SysDbmsTabsJdbcInfo;
import org.danyuan.application.common.base.BaseController;
import org.danyuan.application.common.base.BaseControllerImpl;
import org.danyuan.application.dbms.tabs.service.SysDbmsTabsJdbcInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 文件名 ： SysDbmsTabsJdbcInfoController.java
 * 包 名 ： tk.ainiyue.danyuan.application.dbm.addr.controller
 * 描 述 ： TODO(用一句话描述该文件做什么)
 * 机能名称：
 * 技能ID ：
 * 作 者 ： wang
 * 时 间 ： 2017年8月3日 下午3:46:35
 * 版 本 ： V1.0
 */
@RestController
@RequestMapping("/sysDbmsTabsJdbcInfo")
public class SysDbmsTabsJdbcInfoController extends BaseControllerImpl<SysDbmsTabsJdbcInfo> implements BaseController<SysDbmsTabsJdbcInfo> {
	
	//
	private static final Logger			logger	= LoggerFactory.getLogger(SysDbmsTabsJdbcInfoController.class);
	
	@Autowired
	private SysDbmsTabsJdbcInfoService	sysDbmsTabsJdbcInfoService;
	
	@GetMapping("/detail/{uuid}")
	public ModelAndView name(@PathVariable("uuid") String uuid) {
		logger.info("detail", SysDbmsTabsJdbcInfoController.class);
		ModelAndView modelAndView = new ModelAndView("dbms/tabs/sysdbmstabsjdbcinfodetail");
		SysDbmsTabsJdbcInfo info = new SysDbmsTabsJdbcInfo();
		info.setUuid(uuid);
		modelAndView.addObject("sysDbmsTabsJdbcInfo", sysDbmsTabsJdbcInfoService.findOne(info));
		return modelAndView;
	}
}
