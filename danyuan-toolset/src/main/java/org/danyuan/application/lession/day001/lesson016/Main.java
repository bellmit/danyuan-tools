/**
 *
 */
package org.danyuan.application.lession.day001.lesson016;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
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
		AnchorPane pane1 = new AnchorPane();
		pane1.setStyle("-fx-background-color:red");
		pane1.setPrefHeight(20d);
		AnchorPane pane2 = new AnchorPane();
		pane2.setStyle("-fx-background-color:green");
		pane2.setPrefHeight(20d);
		AnchorPane pane3 = new AnchorPane();
		pane3.setStyle("-fx-background-color:green");
		pane3.setPrefWidth(20d);
		AnchorPane pane4 = new AnchorPane();
		pane4.setStyle("-fx-background-color:green");
		pane4.setPrefWidth(20d);
		AnchorPane pane5 = new AnchorPane();
		pane5.setStyle("-fx-background-color:red");
		pane5.setPrefSize(20d, 20d);

		BorderPane bp = new BorderPane();
		bp.setTop(pane1);
		bp.setBottom(pane2);
		bp.setLeft(pane3);
		bp.setRight(pane4);
		bp.setCenter(pane5);

		bp.setPadding(new Insets(10d));
		BorderPane.setMargin(pane1, new Insets(10d));
		// bp.getChildren().addAll(pane1, pane2, pane3, pane4, pane5);
		Scene scene = new Scene(bp);

		primaryStage.setWidth(800);
		primaryStage.setHeight(800);
		primaryStage.setScene(scene);
		primaryStage.setTitle("lesson16");
		primaryStage.show();
	}

}
