/**
 *
 */
package org.danyuan.application.lession.day001.lesson012;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
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

		Group group = new Group();
		Scene scene = new Scene(group);
		primaryStage.setTitle("lesson12");
		primaryStage.setWidth(800);
		primaryStage.setHeight(800);
		primaryStage.setScene(scene);

		TextField field = new TextField();
		// field.setText("ssss");
		field.setLayoutX(100);
		field.setLayoutY(100);
		field.setFont(Font.font(14));
		Tooltip tip = new Tooltip();
		tip.setText("sdfdsfsd");
		tip.setFont(Font.font(40));
		// tooltip
		field.setTooltip(tip);
		// 提示灰色字
		field.setPromptText("这是智能输入7个");
		// 删除焦点
		field.setFocusTraversable(false);
		// 输入文本监听
		field.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// System.out.println(oldValue);
				// System.out.println(newValue);
				if (newValue.length() > 7) {
					field.setText(oldValue);
				}
			}
		});
		// 文本选择
		field.selectedTextProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				System.out.println(newValue);
			}
		});
		// 单击
		field.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("sfdsf");
			}
		});
		//
		field.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				System.out.println("鼠标点击事件");
			}
		});

		//
		PasswordField pf = new PasswordField();
		pf.setLayoutX(300);
		pf.setLayoutY(100);
		pf.setFont(Font.font(14));
		pf.setTooltip(tip);

		pf.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// System.out.println(oldValue);
				// System.out.println(newValue);
				if (newValue.length() > 7) {
					pf.setText(oldValue);
				}
			}
		});
		// label
		Label la = new Label("sdsss");
		la.setLayoutX(300);
		la.setLayoutY(200);
		la.setFont(Font.font(26));
		la.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				System.out.println("111");
			}
		});

		group.getChildren().add(field);
		group.getChildren().add(pf);
		group.getChildren().add(la);

		primaryStage.show();
	}

}
