/**
 *
 */
package org.danyuan.application.lession.day001.lesson005;

import javafx.application.Application;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.stage.Stage;

/**
 * 作 者: wth
 *
 */
public class Main2 extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	/*
	 * (non-Javadoc)
	 *
	 *  javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 系统支持效果检查 返回 true/false
		System.out.println(Platform.isSupported(ConditionalFeature.SCENE3D));

		primaryStage.show();
	}

}
