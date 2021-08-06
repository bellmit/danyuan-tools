/**
 *
 */
package org.danyuan.application.lession.day001.lesson015;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

	static boolean isManager = false;
	static boolean isVisible = false;
	static Double opecityVal = 0d;

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
		Button b1 = new Button("111");
		Button b2 = new Button("2222");
		Button b3 = new Button("3333");
		Button b4 = new Button("4444");
		Button b5 = new Button("5555");
		Button b6 = new Button("33666633");
		Button b7 = new Button("7777");

		AnchorPane pane = new AnchorPane();
		HBox hb = new HBox();
		hb.getChildren().addAll(b1, b2, b3, b4);
		pane.setStyle("-fx-background-color:red");
		Scene scene = new Scene(pane);
		VBox vb = new VBox();
		vb.getChildren().addAll(b5, b6, b7);
		pane.setTopAnchor(vb, 40d);
		pane.setLeftAnchor(vb, 50d);
		pane.getChildren().addAll(hb, vb);
		// 组件隐藏位置被占
		b5.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				b3.setManaged(isManager);
				if (isManager == true) {
					isManager = false;
					b5.setText("b3.setManaged " + isManager);
				} else {
					isManager = true;
					b5.setText("b3.setManaged " + isManager);
				}
			}
		});
		// 组件隐藏 ,位置没被赞
		b6.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				b3.setVisible(isVisible);
				if (isVisible == true) {
					isVisible = false;
					b5.setText("b3.setManaged " + isVisible);
				} else {
					isVisible = true;
					b5.setText("b3.setManaged " + isVisible);
				}
			}
		});
		// 组件隐藏,透明 ,位置没被赞
		b7.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				b3.setOpacity(opecityVal);
				new Print(hb);
				if (opecityVal == 0d) {
					opecityVal = 1d;
					b5.setText("b3.setManaged " + opecityVal);
				} else {
					opecityVal = 0d;
					b5.setText("b3.setManaged " + opecityVal);
				}
			}
		});

		primaryStage.setWidth(800);
		primaryStage.setHeight(800);
		primaryStage.setScene(scene);
		primaryStage.setTitle("lesson15");
		primaryStage.show();
	}

}

class Print {
	Print(HBox hbox) {
		System.out.println("当前hbox组件数量=" + hbox.getChildren().size());
	}

}
