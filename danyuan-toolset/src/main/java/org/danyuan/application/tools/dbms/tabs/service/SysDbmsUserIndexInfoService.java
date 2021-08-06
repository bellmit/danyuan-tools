package org.danyuan.application.tools.dbms.tabs.service;

import java.util.List;

import org.danyuan.application.tools.dbms.tabs.dao.SysDbmsUserIndexInfoDao;
import org.danyuan.application.tools.dbms.tabs.po.SysDbmsUserIndexInfo;
import org.danyuan.application.tools.dbms.tabs.vo.SysDbmsUserIndexInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

/**
 * 文件名 ： SysDicUserIndexCode.java
 * 包 名 ： com.shumeng.application.zhcx.service
 * 描 述： TODO(用一句话描述该文件做什么)
 * 机能名称：
 * 技能ID ：
 * 作 者 ： Administrator
 * 时 间 ： 2018年3月8日 下午1:49:27
 * 版 本 ： V1.0
 */
@Service
public class SysDbmsUserIndexInfoService {
	@Autowired
	private SysDbmsUserIndexInfoDao sysDbmsUserIndexInfoDao;

	/**
	 * 方法名： findAll
	 * 功 能： TODO(这里用一句话描述这个方法的作用)
	 * 参 数： 返 回 :
	 * 返 回： {@code List<SysDicUserIndexCode>}
	 * 作 者 ： Administrator
	 *
	 */
	public List<SysDbmsUserIndexInfo> findAll() {
		return sysDbmsUserIndexInfoDao.findAllByDeleteFlag();
	}

	/**
	 * 方法名： page
	 * 功 能： TODO(这里用一句话描述这个方法的作用)
	 * 参 数： pageNumber
	 * 参 数： pageSize
	 * 参 数： col
	 * 参 数：
	 * 返 回： {@code Page<SysZhcxCol>}
	 * 作 者 ：Administrator
	 *
	 */
	public Page<SysDbmsUserIndexInfo> page(SysDbmsUserIndexInfoVo vo) {
		Example<SysDbmsUserIndexInfo> example = Example.of(vo.getInfo());
		Sort sort = Sort.by(new Order(Direction.ASC, "userOrder"), new Order(Direction.DESC, "createTime"));
		if (vo.getSortName() != null && !"".equals(vo.getSortName())) {
			if (vo.getSortOrder().equals("asc")) {
				sort = Sort.by(new Order(Direction.ASC, vo.getSortName()));
			} else {
				sort = Sort.by(new Order(Direction.DESC, vo.getSortName()));
			}
		}
		PageRequest request = PageRequest.of(vo.getPageNumber() - 1, vo.getPageSize(), sort);
		Page<SysDbmsUserIndexInfo> sourceCodes = sysDbmsUserIndexInfoDao.findAll(example, request);
		return sourceCodes;
	}

	/**
	 * 方法名： save
	 * 功 能： TODO(这里用一句话描述这个方法的作用)
	 * 参 数： info
	 * 返 回： void
	 * 作 者 ：Administrator
	 *
	 */
	public void save(SysDbmsUserIndexInfo info) {
		sysDbmsUserIndexInfoDao.save(info);
	}

	/**
	 * 方法名： delete
	 * 功 能： TODO(这里用一句话描述这个方法的作用)
	 * 参 数： list
	 * 返 回： void
	 * 作 者 ：Administrator
	 *
	 */
	public void delete(List<SysDbmsUserIndexInfo> list) {
		sysDbmsUserIndexInfoDao.deleteAll(list);
	}

	/**
	 * 方法名： chartList
	 * 功 能： TODO(这里用一句话描述这个方法的作用)
	 * 参 数： 返 回 :
	 * 返 回：{@code List<SysDicUserIndexCode>}
	 * 作 者 ： Administrator
	 *
	 */
	public List<SysDbmsUserIndexInfo> chartList() {
		return sysDbmsUserIndexInfoDao.findAllByChart();
	}
}
