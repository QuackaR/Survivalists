package de.krien.game.survivalists.controller.game;

import de.krien.game.survivalists.controller.input.InputHandler;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
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

		GraphicsContext graphicsContext = GraphicsContextFactory.createGraphicsContext(root);
		
		GameManager.INSTANCE.draw(graphicsContext);
		GameManager.INSTANCE.update(secondsElapsedCapped);
		
		InputHandler.INSTANCE.reset();
	}

	@Override
	public void stop() {
		previousTime = 0;
		super.stop();
	}

}
