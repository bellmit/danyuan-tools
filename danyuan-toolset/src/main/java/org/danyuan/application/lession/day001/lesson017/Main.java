/**
 *
 */
package org.danyuan.application.lession.day001.lesson017;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * 作 者: wth
 */
public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	/*
	 *  FlowPane布局类
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {

		Button btn1 = new Button("button1");
		Button btn2 = new Button("button2");
		Button btn3 = new Button("button3");
		Button btn4 = new Button("button4");
		Button btn5 = new Button("button5");
		Button btn6 = new Button("button6");
		Button btn7 = new Button("button7");
		Button btn8 = new Button("button8");

		FlowPane flowPane = new FlowPane();
		flowPane.setPadding(new Insets(10)); // 内边距
		flowPane.setHgap(100); // 左右间距
		flowPane.setVgap(100); // 上下间距
		flowPane.setOrientation(Orientation.VERTICAL); // 排列方式 垂直

		FlowPane.setMargin(btn1,new Insets(5)); // 静态方法自组件外边距


		flowPane.getChildren().addAll(btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8);
		Scene scene = new Scene(flowPane);

		primaryStage.setWidth(800);
		primaryStage.setHeight(800);
		primaryStage.setScene(scene);
		primaryStage.setTitle("lesson17 FlowPane布局类");
		primaryStage.show();
	}

}
