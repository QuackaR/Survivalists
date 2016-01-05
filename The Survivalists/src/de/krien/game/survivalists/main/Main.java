package de.krien.game.survivalists.main;

import de.krien.game.survivalists.controller.game.GameLoop;
import de.krien.game.survivalists.controller.input.InputHandler;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	private double SCENE_WIDTH = 800;
	private double SCENE_HEIGHT = 600;

	
	
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
		InputHandler.INSTANCE.addKeyEventHandler(root);
		AnimationTimer timer = new GameLoop(root);
		timer.start();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
