package de.krien.game.survivalists.controller;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class GameLoop extends AnimationTimer {

	private Group root;

	private long previousTime = 0;
	private float maximumStep = Float.MAX_VALUE;

	public GameLoop(Group root) {
		super();
		this.root = root;
	}

	@Override
	public void handle(long currentTime) {
		if (previousTime == 0) {
			previousTime = currentTime;
			return;
		}

		float secondsElapsed = (currentTime - previousTime) / 1e9f; /* ns to s */
		float secondsElapsedCapped = Math.min(secondsElapsed, maximumStep);
		previousTime = currentTime;

		GraphicsContext graphicalContext = createGraphicsContext();

		GameManager.INSTANCE.draw(graphicalContext);
		GameManager.INSTANCE.update(secondsElapsedCapped);

	}

	private GraphicsContext createGraphicsContext() {
		removeOldCanvas();
		GraphicsContext graphicsContext = createNewGraphicsContext();
		return graphicsContext;
	}

	private GraphicsContext createNewGraphicsContext() {
		Canvas canvas = new Canvas(root.getScene().getHeight(), root.getScene().getWidth());
		GraphicsContext graphicalContext = canvas.getGraphicsContext2D();
		root.getChildren().add(canvas);
		return graphicalContext;
	}

	private void removeOldCanvas() {
		if (root.getChildren().size() > 0) {
			root.getChildren().remove(0);
		}
	}

	@Override
	public void stop() {
		previousTime = 0;
		super.stop();
	}

}
