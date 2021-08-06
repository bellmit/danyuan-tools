/**
 *
 */
package org.danyuan.application.lession.day001.lesson011;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCharacterCombination;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.Mnemonic;
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
		button1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("单击");
			}
		});
		Group group = new Group();
		group.getChildren().add(button1);
		Scene scene = new Scene(group);
		// 快捷键
		KeyCombination kc1 = new KeyCodeCombination(KeyCode.C, KeyCombination.ALT_DOWN, KeyCombination.CONTROL_DOWN);
		Mnemonic mnemonic = new Mnemonic(button1, kc1);
		scene.addMnemonic(mnemonic);

		KeyCombination kc2 = new KeyCharacterCombination("O", KeyCombination.ALT_DOWN);
		Mnemonic mnemonic2 = new Mnemonic(button1, kc2);
		scene.addMnemonic(mnemonic2);

		KeyCombination kc4 = new KeyCodeCombination(KeyCode.Y, KeyCombination.SHORTCUT_DOWN);
		scene.getAccelerators().put(kc4, new Runnable() {

			@Override
			public void run() {
				System.out.println("run()");
				System.out.println(Thread.currentThread().getName());
				aaa();
			}
		});
		primaryStage.setScene(scene);
		primaryStage.setTitle("lesson8");
		primaryStage.setWidth(800);
		primaryStage.setHeight(800);
		primaryStage.show();
	}

	public void aaa() {
		System.out.println("sfasdfdsa");
	}
}
