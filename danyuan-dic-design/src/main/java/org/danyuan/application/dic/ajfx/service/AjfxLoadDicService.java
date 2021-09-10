package org.danyuan.application.dic.ajfx.service;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.danyuan.application.TxtFilesReader;
import org.danyuan.application.dic.ajfx.po.Ajlx;
import org.danyuan.application.dic.ajfx.po.Ay;
import org.danyuan.application.dic.dao.SysDicCatalogDao;
import org.danyuan.application.dic.dao.SysDicNameInfoDao;
import org.danyuan.application.dic.po.SysDicCatalog;
import org.danyuan.application.dic.po.SysDicNameInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.alibaba.fastjson.JSONArray;

import lombok.extern.slf4j.Slf4j;

/**
 * 文件名 ： AjfxLoadDicService.java
 * 包 名 ： org.danyuan.application.dic.ajfx.service
 * 描 述 ： TODO(用一句话描述该文件做什么)
 * 机能名称：
 * 技能ID ：
 * 作 者 ： Administrator
 * 时 间 ： 2021年9月9日 下午3:33:48
 * 版 本 ： V1.0
 */
@Service
@Slf4j
public class AjfxLoadDicService {
	
	public static String	GBK	= "GBK";
	public static String	U8	= "UTF-8";
	
	/**
	 * @throws FileNotFoundException
	 * 方法名： loadDics
	 * 功 能： TODO(这里用一句话描述这个方法的作用)
	 * 参 数：
	 * 返 回： void
	 * 作 者 ： Administrator
	 * @throws
	 */
	public void loadDics() throws FileNotFoundException {
		// ajlx
		log.info("案件类型 开始。。。");
		JSONArray ajlxArray = readJsonObject(AjfxFilePath.ajlx, GBK);
		saveAjlx("ajlx", "案件类型", ajlxArray);
		log.info("案件类型 结束。。。");
		// aldj
		log.info("案例等级 开始。。。");
		JSONArray aldjArray = readJsonObject(AjfxFilePath.aldj, GBK);
		saveAjlx("aldj", "案例等级", aldjArray);
		log.info("案例等级 结束。。。");
		// areas
		log.info("地区 开始。。。");
		JSONArray areasArray = readJsonObject(AjfxFilePath.areas, GBK);
		saveAjlx("areas", "地区", areasArray);
		log.info("地区 结束。。。");
		// ay
		log.info("案由 开始。。。");
		JSONArray ayArray = readJsonObject(AjfxFilePath.ay, U8);
		saveay("ay", "案由", ayArray);
		log.info("案由 结束。。。");
		// bgkly
		log.info("不公开类型 开始。。。");
		JSONArray bgklyArray = readJsonObject(AjfxFilePath.bgkly, GBK);
		saveAjlx("bgkly", "不公开类型", bgklyArray);
		log.info("不公开类型 结束。。。");
		/** 法院层级 */
		// fycj
		log.info("法院层级 开始。。。");
		JSONArray fycjArray = readJsonObject(AjfxFilePath.fycj, GBK);
		saveAjlx("fycj", "法院层级", fycjArray);
		log.info("法院层级 结束。。。");
		/** 结案方式 */
		// ja
		log.info("结案方式 开始。。。");
		JSONArray jaArray = readJsonObject(AjfxFilePath.fycj, GBK);
		saveAjlx("ja", "结案方式", jaArray);
		log.info("结案方式 结束。。。");
		/** 文书文档标记类型 */
		// qw
		log.info("文书文档标记类型 开始。。。");
		JSONArray qwArray = readJsonObject(AjfxFilePath.qw, GBK);
		saveAjlx("qw", "文书文档标记类型", qwArray);
		log.info("文书文档标记类型 结束。。。");
		/** 审判程序 */
		// spcx
		log.info("审判程序 开始。。。");
		JSONArray spcxArray = readJsonObject(AjfxFilePath.spcx, U8);
		saveay("spcx", "审判程序", spcxArray);
		log.info("审判程序 结束。。。");
		/** 文书类型 */
		// wslx
		log.info("文书类型 开始。。。");
		JSONArray wslxArray = readJsonObject(AjfxFilePath.wslx, GBK);
		saveAjlx("wslx", "文书类型", wslxArray);
		log.info("文书类型 结束。。。");
		/** 公开类型 */
		log.info("公开类型 开始。。。");
		JSONArray gklxArray = readJsonObject(AjfxFilePath.gklx, GBK);
		saveAjlx("gklx", "公开类型", gklxArray);
		log.info("公开类型 结束。。。");
	}
	
