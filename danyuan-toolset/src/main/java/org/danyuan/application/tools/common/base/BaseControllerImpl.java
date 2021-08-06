package org.danyuan.application.tools.common.base;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * 描 述： 通用类控制层实现类
 * 文件名： BaseControllerImpl.java
 * 包 名： org.danyuan.application.common.base
 * 时 间： 2019年1月16日 下午2:14:54
 * 作 者: Administrator
 * 版 本： V1.0
 */
@NoRepositoryBean
public class BaseControllerImpl<T> implements BaseController<T>  {

	@Autowired
	BaseService<T> baseService;

	/**
	 * 分页请求方法
	 *
	 * 方法名 page
	 * 参 数 : {@code Pagination<T> vo}
	 * 返 回 : {@code BaseResult<Page<T>>}
	 * 参 考 :  org.danyuan.application.common.base.BaseController#page(org.danyuan.application.common.base.Pagination)
	 * 作 者: Administrator
	 */

	@Override
	public BaseResult<Page<T>> page(Pagination<T> vo) {
		try {
			Page<T> page = baseService.page(vo);
			return ResultUtil.success(page);
		} catch (Exception e) {
			return ResultUtil.error(-1, e.getMessage());
		}
	}

	/**
	 * 查询所有数据，慎用
	 *
	 * 方法名 findAll
	 * 参 数 : info
	 * 返 回 :
	 * 参 考 :   org.danyuan.application.common.base.BaseController#findAll(java.lang.Object)
	 * 作 者: Administrator
	 */

	@Override
	public BaseResult<List<T>> findAll(T info) {
		try {
			List<T> list = baseService.findAll(info);
			return ResultUtil.success(list);
		} catch (Exception e) {
			return ResultUtil.error(-1, e.getMessage());
		}
	}

	/**
	 * 查询一条记录，
	 *
	 * 方法名 findOne
	 * 参 数 : info
	 * 返 回 : {@code BaseResult<T>}
	 * 参 考 :   org.danyuan.application.common.base.BaseController#findOne(java.lang.Object)
	 * 作 者: Administrator
	 */

	@Override
	public BaseResult<T> findOne( T info) {
		try {
			T page = baseService.findOne(info);
			return ResultUtil.success(page);
		} catch (Exception e) {
			return ResultUtil.error(-1, e.getMessage());
		}
	}

	/**
	 * 单条记录保存
	 *
	 * 方法名 save
	 * 参 数 : info
	 * 返 回 : {@code BaseResult<T>}
	 * 参 考 :   org.danyuan.application.common.base.BaseController#save(java.lang.Object)
	 * 作 者: Administrator
	 */

	@Override
	public BaseResult<T> save( T info) {
		try {
			T page = baseService.save(info);
			return ResultUtil.success(page);
		} catch (Exception e) {
			return ResultUtil.error(-1, e.getMessage());
		}
	}

	/**
	 * 多条记录保存
	 *
	 * 方法名 save
	 * 参 数 : vo
	 * 返 回 : {@code BaseResult<T>}
	 * 参 考 :   org.danyuan.application.common.base.BaseController#save(org.danyuan.application.common.base.Pagination)
	 * 作 者: Administrator
	 */

	@Override
	public BaseResult<T> saveAll( Pagination<T> vo) {
		try {
			baseService.saveAll(vo.getList());
			return ResultUtil.success();
		} catch (Exception e) {
			return ResultUtil.error(-1, e.getMessage());
		}
	}

	/**
	 * 多条记录删除
	 *
	 * 方法名 delete
	 * 参 数 : vo
	 * 返 回 : {@code BaseResult<T>}
	 * 参 考 :   org.danyuan.application.common.base.BaseController#delete(org.danyuan.application.common.base.Pagination)
	 * 作 者: Administrator
	 */

	@Override
	public BaseResult<T> deleteAll( Pagination<T> vo) {
		try {
			baseService.deleteAll(vo.getList());
			return ResultUtil.success();
		} catch (Exception e) {
			return ResultUtil.error(-1, e.getMessage());
		}
	}

	/**
	 * 单条记录删除
	 *
	 * 方法名 delete
	 * 参 数 : info
	 * 返 回 : {@code BaseResult<T>}
	 * 参 考 :   org.danyuan.application.common.base.BaseController#delete(java.lang.Object)
	 * 作 者: Administrator
	 */

	@Override
	public BaseResult<T> delete( T info) {
		try {
			baseService.delete(info);
			return ResultUtil.success();
		} catch (Exception e) {
			return ResultUtil.error(-1, e.getMessage());
		}
	}

	/**
	 * 删除整个表，慎用
	 *
	 * 方法名 trunc
	 * 返 回 : {@code BaseResult<T>}
	 * 参 考 :   org.danyuan.application.common.base.BaseController#trunc()
	 * 作 者: Administrator
	 */

	@Override
	public BaseResult<T> trunc() {
		try {
			baseService.trunc();
			return ResultUtil.success();
		} catch (Exception e) {
			return ResultUtil.error(-1, e.getMessage());
		}
	}

	/**
	 * 统计数量
	 *
	 * 方法名 count
	 * 参 数 : info
	 * 返 回 : {@code BaseResult<T>}
	 * 参 考 :   org.danyuan.application.common.base.BaseController#count(java.lang.Object)
	 * 作 者: Administrator
	 */

	@Override
	public BaseResult<Long> count(T info) {
		try {
			Long lengthLong = baseService.count(info);
			return ResultUtil.success(lengthLong);
		} catch (Exception e) {
			return ResultUtil.error(-1, e.getMessage());
		}
	}

	/**
	*  方法名 ： initialize
	*  功    能 ： 初始化方法,这里由各个具体类实现
	*  参    数 ： @param location
	*  参    数 ： @param resources
	*  参    考 ： @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
	*  作    者 ： wth
	*/

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
