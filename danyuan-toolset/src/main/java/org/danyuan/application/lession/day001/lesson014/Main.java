/**
 *
 */
package org.danyuan.application.lession.day001.lesson014;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
		AnchorPane pane = new AnchorPane();
		pane.setStyle("-fx-background-color:red");
		HBox hbox = new HBox();
		VBox vbox = new VBox();
		Button b1 = new Button("b1");
		Button b2 = new Button("b2");
		Button b3 = new Button("b3");
		hbox.getChildren().addAll(b1, b2, b3);
		// vbox.getChildren().addAll(b1, b2, b3);
		hbox.setStyle("-fx-background-color:green");
		pane.getChildren().addAll(hbox);
		// pane.getChildren().addAll(vbox);
		hbox.setPrefSize(300, 200);
		hbox.setPadding(new Insets(10d));
		hbox.setSpacing(10);
		HBox.setMargin(b1, new Insets(10d));
		hbox.setAlignment(Pos.BOTTOM_CENTER);

		Scene scene = new Scene(pane);
		primaryStage.setWidth(800);
		primaryStage.setHeight(800);
		primaryStage.setScene(scene);
		primaryStage.setTitle("lesson14");
		primaryStage.show();
	}

}
