package org.danyuan.application.tools.dbms.tabs.controller;

import java.util.List;

import org.danyuan.application.tools.dbms.tabs.po.SysDbmsAdviMessInfo;
import org.danyuan.application.tools.dbms.tabs.service.SysDbmsAdviMessInfoService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 文件名 ： Test.java
 * 包 名 ： com.shumeng.application.application.zhcx.controller
 * 描 述 ： TODO(用一句话描述该文件做什么)
 * 机能名称： 技能ID ：
 * 作 者 ： Administrator
 * 时 间 ： 2018年4月24日
 * 下午6:08:33 版 本 ： V1.0
 */
public class SysDbmsAdviMessInfoController {

	@Autowired
	SysDbmsAdviMessInfoService sysDbmsAdviMessInfoService;

	public List<SysDbmsAdviMessInfo> findAll() throws ClassNotFoundException {
		return sysDbmsAdviMessInfoService.findAll(new SysDbmsAdviMessInfo());

	}
}
