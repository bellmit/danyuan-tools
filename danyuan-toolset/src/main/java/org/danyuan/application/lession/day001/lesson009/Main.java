/**
 *
 */
package org.danyuan.application.lession.day001.lesson009;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
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
		Button button1 = new Button("这是按钮");
		button1.setLayoutX(100);
		button1.setLayoutY(100);
		button1.setPrefSize(400, 200);
		// 字体
		button1.setFont(Font.font("sans-serif", 40));
		// 颜色
		button1.setTextFill(Paint.valueOf("red"));
		BackgroundFill bgf = new BackgroundFill(Paint.valueOf("#8FBC8F55"), new CornerRadii(20), new Insets(10));

		// 背景
		Background background = new Background(bgf);
		button1.setBackground(background);
		BorderStroke bs = new BorderStroke(Paint.valueOf("#8AEBE2"), BorderStrokeStyle.SOLID, new CornerRadii(20), new BorderWidths(5, 10, 20, 6));
		button1.setStyle("-fx-background-color:green;-fx-background-radius:20");
		// 事件
		button1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Button b = (Button) event.getSource();
				System.out.println(b.getText());
				System.out.println("点击");
			}
		});

		// 边框
		Border border = new Border(bs);
		button1.setBorder(border);
		Group group = new Group();
		group.getChildren().add(button1);
		Scene scene = new Scene(group);

		primaryStage.setScene(scene);
		primaryStage.setTitle("lesson8");
		primaryStage.setWidth(800);
		primaryStage.setHeight(800);
		primaryStage.show();
	}

}
