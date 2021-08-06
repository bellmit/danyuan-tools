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
public class Main extends Application {

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
		Platform.runLater(new Runnable() {
			// 内部 一般实现程序更新
			@Override
			public void run() {
				System.out.println("run = " + Thread.currentThread().getName());
				int i = 0;
				while (i < 10) {
					System.out.println("i = " + i);
					i += 1;
				}

			}
		});
		System.out.println("run = " + Thread.currentThread().getName());
		primaryStage.show();
	}

}
