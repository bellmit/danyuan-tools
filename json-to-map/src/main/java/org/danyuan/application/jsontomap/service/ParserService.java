package org.danyuan.application.jsontomap.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.danyuan.application.jsontomap.dao.SysCompanyPatentDao;
import org.danyuan.application.jsontomap.po.SysCompanyPatent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

/**
 * 文件名 ： ParserService.java
 * 包 名 ： org.danyuan.application.jsontomap.service
 * 描 述 ： TODO(用一句话描述该文件做什么)
 * 机能名称：
 * 技能ID ：
 * 作 者 ： Administrator
 * 时 间 ： 2021年11月3日 上午11:25:44
 * 版 本 ： V1.0
 */
@Service
public class ParserService {
	
	@Autowired
	SysCompanyPatentDao sysCompanyPatentDao;
	
	/**
	 * 方法名： paserPatent
	 * 功 能： TODO(这里用一句话描述这个方法的作用)
	 * 参 数：
	 * 返 回： void
	 * 作 者 ： Administrator
	 * @throws
	 */
	public void paserPatent(String jsonStr) {
		String str = "APO,APD,PN,PD,TIVIEW,ICST,INVIEW,PR,PRD,ABVIEW,AGT,ABSIMG,VID,ID,TIVIEW,AP,APD,PN,APSN,PNSN,PAVIEW,AC,AA,AZ,DBCODE,LANG,DOC_TYPE,DOC_STATUS,IC,FNUM,PNUM,CPNUM,OWNER_STATUS";
		String[] columns = str.split(",");
		System.out.println(columns.length);
		System.out.println(columns);
		// System.out.println(jsonStr);
		Map<String, Object> obj = JSON.parseObject(jsonStr, Map.class);
		System.out.println(((Map) obj.get("searchCondition")).get("tableItemList"));
		List<Map<String, Object>> tableItemList = (List) ((Map) obj.get("searchCondition")).get("tableItemList");
		
		for (Map<String, Object> map : tableItemList) {
			String key = (String) map.get("indexENName");
			String common = (String) map.get("indexCNName");
			System.out.println(String.format("%s : %s", key, common));
			// data.add(map);
		}
		
		List<Map> searchResultRecord = (List) ((Map) obj.get("searchResultDTO")).get("searchResultRecord");
		
		record(searchResultRecord);
	}
	
	public void record(List<Map> searchResultRecord) {
		List<Map<String, String>> data = new ArrayList<>();
		for (Map<String, Object> map : searchResultRecord) {
			Map<String, String> fieldMap = (Map<String, String>) map.get("fieldMap");
			// TODO 其他数据的可能添加 recordList
			List<Map<String, Object>> recordList = (List) map.get("recordList");
			for (Map<String, Object> map2 : recordList) {
				String key = (String) map2.get("indexCode");
				String indexCNName = (String) map2.get("indexCNName");
				String indexENName = (String) map2.get("indexENName");
				String val = (String) map2.get("itemValue");
				if (StringUtils.isNotEmpty(val)) {
					// System.out.println(String.format("%s : %s, %s : %s", key, val, indexENName, indexCNName));
					fieldMap.put(key, val);
				}
			}
			List<Map<String, Object>> textList = (List) map.get("textList");
			for (Map<String, Object> map2 : textList) {
				String key = (String) map2.get("indexCode");
				String indexCNName = (String) map2.get("indexCNName");
				String indexENName = (String) map2.get("indexENName");
				String val = (String) map2.get("itemValue");
				if (StringUtils.isNotEmpty(val)) {
					// System.out.println(String.format("%s : %s, %s : %s", key, val, indexENName, indexCNName));
					fieldMap.put(key, val);
				}
			}
			
			data.add(fieldMap);
		}
		insertData(data);
		
	}
	
	/**
	 * 方法名： insertData
	 * 功 能： TODO(这里用一句话描述这个方法的作用)
	 * 参 数： @param data
	 * 返 回： void
	 * 作 者 ： Administrator
	 * @throws
	 */
	private void insertData(List<Map<String, String>> data) {
		List<SysCompanyPatent> list = new ArrayList<>();
		for (Map<String, String> map : data) {
			SysCompanyPatent patent = new SysCompanyPatent();
			patent.set_id(map.get("ID"));
			Optional<SysCompanyPatent> ot = sysCompanyPatentDao.findOne(Example.of(patent));
			if (ot.isPresent()) {
				patent = ot.get();
			}
			patent.set_id(map.get("ID"));
			patent.setAa(map.get("AA"));
			patent.setAc(map.get("AC"));
			patent.setAgt(map.get("AGT"));
			patent.setAp(map.get("AP"));
			patent.setApd(map.get("APD"));
			patent.setApo(map.get("APO"));
			patent.setApsn(map.get("APSN"));
			patent.setAz(map.get("AZ"));
			patent.setDataFrom("专利检索及分析系统");
			patent.setDbcode(map.get("DBCODE"));
			patent.setDocStatus(map.get("DOC_STATUS"));
			patent.setDocType(map.get("DOC_TYPE"));
			patent.setFnum(map.get("FNUM"));
			patent.setIc(map.get("IC"));
			patent.setIcst(map.get("ICST"));
			patent.setInview(map.get("INVIEW"));
			patent.setLang(map.get("LANG"));
			patent.setPaview(map.get("PAVIEW"));
			patent.setPd(map.get("PD"));
			patent.setPn(map.get("PN"));
			patent.setPnsn(map.get("PNSN"));
			patent.setPnum(map.get("PNUM"));
			patent.setPr(map.get("PR"));
			patent.setPrd(map.get("PRD"));
			patent.setTiview(map.get("TIVIEW"));
			patent.setVid(map.get("VID"));
			patent.setAbsimg(map.get("ABSIMG"));
			patent.setAbview(map.get("ABVIEW"));
			patent.setCpnum(map.get("CPNUM"));
			patent.setOwnerStatus(map.get("OWNER_STATUS"));
			patent.setPrsc3Value(map.get("PRSC3_VALUE"));
			
			list.add(patent);
		}
		sysCompanyPatentDao.saveAll(list);
	}
	
	/**
	 * 方法名： paserPatentListStr
	 * 功 能： TODO(这里用一句话描述这个方法的作用)
	 * 参 数： @param string
	 * 返 回： void
	 * 作 者 ： Administrator
	 * @throws
	 */
	public void paserPatentListStr(String string) {
		List<Map> obj = JSON.parseArray(string, Map.class);
		
		record(obj);
	}
	
}
