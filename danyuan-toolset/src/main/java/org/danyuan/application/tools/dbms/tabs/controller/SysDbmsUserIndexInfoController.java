package org.danyuan.application.tools.dbms.tabs.controller;

import java.util.List;

import org.danyuan.application.tools.dbms.tabs.po.SysDbmsUserIndexInfo;
import org.danyuan.application.tools.dbms.tabs.service.SysDbmsUserIndexInfoService;
import org.danyuan.application.tools.dbms.tabs.vo.SysDbmsUserIndexInfoVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

/**
 * 文件名 ： SysDbmsUserIndexInfoController.java 
 * 包 名 ：com.shumeng.application.zhcx.controller 
 * 描 述 ： TODO(用一句话描述该文件做什么) 
 * 机能名称： 
 * 技能ID ：
 * 作 者 ： Administrator 
 * 时 间 ： 2018年3月8日 下午1:40:42 
 * 版 本 ： V1.0
 */

public class SysDbmsUserIndexInfoController {
	//
	private static final Logger logger = LoggerFactory.getLogger(SysDbmsUserIndexInfoController.class);

	@Autowired
	SysDbmsUserIndexInfoService sysDbmsUserIndexInfoService;

	public List<SysDbmsUserIndexInfo> findAll() {
		logger.info("findAll", SysDbmsUserIndexInfoController.class);
		return sysDbmsUserIndexInfoService.findAll();

	}

	public Page<SysDbmsUserIndexInfo> page(SysDbmsUserIndexInfoVo vo) {
		logger.info("page", SysDbmsUserIndexInfoController.class);
		return sysDbmsUserIndexInfoService.page(vo);
	}

	public String save(SysDbmsUserIndexInfo info) {
		logger.info("save", SysDbmsUserIndexInfoController.class);
		sysDbmsUserIndexInfoService.save(info);
		return "1";
	}

	public String delete(SysDbmsUserIndexInfoVo vo) {
		logger.info("delete", SysDbmsUserIndexInfoController.class);
		sysDbmsUserIndexInfoService.delete(vo.getList());
		return "1";
	}

	public List<SysDbmsUserIndexInfo> chartList() {
		logger.info("findAll", SysDbmsUserIndexInfoController.class);
		return sysDbmsUserIndexInfoService.chartList();

	}
}
