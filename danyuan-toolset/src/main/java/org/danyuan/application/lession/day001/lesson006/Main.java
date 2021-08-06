/**
 *
 */
package org.danyuan.application.lession.day001.lesson006;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * 作 者: wth
 *
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
		// 屏幕宽高获取去
		// 取得主屏幕
		Screen screen = Screen.getPrimary();
		// 整个屏幕
		Rectangle2D b = screen.getBounds();
		// 可视屏幕宽高
		Rectangle2D b2 = screen.getVisualBounds();

		System.out.println("屏幕x=" + b.getMaxX() + "屏幕y=" + b.getMaxY());
		System.out.println("屏幕宽=" + b.getWidth() + "屏幕高=" + b.getHeight());

		System.out.println("屏幕x=" + b2.getMaxX() + "屏幕y=" + b2.getMaxY());
		System.out.println("屏幕宽=" + b2.getWidth() + "屏幕高=" + b2.getHeight());
		double d = screen.getDpi();
		System.out.println("dpi=" + d);

		primaryStage.show();
	}

}
