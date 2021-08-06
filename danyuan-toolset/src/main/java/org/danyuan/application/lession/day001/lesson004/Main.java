/**
 *
 */
package org.danyuan.application.lession.day001.lesson004;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
		primaryStage.setOpacity(0.8); // 透明度
		primaryStage.setAlwaysOnTop(true);
		primaryStage.setX(150);
		primaryStage.setY(50);
		primaryStage.xProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				System.out.println(primaryStage.getX());

			}
		});
		primaryStage.yProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				System.out.println(primaryStage.getY());

			}
		});

		primaryStage.show();
	}

}
