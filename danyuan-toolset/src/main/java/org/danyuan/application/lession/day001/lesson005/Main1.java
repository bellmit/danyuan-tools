/**
 *
 */
package org.danyuan.application.lession.day001.lesson005;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

/**
 * 作 者: wth
 *
 */
public class Main1 extends Application {

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
		Platform.setImplicitExit(false); // 程序没有退出
		primaryStage.show();
		// Platform.exit(); // 强制退出程序
	}

}
