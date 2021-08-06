/**
 *
 */
package org.danyuan.application.lession.day001.lesson018;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * 作 者: wth
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
		Button btn1 = new Button("button1");
		Button btn2 = new Button("button2");
		Button btn3 = new Button("button3");
		Button btn4 = new Button("button4");
		Button btn5 = new Button("button5");
		Button btn6 = new Button("button6");
		Button btn7 = new Button("button7");
		Button btn8 = new Button("button8");

		GridPane gridPane = new GridPane();
//		gridPane.getChildren().addAll(btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8);

		// 方式1
//		gridPane.add(btn1,0,0); // 第0列，第0行
		// 方式2
		GridPane.setConstraints(btn1,1,1);
		gridPane.getChildren().add(btn1);
//		gridPane.add(btn2,0,1); // 第0列，第1行
		// 方式3
		GridPane.setColumnIndex(btn2,3);
		GridPane.setRowIndex(btn2,2);
		gridPane.getChildren().add(btn2);
		gridPane.add(btn3,0,2);
		gridPane.add(btn4,0,3);
		gridPane.add(btn5,1,0);
		gridPane.add(btn6,1,1);
		gridPane.add(btn7,1,2);
		gridPane.add(btn8,1,3);

		gridPane.setHgap(10); // 左右编剧
		gridPane.setVgap(10); // 上下间距
		GridPane.setMargin(btn1,new Insets(10)); // 外边距

		Scene scene = new Scene(gridPane);

		primaryStage.setWidth(800);
		primaryStage.setHeight(800);
		primaryStage.setScene(scene);
		primaryStage.setTitle("lesson17 GridPane布局类");
		primaryStage.show();
	}
	
}
