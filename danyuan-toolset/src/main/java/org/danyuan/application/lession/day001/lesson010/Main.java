/**
 *
 */
package org.danyuan.application.lession.day001.lesson010;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
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
		Button button1 = new Button("b1");
		button1.setLayoutX(100);
		button1.setLayoutY(100);
		button1.setPrefSize(400, 200);
		// 事件
		// 单击事件
		button1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("单击");
			}
		});

		// 双击
		button1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// 鼠标
				System.out.println(event.getButton().name());
				// 左键双击
				if (event.getClickCount() == 2 && event.getButton().name().equals(MouseButton.PRIMARY.name())) {
					System.out.println("双击");
				}
				// 多击
				if (event.getClickCount() == 3) {
					System.out.println("多击");
				}
			}
		});
		// 键盘事件
		button1.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				if (event.getCode().getName().equals("A")) {
					System.out.println("键盘按下=" + event.getCode().getName());
				}
			}
		});

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
