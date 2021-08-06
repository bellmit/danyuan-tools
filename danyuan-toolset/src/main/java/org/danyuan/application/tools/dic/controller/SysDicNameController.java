package org.danyuan.application.tools.dic.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.danyuan.application.tools.common.base.BaseController;
import org.danyuan.application.tools.common.base.BaseControllerImpl;
import org.danyuan.application.tools.common.base.Pagination;
import org.danyuan.application.tools.dic.po.SysDicKeyList;
import org.danyuan.application.tools.dic.po.SysDicName;
import org.danyuan.application.tools.dic.service.SysDicNameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import de.felixroske.jfxsupport.FXMLController;

/**
 * 文件名 ： SysDicNameController.java
 * 包 名 ： com.shumeng.application.softm.dic.controller
 * 描 述 ： TODO(用一句话描述该文件做什么)
 * 机能名称：
 * 技能ID ：
 * 作 者 ： Administrator
 * 时 间 ： 2018年5月16日 上午9:35:38
 * 版 本 ： V1.0
 */
@FXMLController
public class SysDicNameController extends BaseControllerImpl<SysDicName> implements BaseController<SysDicName>{
	//
	private static final Logger	logger	= LoggerFactory.getLogger(SysDicNameController.class);
	//
	@Autowired
	private SysDicNameService	sysDicNameService;


	/**
	 * 方法名 ： save
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @param vo
	 * 参 数 ： @return
	 * 作 者 ： Administrator
	 */
	public String save(Pagination<SysDicName> vo) {
		logger.info("save", SysDicNameController.class);
		sysDicNameService.saveAll(vo.getList());
		return "1";
	}

	/**
	 * 方法名 ： delete
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @param vo
	 * 参 数 ： @return
	 * 作 者 ： Administrator
	 */
	public String delete( Pagination<SysDicName> vo) {
		logger.info("delete", SysDicNameController.class);
		sysDicNameService.deleteAll(vo.getList());
		return "1";
	}


	public Map<String, Boolean> checkCode(String code) {
		logger.info("checkCode", SysDicNameController.class);
		boolean boo = sysDicNameService.checkCode(code);
		Map<String, Boolean> map = new HashMap<>();
		map.put("valid", boo);
		return map;
	}

	public List<SysDicKeyList> findkeyList( SysDicName info) {
		logger.info("findkeyList", SysDicNameController.class);
		List<SysDicKeyList> list = sysDicNameService.findkeyList(info);
		return list;
	}

}
