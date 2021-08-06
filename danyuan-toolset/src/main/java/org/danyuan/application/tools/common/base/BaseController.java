package org.danyuan.application.tools.common.base;

import java.util.List;

import org.springframework.data.domain.Page;

import de.felixroske.jfxsupport.FXMLController;
import javafx.fxml.Initializable;

/**
 * 文件名 ： BaseController.java
 * 包 名 ： tk.ainiyue.danyuan.application.common.base
 * 描 述 ： 通用类控制层接口
 * 机能名称：
 * 技能ID ：
 * 作 者 ： wang
 * 时 间 ： 2018年4月3日 下午11:03:46
 * 版 本 ： V1.0
 */
@FXMLController
public interface BaseController<T> extends Initializable{

	BaseResult<Page<T>> page(Pagination<T> vo);

	BaseResult<List<T>> findAll(T info);

	BaseResult<T> findOne(T info);

	BaseResult<T> save(T info);

	BaseResult<T> saveAll(Pagination<T> vo);

	BaseResult<T> deleteAll(Pagination<T> vo);

	BaseResult<T> delete(T info);

	BaseResult<Long> count(T info);

	BaseResult<T> trunc();

}