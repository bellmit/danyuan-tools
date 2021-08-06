/**
 *
 */
package org.danyuan.application.lession.day001.lesson019;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.function.Consumer;

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

		StackPane stackPane = new StackPane();
		stackPane.setStyle("-fx-background-color:#EE6AA7");
		stackPane.setPadding(new Insets(10));
		stackPane.setAlignment(Pos.BOTTOM_LEFT);


		StackPane.setMargin(btn1,new Insets(100));

		stackPane.getChildren().addAll(btn1,btn2,btn3,btn4,btn5);
		stackPane.getChildren().remove(btn2); // 移除

		stackPane.getChildren().forEach((item) -> {
			Button button = (Button)item;
			System.out.println(button.getText());
		});
		Scene scene = new Scene(stackPane);

		primaryStage.setWidth(800);
		primaryStage.setHeight(800);
		primaryStage.setScene(scene);
		primaryStage.setTitle("lesson19  StackPane布局类");
		primaryStage.show();
	}
	
}
