/**
 *
 */
package org.danyuan.application.lession.day001.lesson008;

import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
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

	int i = 1;

	/*
	 * (non-Javadoc)
	 *
	 *  javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		Button button1 = new Button("b1");
		// 位置
		button1.setLayoutX(0);
		button1.setLayoutY(0);
		Button button2 = new Button("b2");
		button2.setLayoutX(100);
		button2.setLayoutY(0);
		// 组件宽高
		button2.setPrefSize(50, 100);
		Button button3 = new Button("b3");
		button3.setLayoutX(200);
		button3.setLayoutY(0);

		Group group = new Group();
		group.getChildren().addAll(button1, button2, button3);

		// 删除一个组件
		// group.getChildren().remove(button3);
		// 自动管理组件宽高
		group.setAutoSizeChildren(true);
		// 指定位置是否有组件 只有组件的左上角
		System.out.println(group.contains(0, 0));
		// 组件集合
		Object[] arr = group.getChildren().toArray();

		for (Object object : arr) {
			Button b = (Button) object;
			b.setPrefSize(100, 20);

		}

		// 点击事件
		button1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Button button4 = new Button("b4");
				button4.setLayoutX(400);
				button4.setLayoutY(i);
				button4.setPrefSize(100, 20 + (i++));
				group.getChildren().add(button4);
			}
		});
		// 监听事件
		group.getChildren().addListener(new ListChangeListener<Node>() {

			@Override
			public void onChanged(javafx.collections.ListChangeListener.Change<? extends Node> c) {
				System.out.println("添加组件数量" + c.getList().size());

			}

		});

		Scene scene = new Scene(group);

		primaryStage.setScene(scene);
		primaryStage.setTitle("lesson8");
		primaryStage.setWidth(800);
		primaryStage.setHeight(800);
		primaryStage.show();
	}

}
