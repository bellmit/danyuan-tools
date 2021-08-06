/**
 *
 */
package org.danyuan.application.lession.day001.lesson003;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * 作 者: wth
 *
 */
public class Main1 extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("title"); // 标题
		// 图标 logo ico格式不好用
		primaryStage.getIcons().add(new Image("./static/dist/imgs/uugai_94x194.png"));

		primaryStage.setIconified(true); // 最小化
		primaryStage.setMaximized(true); // 最大化
		// 宽高
		// primaryStage.setHeight(500);
		// primaryStage.setWidth(500);
		// 最小宽高
		// primaryStage.setMinHeight(300);
		// primaryStage.setMinWidth(300);
		// 最大宽高
		// primaryStage.setMaxHeight(650);
		// primaryStage.setMaxWidth(1060);
		// 固定窗口大小
		// primaryStage.setResizable(false);

		// primaryStage.close(); // 关闭
		System.out.println(primaryStage.getHeight());
		System.out.println(primaryStage.getWidth());

		primaryStage.heightProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				System.out.println(primaryStage.getHeight());

			}
		});
		primaryStage.widthProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				System.out.println(primaryStage.getWidth());

			}
		});

		// 设置全屏

		primaryStage.setFullScreen(true);
		primaryStage.setScene(new Scene(new Group()));

		primaryStage.show();
	}

}
