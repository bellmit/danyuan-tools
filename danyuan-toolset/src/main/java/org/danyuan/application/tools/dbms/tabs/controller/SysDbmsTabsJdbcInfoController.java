package org.danyuan.application.tools.dbms.tabs.controller;

import org.danyuan.application.tools.common.base.BaseController;
import org.danyuan.application.tools.common.base.BaseControllerImpl;
import org.danyuan.application.tools.dbms.tabs.po.SysDbmsTabsJdbcInfo;
import org.danyuan.application.tools.dbms.tabs.service.SysDbmsTabsJdbcInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 文件名 ： SysDbmsTabsJdbcInfoController.java
 * 包 名 ：tk.ainiyue.danyuan.application.dbm.addr.controller
 * 描 述 ： TODO(用一句话描述该文件做什么)
 * 机能名称：
 * 技能ID ：
 * 作 者 ： wang
 * 时 间 ： 2017年8月3日 下午3:46:35
 * 版 本 ： V1.0
 */
public class SysDbmsTabsJdbcInfoController extends BaseControllerImpl<SysDbmsTabsJdbcInfo> implements BaseController<SysDbmsTabsJdbcInfo> {
	//
	private static final Logger logger = LoggerFactory.getLogger(SysDbmsTabsJdbcInfoController.class);

	@Autowired
	private SysDbmsTabsJdbcInfoService sysDbmsTabsJdbcInfoService;


}
