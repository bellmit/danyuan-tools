package org.danyuan.application.tools.dbms.tabs.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.danyuan.application.tools.dbms.tabs.po.SysDbmsTabsColsInfo;
import org.danyuan.application.tools.dbms.tabs.po.SysDbmsTabsInfo;
import org.danyuan.application.tools.dbms.tabs.po.SysDbmsTabsTypeInfo;
import org.danyuan.application.tools.dbms.tabs.service.SysDbmsTabsColsInfoService;
import org.danyuan.application.tools.dbms.tabs.service.SysDbmsTabsInfoService;
import org.danyuan.application.tools.dbms.tabs.service.SysDbmsTabsTypeInfoService;
import org.danyuan.application.tools.dbms.tabs.service.SysDbmsUserIndexInfoService;
import org.danyuan.application.tools.dbms.tabs.service.ZhcxService;
import org.danyuan.application.tools.dbms.tabs.vo.SysDbmsTabsColsInfoVo;
import org.danyuan.application.tools.dbms.tabs.vo.SysDbmsTabsInfoVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;

/**
 * 文件名 ： ZhcxController.java 
 * 包 名 ： com.shumeng.application.zhcx.controller 
 * 描 述 ：TODO(用一句话描述该文件做什么) 
 * 机能名称： 
 * 技能ID ： 
 * 作 者 ： Administrator 
 * 时 间 ： 2018年3月9日 上午11:15:38 
 * 版 本 ： V1.0
 */
public class ZhcxController {

	private static final Logger logger = LoggerFactory.getLogger(ZhcxController.class);

	//
	@Autowired
	private SysDbmsTabsTypeInfoService sysDbmsTabsTypeInfoService;

	//
	@Autowired
	private SysDbmsTabsInfoService sysDbmsTabsInfoService;

	//
	@Autowired
	private SysDbmsTabsColsInfoService sysDbmsTabsColsInfoService;
	@Autowired
	SysDbmsUserIndexInfoService sysDbmsUserIndexInfoService;

	@Autowired
	private ZhcxService zhcxService;

	public Map<String, Object> findAllTableRow(SysDbmsTabsColsInfoVo vo) throws JsonParseException, IOException {
		logger.info("findAllTableRow", ZhcxController.class);
		Map<String, Object> map = new HashMap<>();
		System.err.println(vo.toString());
		if ("oracle".equals(vo.getDbType()) || "mysql".equals(vo.getDbType())) {
			// if ("单表多条件查询".equals(vo.getType())) {
			// map = zhcxService.findAllSigleTableByMulteityParam(vo);
			// } else if ("一键查询单表多个不同索引拼接".equals(vo.getType()) ||
			// "单表多条件更多查询".equals(vo.getType())) {
			// 一键查询单表多个不同索引拼接
			map = zhcxService.findBySingleTableByGroupsAndMulteityParam(vo);
			// }
		} else if ("elastic".equals(vo.getDbType())) {
			// // elasticsearch
			// map =
			// zhcxService.findByElasticsearchByGroupsAndMulteityParam(vo);
		}
		return map;
	}

	public List<SysDbmsTabsTypeInfo> findAllType(String username) {
		logger.info("findAllType", ZhcxController.class);
		List<SysDbmsTabsTypeInfo> list = sysDbmsTabsTypeInfoService.findAll();
		return list;
	}

	public List<SysDbmsTabsInfo> findAllTable(SysDbmsTabsInfoVo vo) {
		logger.info("findAllTable", ZhcxController.class);
		List<SysDbmsTabsInfo> list = sysDbmsTabsInfoService.findAllTable(vo);
		if (list != null) {
			return list;
		} else {
			return new ArrayList<>();
		}
	}

	public List<SysDbmsTabsInfo> findAllTableByTypeUuid(SysDbmsTabsInfoVo vo) {
		logger.info("findAllTableByTypeUuid", ZhcxController.class);
		List<SysDbmsTabsInfo> list = new ArrayList<>();
		if (vo.getInfo() != null) {
			list = sysDbmsTabsInfoService.findAll(vo.getInfo());
		}
		return list;
	}

	public List<SysDbmsTabsColsInfo> findAllColumn(SysDbmsTabsColsInfoVo vo) {
		logger.info("findAllColumn", ZhcxController.class);
		List<SysDbmsTabsColsInfo> list = sysDbmsTabsColsInfoService.findAll(vo.getInfo());
		return list;
	}

}
