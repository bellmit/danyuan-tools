package org.danyuan.application.tools.windows.service;

import org.danyuan.application.tools.common.base.BaseService;
import org.danyuan.application.tools.common.base.BaseServiceImpl;
import org.danyuan.application.tools.windows.dao.MainWindowsDao;
import org.danyuan.application.tools.windows.po.MainWindows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
*  文件名 ： MainWindowsService.java
*  包    名 ： org.danyuan.application.tools.windows.service
*  描    述 ： TODO(用一句话描述该文件做什么)
*  机能名称：TODO
*  技能ID ：TODO
*  作    者 ： wth
*  时    间 ： 2020年11月17日 下午10:30:30
*  版    本 ： V1.0
*/
@Service
public class MainWindowsService extends BaseServiceImpl<MainWindows> implements BaseService<MainWindows>{

	@Autowired
	MainWindowsDao mainWindowsDao;
}
