package de.krien.game.survivalists.main;

import de.krien.game.survivalists.controller.GameLoop;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	private double SCENE_WIDTH = 400;
	private double SCENE_HEIGHT = 800;

	
	
	@Override
	public void start(Stage stage) {
		try {
			Group root = new Group();
			Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);
			stage.setScene(scene);
			stage.show();
			runGameLoop(root);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void runGameLoop(Group root) {
		AnimationTimer timer = new GameLoop(root);
		timer.start();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
