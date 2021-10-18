package org.danyuan.application.common.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanComparator;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

/**
 * 文件名 ： Pagination.java
 * 包 名 ： tk.ainiyue.danyuan.application.common.base
 * 描 述 ： 通用逻辑分页，参数传递类
 * 作 者 ： wang
 * 时 间 ： 2018年3月1日 下午10:19:40
 * 版 本 ： V1.0
 */
public class Pagination<T> {

	public Integer				pageNumber;
	public Integer				pageSize;
	public String				uuid;
	public String				username;
	List<T>						list;
	List<SearchParameters>		searchList;
	List<SortParameters>		sortList;
	public T					info;
	public Map<String, String>	map	= new HashMap<>();

	/**
	 * 方法名 ： getInfo
	 * 功 能 ： 返回变量 info 的值
	 * @return: T
	 */
	public T getInfo() {
		return info;
	}

	/**
	 * 方法名 ： setInfo
	 * 功 能 ： 设置变量 info 的值
	 */
	public void setInfo(T info) {
		this.info = info;
	}

	/**
	 * 方法名 ： getPageNumber
	 * 功 能 ： 返回变量 pageNumber 的值
	 * @return: Integer
	 */
	public Integer getPageNumber() {
		return pageNumber;
	}

	/**
	 * 方法名 ： setPageNumber
	 * 功 能 ： 设置变量 pageNumber 的值
	 */
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	/**
	 * 方法名 ： getPageSize
	 * 功 能 ： 返回变量 pageSize 的值
	 * @return: Integer
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * 方法名 ： setPageSize
	 * 功 能 ： 设置变量 pageSize 的值
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 方法名 ： getUuid
	 * 功 能 ： 返回变量 uuid 的值
	 * @return: String
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * 方法名 ： setUuid
	 * 功 能 ： 设置变量 uuid 的值
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * 方法名 ： getList
	 * 功 能 ： 返回变量 list 的值
	 * @return: List<T>
	 */
	public List<T> getList() {
		return list;
	}

	/**
	 * 方法名 ： setList
	 * 功 能 ： 设置变量 list 的值
	 */
	public void setList(List<T> list) {
		this.list = list;
	}

	/**
	 * 方法名 ： getUsername
	 * 功 能 ： 返回变量 username 的值
	 * @return: String
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 方法名 ： setUsername
	 * 功 能 ： 设置变量 username 的值
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	public Map<String, String> getMap() {
		return map;
	}

	/**
	 * 方法名 ： setMap
	 * 功 能 ： 设置变量 map 的值
	 */
	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	/**
	 * 方法名 ： getSearchList
	 * 功 能 ： 返回变量 searchList 的值
	 * @return: List<SearchParameters>
	 */
	public List<SearchParameters> getSearchList() {
		return searchList;
	}

	/**
	 * 方法名 ： setSearchList
	 * 功 能 ： 设置变量 searchList 的值
	 */
	public void setSearchList(List<SearchParameters> searchList) {
		this.searchList = searchList;
	}

	/**
	 * 方法名 ： getSortList
	 * 功 能 ： 返回变量 sortList 的值
	 * @return: List<SortParameters>
	 */
	public List<SortParameters> getSortList() {
		return sortList;
	}

	/**
	 * 方法名 ： setSortList
	 * 功 能 ： 设置变量 sortList 的值
	 */
	public void setSortList(List<SortParameters> sortList) {
		this.sortList = sortList;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Sort sort() {
		if (this.sortList == null || this.sortList.size() == 0) {
			return null;
		}
		Sort sort = null;
		// 排序
		Collections.sort(this.sortList, new BeanComparator("sort"));
		List<Order> orderList = new ArrayList<>();
		this.sortList.forEach(item -> {
			if (item.getSortName() != null) {
				Order order = null;
				switch (item.getSortOrder()) {
					case "asc":
						order = Order.asc(item.getSortName());
						break;
					case "desc":
						order = Order.desc(item.getSortName());
						break;
					default:
						order = Order.asc(item.getSortName());
						break;
				}
				orderList.add(order);
			}
		});
		if (orderList != null && orderList.size() > 0) {
			sort = Sort.by(orderList);
		}
		return sort;
	}

	/**
	 * 方法名 ： toString
	 * 功 能 ： TODO(这里用一句话描述这个方法的作用)
	 * 参 数 ： @return
	 * 参 考 ： @see java.lang.Object#toString()
	 * 作 者 ： Administrator
	 */

	@Override
	public String toString() {
		return "Pagination [pageNumber=" + pageNumber + ", pageSize=" + pageSize + ", uuid=" + uuid + ", username=" + username + ", list=" + list + ", info=" + info + ", map=" + map + "]";
	}

}
