package de.krien.game.survivalists.controller.game;

import de.krien.game.survivalists.controller.game.GameLoop;
import de.krien.game.survivalists.controller.input.InputHandler;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Game extends Application {

	private double SCENE_WIDTH = 800;
	private double SCENE_HEIGHT = 600;

	private Group root;

	@Override
	public void start(Stage stage) {
		try {
			root = GameReferences.INSTANCE.getRoot();
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
		AnimationTimer timer = new GameLoop();
		timer.start();
	}
	
	public static void main(String[] args) {
		Game.launch(args);
	}

}
