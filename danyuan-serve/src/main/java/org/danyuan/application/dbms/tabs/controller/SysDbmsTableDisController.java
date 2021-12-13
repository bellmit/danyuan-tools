package org.danyuan.application.dbms.tabs.controller;

import org.danyuan.application.bean.dbms.SysDbmsTableDis;
import org.danyuan.application.common.base.BaseController;
import org.danyuan.application.common.base.BaseControllerImpl;
import org.danyuan.application.dbms.tabs.service.SysDbmsTableDisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @文件名 VSysDbmsTableDisController.java
 * @包名 org.danyuan.application.dbms.tabs.controller
 * @描述 controller层
 * @时间 2019年11月18日 13:19:27
 * @author test
 * @版本 V1.0
 */
@RestController
@RequestMapping("/vSysDbmsTableDis")
public class SysDbmsTableDisController extends BaseControllerImpl<SysDbmsTableDis> implements BaseController<SysDbmsTableDis> {
	
	@Autowired
	SysDbmsTableDisService sysDbmsTableDisService;
	
	@GetMapping("/detail/{uuid}")
	public ModelAndView name(@PathVariable("uuid") String uuid) {
		ModelAndView modelAndView = new ModelAndView("dbms/tabs/vsysdbmstabledisdetail");
		SysDbmsTableDis info = new SysDbmsTableDis();
		info.setUuid(uuid);
		modelAndView.addObject("vSysDbmsTableDis", sysDbmsTableDisService.findOne(info));
		return modelAndView;
	}
	
}
