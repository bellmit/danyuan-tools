package org.danyuan.application.jsontomap.controller;

import java.util.Map;

import org.danyuan.application.common.base.BaseResult;
import org.danyuan.application.common.base.ResultUtil;
import org.danyuan.application.jsontomap.service.ParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 文件名 ： JSONpaser.java
 * 包 名 ： org.danyuan.application.jsontomap.controller
 * 描 述 ： TODO(用一句话描述该文件做什么)
 * 机能名称：
 * 技能ID ：
 * 作 者 ： Administrator
 * 时 间 ： 2021年11月3日 上午10:53:42
 * 版 本 ： V1.0
 */
@RestController
@RequestMapping("/paser")
public class JSONpaser {
	@Autowired
	ParserService parserService;
	
	@RequestMapping(name = "/patent", method = { RequestMethod.POST })
	public BaseResult<String> paserPatent(@RequestBody Map<String, String> map) {
		parserService.paserPatent(map.get("data"));
		return ResultUtil.success();
	}
}
