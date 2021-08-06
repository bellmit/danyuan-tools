package org.danyuan.application.tools.windows.controller;

import org.danyuan.application.ToolsApplication;
import org.danyuan.application.tools.common.config.MessageUtils;
import org.danyuan.application.tools.common.config.UserConfig;
import org.danyuan.application.tools.windows.view.MainView;
import org.springframework.beans.factory.annotation.Autowired;

import de.felixroske.jfxsupport.FXMLController;
import javafx.event.Event;
import javafx.fxml.FXML;

/**
 *
*  文件名 ： LoginController.java
*  包    名 ： org.danyuan.application.tools.controller
*  描    述 ： TODO(用一句话描述该文件做什么)
*  机能名称：TODO
*  技能ID ：TODO
*  作    者 ： wth
*  时    间 ： 2020年10月23日 上午1:08:12
*  版    本 ： V1.0
 */
@FXMLController
public class LoginController {

	@Autowired
	UserConfig userConfig;

	@Autowired
	MessageUtils messageUtils;

	@FXML
	private void setHelloText(final Event event) {
		System.out.println(userConfig);
		System.out.println(messageUtils.get("usernameLabel"));

		ToolsApplication.showView(MainView.class);
	}
}
