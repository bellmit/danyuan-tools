package org.danyuan.application;

import org.danyuan.application.tools.common.config.SplashScreenCustom;
import org.danyuan.application.tools.windows.view.MainView;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;

@SpringBootApplication
@EnableConfigurationProperties
public class ToolsApplication extends AbstractJavaFxApplicationSupport {

	public static void main(String[] args) {
		launch(ToolsApplication.class, MainView.class, new SplashScreenCustom(), args);
	}

}
