package de.krien.game.survivalists.controller.gamestate.play;

import java.util.List;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import de.krien.game.survivalists.controller.gamestate.IGameState;
import de.krien.game.survivalists.controller.input.InputHandler;
import de.krien.game.survivalists.model.player.Player;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

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

		// graphicalContext.fillOval(
		// player.getPosition().getX(),
		// player.getPosition().getY(),
		// player.getSize().getX(),
		// player.getSize().getY()
		// );
	}

	public void update(float secondsElapsed) {
		handleInput();
	}

	// TODO Create new class and extract method - PlayStateInputHandler
	// TODO Refactor code
	private void handleInput() {
		List<KeyCode> pressedKeys = InputHandler.INSTANCE.getKeyPressedList();
		if (pressedKeys.contains(KeyCode.D)) {
			player.setPosition(player.getPosition().add(new Vector2D(player.getMovementSpeed(), 0)));
			rotateImage(0);
		}

		if (pressedKeys.contains(KeyCode.A)) {
			player.setPosition(player.getPosition().subtract(new Vector2D(player.getMovementSpeed(), 0)));
			rotateImage(180);
		}

		if (pressedKeys.contains(KeyCode.S)) {
			player.setPosition(player.getPosition().add(new Vector2D(0, player.getMovementSpeed())));
			rotateImage(90);
		}

		if (pressedKeys.contains(KeyCode.W)) {
			player.setPosition(player.getPosition().subtract(new Vector2D(0, player.getMovementSpeed())));
			rotateImage(270);
		}
	}

	//TODO http://stackoverflow.com/questions/33613664/javafx-drawimage-rotated
	private void rotateImage(int rotation) {
		ImageView imageView = new ImageView(player.getImage());
		imageView.setRotate(rotation);
		SnapshotParameters params = new SnapshotParameters();
		params.setFill(Color.TRANSPARENT);
		player.setImage(imageView.snapshot(params, null));
	}
}
