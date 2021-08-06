/**
 *
 */
package org.danyuan.application.lession.day001.lesson013;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
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
		Button b1 = new Button("ssss1");
		Button b2 = new Button("ssss2");
		Button b3 = new Button("ssss3");
		Button b4 = new Button("ssss4");
		AnchorPane pane = new AnchorPane();
		// pane.setLayoutX(100);
		// pane.setLayoutY(100);
		// pane.setStyle("-fx-background-color:red");
		pane.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				System.out.println("1111");
			}
		});

		// pane.getChildren().add(b1);

		// pane.setTopAnchor(b1, 20d);
		// pane.setLeftAnchor(b1, 20d);
		// pane.setRightAnchor(b1, 10d);
		// pane.setBottomAnchor(b1, 30d);
		pane.setPadding(new Insets(10d));
		// pane 管理时 b1时 b1 定位wuxiao
		b1.setLayoutX(100);
		b2.setLayoutX(200);
		b3.setLayoutX(100);
		b4.setLayoutX(200);
		// b1.setLayoutY(100);

		Group group = new Group();
		group.setStyle("-fx-background-color:red");
		group.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				System.out.println("123");
			}
		});
		Group group2 = new Group();
		Scene scene = new Scene(pane);
		pane.getChildren().addAll(group, group2);
		group.getChildren().addAll(b1, b2);
		group2.getChildren().addAll(b3, b4);
		group2.setLayoutY(100);

		primaryStage.setWidth(800);
		primaryStage.setHeight(800);
		primaryStage.setScene(scene);
		primaryStage.setTitle("lesson13");
		primaryStage.show();
	}

}
