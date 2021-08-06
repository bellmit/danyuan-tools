package org.danyuan.application.tools.windows.controller;

import org.danyuan.application.ToolsApplication;
import org.danyuan.application.tools.common.base.BaseController;
import org.danyuan.application.tools.common.base.BaseControllerImpl;
import org.danyuan.application.tools.dic.view.MainView;
import org.danyuan.application.tools.windows.po.MainWindows;
import org.danyuan.application.tools.windows.service.MainWindowsService;
import org.springframework.beans.factory.annotation.Autowired;

import de.felixroske.jfxsupport.FXMLController;
import javafx.event.Event;
import javafx.fxml.FXML;

/**
 *
 * 文件名 ： MainController.java
 * 包 名 ： org.danyuan.application.tools.controller
 * 描 述 ： TODO(用一句话描述该文件做什么)
 * 机能名称：TODO
 * 技能ID ：TODO
 * 作 者 ： wth
 * 时 间 ： 2020年10月23日 上午1:07:59
 * 版 本 ： V1.0
 */
@FXMLController
public class MainController  extends BaseControllerImpl<MainWindows> implements BaseController<MainWindows>{

	@Autowired
	MainWindowsService a;

	@FXML
	public void showPerson(final Event event) {
		ToolsApplication.showView(MainView.class);
	}

	@FXML
	public void showMain(final Event event) {
		ToolsApplication.showView(MainView.class);
	}

}
