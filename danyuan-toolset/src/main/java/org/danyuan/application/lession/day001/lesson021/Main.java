/**
 *
 */
package org.danyuan.application.lession.day001.lesson021;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
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

		TilePane tilePane = new TilePane();

		tilePane.getChildren().addAll(btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8);

		tilePane.setVgap(10); // 间距
		tilePane.setHgap(10); //

		tilePane.setPadding(new Insets(10));
		TilePane.setMargin(btn1,new Insets(20)); // 导致其他空间都有间距


		Scene scene = new Scene(tilePane);
		primaryStage.setScene(scene);
		primaryStage.setTitle(" TilePane布局类");
		primaryStage.setWidth(400);
		primaryStage.setHeight(400);
		primaryStage.show();
	}
	
}