	/**
	 * 方法名： saveay
	 * 功 能： TODO(这里用一句话描述这个方法的作用)
	 * 参 数： @param string
	 * 参 数： @param string2
	 * 参 数： @param ayArray
	 * 返 回： void
	 * 作 者 ： Administrator
	 * @throws
	 */
	private void saveay(String code, String name, JSONArray ayArray) {
		List<Ay> l = ayArray.toJavaList(Ay.class);
		List<SysDicCatalog> catlist = new ArrayList<>();
		for (Ay ajfx : l) {
			SysDicCatalog log = new SysDicCatalog();
			log.setCatalog(ajfx.getText());
			log.setCode(ajfx.getId());
			log.setParent(ajfx.getParent());
			catlist.add(log);
		}
		save(code, name, catlist);
	}
	
	@Autowired
	SysDicNameInfoDao	sysDicNameInfoDao;
	
	@Autowired
	SysDicCatalogDao	sysDicCatalogDao;
	
	/**
	 * 方法名： saveAjlx
	 * 功 能： 案件类型信息保存
	 * 参 数： @param ajlxArray
	 * 返 回： void
	 * 作 者 ： Administrator
	 * @throws
	 */
	private void saveAjlx(String code, String name, JSONArray ajlxArray) {
		List<Ajlx> l = ajlxArray.toJavaList(Ajlx.class);
		List<SysDicCatalog> catlist = new ArrayList<>();
		for (Ajlx ajfx : l) {
			SysDicCatalog log = new SysDicCatalog();
			log.setCatalog(ajfx.getName());
			log.setCode(ajfx.getCode());
			catlist.add(log);
		}
		save(code, name, catlist);
	}
	
	/**
	 * 方法名： save
	 * 功 能： TODO(这里用一句话描述这个方法的作用)
	 * 参 数： @param code
	 * 参 数： @param name
	 * 参 数： @param catlist
	 * 返 回： void
	 * 作 者 ： Administrator
	 * @throws
	 */
	private void save(String code, String name, List<SysDicCatalog> catlist) {
		
		SysDicNameInfo dic = new SysDicNameInfo();
		dic.setCode(code);
		dic.setName(name);
		Optional<SysDicNameInfo> n = sysDicNameInfoDao.findOne(Example.of(dic));
		if (n.isPresent()) {
			dic = n.get();
			dic.setLabel("案件分析");
		} else {
			dic.setUuid(radomUuid());
			dic.setCreateUser("system");
			dic.setDeleteFlag(0);
			dic.setLabel("案件分析");
			sysDicNameInfoDao.save(dic);
		}
		SysDicCatalog log = new SysDicCatalog();
		log.setNameId(dic.getUuid());
		sysDicCatalogDao.deleteAll(sysDicCatalogDao.findAll(Example.of(log)));
		int sort = 1;
		for (SysDicCatalog sysDicCatalog : catlist) {
			sysDicCatalog.setUuid(radomUuid());
			sysDicCatalog.setNameId(dic.getUuid());
			sysDicCatalog.setCreateUser("system");
			sysDicCatalog.setDeleteFlag(0);
			sysDicCatalog.setSort(sort++);
		}
		sysDicCatalogDao.saveAllAndFlush(catlist);
	}
	
	/**
	 * 方法名： radomUuid
	 * 功 能： TODO(这里用一句话描述这个方法的作用)
	 * 参 数： @return
	 * 返 回： String
	 * 作 者 ： Administrator
	 * @throws
	 */
	private String radomUuid() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	/**
	 * @throws FileNotFoundException
	 * 方法名： readJsonObject
	 * 功 能： 读取文件转换成json数据
	 * 参 数： @param ajlx
	 * 参 数： @return
	 * 返 回： JSONObject
	 * 作 者 ： Administrator
	 * @throws
	 */
	private JSONArray readJsonObject(String path, String encoding) throws FileNotFoundException {
		String str = TxtFilesReader.readToString(ResourceUtils.getFile(path), encoding);
		JSONArray arr = (JSONArray) JSONArray.parse(str);
		return arr;
	}
	
}
