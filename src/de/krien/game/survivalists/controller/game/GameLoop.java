package de.krien.game.survivalists.controller.game;

import de.krien.game.survivalists.controller.input.InputHandler;
import javafx.animation.AnimationTimer;

public class GameLoop extends AnimationTimer {

	private long previousTime = 0;
	private float maximumStep = Float.MAX_VALUE;

	@Override
	public void handle(long currentTime) {
		if (previousTime == 0) {
			previousTime = currentTime;
			return;
		}

		float secondsElapsed = (currentTime - previousTime) / 1e9f; /* ns to s */
		float secondsElapsedCapped = Math.min(secondsElapsed, maximumStep);
		previousTime = currentTime;

		GameManager.INSTANCE.draw();
		GameManager.INSTANCE.update(secondsElapsedCapped);
		
		InputHandler.INSTANCE.reset();
	}

	@Override
	public void stop() {
		previousTime = 0;
		super.stop();
	}

}
