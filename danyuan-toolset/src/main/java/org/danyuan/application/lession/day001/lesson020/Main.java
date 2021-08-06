/**
 *
 */
package org.danyuan.application.lession.day001.lesson020;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.*;
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
	 *  TextFlow布局类
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		Text text1 = new Text("没人看系列");
		Text text2 = new Text("javafx视频教程");
		Text text3 = new Text("HEllo world");
		Text text4 = new Text("javafx视频教程");
		Text text5 = new Text("HEllo world");
		text1.setFont(Font.font(20));
		text2.setFill(Paint.valueOf("#caacdc"));

		text3.setFont(Font.font("Helvetica", FontWeight.THIN,28));

		AnchorPane anchorPane = new AnchorPane();


		TextFlow textFlow = new TextFlow();
		TextFlow textFlow2 = new TextFlow();
		textFlow.setStyle("-fx-background-color:#EFACFA"); // 背景色
		textFlow.setPadding(new Insets(10)); //内边距
		textFlow.setTextAlignment(TextAlignment.RIGHT); // 对齐方式
		textFlow.setLineSpacing(30); // 行间距
		textFlow.getChildren().addAll(text1,text2,text3);
		textFlow2.getChildren().addAll(text4,text5);

		anchorPane.getChildren().addAll(textFlow,textFlow2);
		Scene scene = new Scene(anchorPane);
		primaryStage.setScene(scene);
		primaryStage.setTitle("TextFlow布局类");
		primaryStage.setWidth(400);
		primaryStage.setHeight(400);
		primaryStage.show();
		
		primaryStage.widthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				System.out.println("rootwidth"+anchorPane.getWidth());
				System.out.println("textFlowwidth"+textFlow.getWidth());

			}
		});
		//
		anchorPane.widthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				textFlow.setPrefWidth(newValue.doubleValue());
			}
		});
	}
	
}
