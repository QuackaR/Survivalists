package de.krien.game.survivalists.controller.gamestate.play;

import java.util.List;

import de.krien.game.survivalists.controller.gamestate.IGameState;
import de.krien.game.survivalists.controller.input.InputHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;

public enum PlayState implements IGameState {

	INSTANCE;

	public int pos_X = 50;
	public int pos_Y = 50;

	public int width = 25;
	public int height = 25;
	
	public int movementSpeed = 5;

	public void draw(GraphicsContext graphicalContext) {
		graphicalContext.fillOval(pos_X, pos_Y, width, height);
	}

	public void update(float secondsElapsed) {
		List<KeyCode> pressedKeys = InputHandler.INSTANCE.getKeyPressedList();
		
		if (pressedKeys.contains(KeyCode.D)) {
			pos_X+=movementSpeed;
		}

		if (pressedKeys.contains(KeyCode.A)) {
			pos_X-=movementSpeed;
		}

		if (pressedKeys.contains(KeyCode.S)) {
			pos_Y+=movementSpeed;
		}

		if (pressedKeys.contains(KeyCode.W)) {
			pos_Y-=movementSpeed;
		}

	}
}
