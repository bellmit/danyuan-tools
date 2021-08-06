/**
 *
 */
package org.danyuan.application.lession.day001.lesson007;

import java.net.URL;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
		// 打开一个页面
		HostServices hostServices = getHostServices();
		hostServices.showDocument("http://www.baidu.com");
		// 导入一个图片rul
		URL url = getClass().getClassLoader().getResource("./static/dist/imgs/uugai_94x194.png");

		Button b = new Button("按钮");

		Group g = new Group();
		g.getChildren().add(b);

		Scene scene = new Scene(g);
		String path = url.toExternalForm();
		System.out.println(path);
		scene.setCursor(Cursor.cursor(path));

		primaryStage.setScene(scene);

		primaryStage.setTitle("lesson7");
		primaryStage.setWidth(800);
		primaryStage.setHeight(800);

		primaryStage.show();
	}

}
