package org.danyuan.application.dbms.tabs.service;

import java.util.List;

import org.danyuan.application.bean.dbms.SysDbmsTabsInfo;
import org.danyuan.application.common.base.BaseResult;
import org.danyuan.application.common.base.BaseService;
import org.danyuan.application.common.base.BaseServiceImpl;
import org.danyuan.application.common.base.Pagination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 文件名 ： SysTableServiceImpl.java
 * 包 名 ： tk.ainiyue.danyuan.application.dbm.table.service.impl
 * 描 述 ： TODO(用一句话描述该文件做什么)
 * 机能名称：
 * 技能ID ：
 * 作 者 ： wang
 * 时 间 ： 2017年8月3日 下午3:55:43
 * 版 本 ： V1.0
 */
@Service("sysDbmsTabsInfoService")
public class SysDbmsTabsInfoService extends BaseServiceImpl<SysDbmsTabsInfo> implements BaseService<SysDbmsTabsInfo> {

	//
	private static final Logger	logger	= LoggerFactory.getLogger(SysDbmsTabsInfoService.class);

	@Autowired
	private RestTemplate		restTemplate;

	/**
	 * 方法名： findAllByTableUuid
	 * 功 能： TODO(这里用一句话描述这个方法的作用)
	 * 参 数： @param vo
	 * 参 数： @return
	 * 返 回： Page<SysDbmsTabsInfo>
	 * 作 者 ： Administrator
	 * @throws
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public BaseResult<Page<SysDbmsTabsInfo>> findAllByTableUuid(Pagination<SysDbmsTabsInfo> vo) {
		logger.info("微服务访问{}开始。", vo.getInfo().getJdbcUuid());
		List<SysDbmsTabsInfo> list = findAll(vo.getInfo());
		vo.setList(list);
		ResponseEntity<BaseResult> result = restTemplate.postForEntity("http://" + vo.getInfo().getJdbcUuid() + "/data/sysDbmsTabsInfo/findAllByTableUuid", vo, BaseResult.class);
		if (result.getStatusCode().value() == 200) {
			System.out.println(result.getBody());
			return result.getBody();
		} else {
			logger.error("微服务访问失败：{}异常。", vo.getInfo().getJdbcUuid());
			return null;
		}

	}

}
