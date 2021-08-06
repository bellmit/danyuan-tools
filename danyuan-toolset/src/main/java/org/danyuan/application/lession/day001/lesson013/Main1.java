/**
 *
 */
package org.danyuan.application.lession.day001.lesson013;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * 作 者: wth
 */
public class Main1 extends Application {

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
		pane.setStyle("-fx-background-color:green");
		AnchorPane pane2 = new AnchorPane();

		pane2.setStyle("-fx-background-color:red");

		Scene scene = new Scene(pane);
		pane.getChildren().addAll(pane2);
		pane.getChildren().addAll(b1, b2);
		pane2.getChildren().addAll(b3, b4);
		pane2.setLayoutY(100);

		primaryStage.setWidth(800);
		primaryStage.setHeight(800);
		primaryStage.setScene(scene);
		primaryStage.setTitle("lesson13");
		primaryStage.show();

		AnchorPane.setLeftAnchor(pane2, 50d);
		AnchorPane.setRightAnchor(pane2, 0d);
		AnchorPane.setTopAnchor(pane2, 20d);
		AnchorPane.setBottomAnchor(pane2, 50d);

		AnchorPane.setBottomAnchor(b3, 0.0);

		primaryStage.heightProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				System.out.println("123");

			}
		});

	}

}
