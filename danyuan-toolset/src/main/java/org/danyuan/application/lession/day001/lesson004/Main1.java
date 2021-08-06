/**
 *
 */
package org.danyuan.application.lession.day001.lesson004;

import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
		Stage s1 = new Stage();
		s1.setTitle("s1");
		// s1.initStyle(StageStyle.DECORATED);
		// s1.initStyle(StageStyle.TRANSPARENT); // 隐藏
		// s1.initStyle(StageStyle.UNDECORATED); // 隐藏
		// s1.initStyle(StageStyle.UNIFIED);
		s1.initStyle(StageStyle.UTILITY); // 没有最小最大按钮
		Stage s2 = new Stage();
		s2.setTitle("s2");
		s2.initOwner(s1);
		s2.initModality(Modality.WINDOW_MODAL);
		s1.show();
		s2.show();

		// Platform.exit();
	}

}
