package de.krien.game.survivalists.controller.gamestate.play;

import java.util.List;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import de.krien.game.survivalists.controller.gamestate.IGameState;
import de.krien.game.survivalists.controller.input.InputHandler;
import de.krien.game.survivalists.model.player.Player;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.transform.Rotate;

public enum PlayState implements IGameState {

	INSTANCE;

	private Player player = new Player();
	
	public void draw(GraphicsContext graphicalContext) {
		graphicalContext.drawImage(
				player.getImage(), 
				player.getPosition().getX(), 
				player.getPosition().getY(),
				player.getSize().getX(),
				player.getSize().getY()
		);
		
//		graphicalContext.fillOval(
//				player.getPosition().getX(), 
//				player.getPosition().getY(), 
//				player.getSize().getX(), 
//				player.getSize().getY()
//		);
	}

	public void update(float secondsElapsed) {
		handleInput();
	}

	//TODO Create new class and extract method - PlayStateInputHandler
	//TODO Refactor code
	private void handleInput() {
		List<KeyCode> pressedKeys = InputHandler.INSTANCE.getKeyPressedList();
		if (pressedKeys.contains(KeyCode.D)) {
			player.setPosition(player.getPosition().add(new Vector2D(player.getMovementSpeed(), 0)));
		}

		if (pressedKeys.contains(KeyCode.A)) {
			player.setPosition(player.getPosition().subtract(new Vector2D(player.getMovementSpeed(), 0)));
		}

		if (pressedKeys.contains(KeyCode.S)) {
			player.setPosition(player.getPosition().add(new Vector2D(0, player.getMovementSpeed())));
		}

		if (pressedKeys.contains(KeyCode.W)) {
			player.setPosition(player.getPosition().subtract(new Vector2D(0, player.getMovementSpeed())));
		}
	}
	
	private void rotateImage(String direction) {
		final ImageView imageView = new ImageView(player.getImage());
	    imageView.setTranslateZ(imageView.getBoundsInLocal().getWidth() / 2.0);
	    imageView.setRotationAxis(Rotate.Y_AXIS);
	    
		switch(direction) {
		case "up":
			imageView.setRotate(270);
			break;
		case "down":
			imageView.setRotate(90);
			break;
		case "left":
			imageView.setRotate(180);
			break;
		case "right":
			imageView.setRotate(0);
			break;
		}
	}
}
