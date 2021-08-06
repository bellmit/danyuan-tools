/**
 *
 */
package org.danyuan.application.lession.day001.lesson002;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * 作 者: wth
 *
 */
public class Main3 extends Application {

	public static void main(String[] args) {
		System.out.println("main()");
		launch(args);
	}

	/*
	 * (non-Javadoc)
	 *
	 *  javafx.application.Application#init()
	 */
	@Override
	public void init() throws Exception {
		System.out.println("init()");
		super.init();
	}

	/*
	 * (non-Javadoc)
	 *
	 *  javafx.application.Application#stop()
	 */
	@Override
	public void stop() throws Exception {
		System.out.println("stop()");
		super.stop();
	}

	/*
	 * (non-Javadoc)
	 *
	 *  javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println("start()");
		primaryStage.show();

	}
}
