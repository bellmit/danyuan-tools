package org.danyuan.application.tools.windows.view;

import de.felixroske.jfxsupport.AbstractFxmlView;
import de.felixroske.jfxsupport.FXMLView;

/**
 *
*  文件名 ： LoginView.java
*  包    名 ： org.danyuan.application.tools.view
*  描    述 ： TODO(用一句话描述该文件做什么)
*  机能名称：TODO
*  技能ID ：TODO
*  作    者 ： wth
*  时    间 ： 2020年10月23日 上午1:08:27
*  版    本 ： V1.0
 */
@FXMLView(value = "/static/fxml/login.fxml"
, title = "用户登录", encoding = "UTF-8"
, css = { "/static/dist/css/login.css", "/static/dist/css/global.css" }
, bundle = "static/i18n/login/login")
public class LoginView extends AbstractFxmlView {

}
