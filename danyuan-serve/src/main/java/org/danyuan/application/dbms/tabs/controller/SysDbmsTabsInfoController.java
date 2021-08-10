package org.danyuan.application.dbms.tabs.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.danyuan.application.bean.manager.dbms.SysDbmsTabsInfo;
import org.danyuan.application.dbms.tabs.service.SysDbmsTabsInfoService;
import org.danyuan.application.dbms.tabs.vo.SysDbmsTabsInfoVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
public class SysDbmsTabsInfoController {
	//
	private static final Logger		logger	= LoggerFactory.getLogger(SysDbmsTabsInfoController.class);
	
	//
	@Autowired
	private SysDbmsTabsInfoService	sysDbmsTabsInfoService;
	
	/**
	 * 方法名： findAll
	 * 功 能： TODO(这里用一句话描述这个方法的作用)
	 * 参 数： @return
	 * 返 回： List<SysSeedInfo>
	 * 作 者 ： Tenghui.Wang
	 * @throws
	 */
	@RequestMapping(path = "/page", method = { RequestMethod.GET, RequestMethod.POST })
	public Page<SysDbmsTabsInfo> page(@RequestBody SysDbmsTabsInfoVo vo) {
		logger.info("page", SysDbmsTabsInfoController.class);
		return sysDbmsTabsInfoService.page(vo);
	}
	
	/**
	 * 方法名： findAll
	 * 功 能： TODO(这里用一句话描述这个方法的作用)
	 * 参 数： @return
	 * 返 回： List<SysSeedInfo>
	 * 作 者 ： Tenghui.Wang
	 * @throws
	 */
	@RequestMapping(path = "/findAll", method = { RequestMethod.GET, RequestMethod.POST })
	public List<SysDbmsTabsInfo> findAll() {
		logger.info("findAll", SysDbmsTabsInfoController.class);
		
		return sysDbmsTabsInfoService.findAll();
	}
	
	@RequestMapping(path = "/findAllBySysTableInfo", method = RequestMethod.POST)
	public List<SysDbmsTabsInfo> findAllBySysTableInfo(@RequestBody SysDbmsTabsInfo sysDbmsTabsInfo) {
		logger.info("findAll", SysDbmsTabsInfoController.class);
		return sysDbmsTabsInfoService.findAll(sysDbmsTabsInfo);
	}
	
	@RequestMapping(path = "/findAllBySysTableInfoAndUsername", method = RequestMethod.POST)
	public List<SysDbmsTabsInfo> findAllBySysTableInfoAndUsername(@RequestBody SysDbmsTabsInfo sysDbmsTabsInfo) {
		logger.info("findAll", SysDbmsTabsInfoController.class);
		return sysDbmsTabsInfoService.findAllBySysTableInfoAndUsername(sysDbmsTabsInfo);
	}
	
	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public String save(@RequestBody SysDbmsTabsInfo sysDbmsTabsInfo) {
		logger.info("save", SysDbmsTabsInfoController.class);
		if (sysDbmsTabsInfo.getUuid() == null || "".equals(sysDbmsTabsInfo.getUuid())) {
			sysDbmsTabsInfo.setUuid(UUID.randomUUID().toString());
		}
		sysDbmsTabsInfoService.save(sysDbmsTabsInfo);
		return "1";
	}
	
	@RequestMapping(path = "/change", method = RequestMethod.POST)
	public SysDbmsTabsInfo change(@RequestBody SysDbmsTabsInfoVo vo) {
		logger.info("save", SysDbmsTabsInfoController.class);
		sysDbmsTabsInfoService.change(vo);
		return vo.getNow();
	}
	
	@RequestMapping(path = "/drop", method = RequestMethod.POST)
	public String drop(@RequestBody SysDbmsTabsInfoVo vo) {
		logger.info("drop", SysDbmsTabsInfoController.class);
		sysDbmsTabsInfoService.drop(vo.getList());
		return "1";
	}
	
	@RequestMapping(path = "/delete", method = RequestMethod.POST)
	public String delete(@RequestBody SysDbmsTabsInfoVo vo) {
		logger.info("delete", SysDbmsTabsInfoController.class);
		sysDbmsTabsInfoService.deleteAll(vo.getList());
		return "1";
	}
	
	@RequestMapping(path = "/updateSysTableInfo", method = RequestMethod.POST)
	public String updateSysTableInfo(@RequestBody SysDbmsTabsInfoVo vo) {
		logger.info("updateSysTableInfo", SysDbmsTabsInfoController.class);
		sysDbmsTabsInfoService.saveAll(vo.getList());
		return "1";
	}
	
	@RequestMapping(path = "/updBefor", method = RequestMethod.GET)
	public ModelAndView updBefor(HttpServletRequest request) {
		logger.info("updBefor", SysDbmsTabsInfoController.class);
		ModelAndView view = new ModelAndView("dbms/table/index_column");
		SysDbmsTabsInfo info = new SysDbmsTabsInfo();
		info.setUuid(request.getParameter("uuid"));
		info = sysDbmsTabsInfoService.findOne(info);
		view.addObject("sysTableInfo", info);
		return view;
	}
	
	@RequestMapping(path = "/updBeforEdit", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView updBeforEdit(HttpServletRequest request) {
		logger.info("updBeforEdit", SysDbmsTabsInfoController.class);
		ModelAndView view = new ModelAndView("dbms/table/upd_table");
		SysDbmsTabsInfo info = new SysDbmsTabsInfo();
		if (request.getParameter("uuid") != null || !"".equals(request.getParameter("uuid"))) {
			info.setUuid(request.getParameter("uuid"));
			info = sysDbmsTabsInfoService.findOne(info);
		}
		view.addObject("sysTableInfo", info);
		return view;
	}
	
}
