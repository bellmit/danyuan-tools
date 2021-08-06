package org.danyuan.application.tools.dic.controller;

import java.util.List;
import java.util.UUID;

import org.danyuan.application.tools.common.base.Pagination;
import org.danyuan.application.tools.dic.po.SysDicKeyList;
import org.danyuan.application.tools.dic.service.SysDicKeyListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

/**
 * 文件名 ： SysDicKeyListController.java
 * 包 名 ： com.shumeng.application.softm.dic.controller
 * 描 述 ： TODO(用一句话描述该文件做什么)
 * 机能名称：
 * 技能ID ：
 * 作 者 ： Administrator
 * 时 间 ： 2018年5月16日 上午9:40:18
 * 版 本 ： V1.0
 */
public class SysDicKeyListController {

	//
	private static final Logger		logger	= LoggerFactory.getLogger(SysDicKeyListController.class);
	//
	@Autowired
	private SysDicKeyListService	sysDicKeyListService;

	/**
	 * 方法名 ： page
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @param vo
	 * 参 数 ： @return
	 * 作 者 ： Administrator
	 */
	public Page<SysDicKeyList> page( Pagination<SysDicKeyList> vo) {
		logger.info("page", SysDicKeyListController.class);
		return sysDicKeyListService.page(vo);
	}

	/**
	 * 方法名 ： findAll
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @param info
	 * 参 数 ： @return
	 * 作 者 ： Administrator
	 */
	public List<SysDicKeyList> findAll( SysDicKeyList info) {
		logger.info("findAll", SysDicKeyListController.class);
		return sysDicKeyListService.findAll(info);
	}

	/**
	 * 方法名 ： findOne
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @param info
	 * 参 数 ： @return
	 * 作 者 ： Administrator
	 */
	public SysDicKeyList findOne(SysDicKeyList info) {
		logger.info("findOne", SysDicKeyListController.class);
		return sysDicKeyListService.findOne(info);
	}

	/**
	 * 方法名 ： save
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @param info
	 * 参 数 ： @return
	 * 作 者 ： Administrator
	 */
	public String save( SysDicKeyList info) {
		logger.info("save", SysDicKeyListController.class);
		if (info.getUuid() == null || "".equals(info.getUuid())) {
			info.setUuid(UUID.randomUUID().toString());
		}
		sysDicKeyListService.save(info);
		return "1";
	}

	/**
	 * 方法名 ： save
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @param vo
	 * 参 数 ： @return
	 * 作 者 ： Administrator
	 */
	public String save(Pagination<SysDicKeyList> vo) {
		logger.info("save", SysDicKeyListController.class);
		sysDicKeyListService.saveAll(vo.getList());
		return "1";
	}

	/**
	 * 方法名 ： delete
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @param vo
	 * 参 数 ： @return
	 * 作 者 ： Administrator
	 */
	public String delete( Pagination<SysDicKeyList> vo) {
		logger.info("delete", SysDicKeyListController.class);
		sysDicKeyListService.deleteAll(vo.getList());
		return "1";
	}

	/**
	 * 方法名 ： delete
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @param info
	 * 参 数 ： @return
	 * 作 者 ： Administrator
	 */
	public String delete(SysDicKeyList info) {
		logger.info("delete", SysDicKeyListController.class);
		sysDicKeyListService.delete(info);
		return "1";
	}

	/**
	 * 方法名 ： trunc
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @return
	 * 作 者 ： Administrator
	 */
	public String trunc() {
		logger.info("delete", SysDicKeyListController.class);
		sysDicKeyListService.trunc();
		return "1";
	}

}
