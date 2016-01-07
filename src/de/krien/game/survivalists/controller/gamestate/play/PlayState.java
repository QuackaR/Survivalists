package de.krien.game.survivalists.controller.gamestate.play;

import java.util.List;

import org.apache.commons.math3.analysis.function.Atan2;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import de.krien.game.survivalists.controller.game.GraphicsContextFactory;
import de.krien.game.survivalists.controller.gamestate.IGameState;
import de.krien.game.survivalists.controller.input.InputHandler;
import de.krien.game.survivalists.model.player.Player;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.transform.Rotate;

public enum PlayState implements IGameState {

	INSTANCE;

	private Player player = new Player();

	private void rotate(GraphicsContext gc, double angle, double px, double py) {
		Rotate r = new Rotate(angle, px, py);
		gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
	}

	public void draw() {
		GraphicsContext graphicsContext = GraphicsContextFactory.createGraphicsContext();
		rotate(graphicsContext, player.getRotation(), player.getCenterPosition().getX(), player.getCenterPosition().getY());
		graphicsContext.drawImage(player.getImage(), player.getPosition().getX(), player.getPosition().getY());
//		graphicsContext.strokeRect(player.getPosition().getX(), player.getPosition().getY(), player.getImage().getWidth(),player.getImage().getHeight());
		
//		GraphicsContext gc = GraphicsContextFactory.createNewGraphicsContext();
//		double mouseX = InputHandler.INSTANCE.getMousePosition().getX();
//		double mouseY = InputHandler.INSTANCE.getMousePosition().getY();
//		gc.fillOval(mouseX - 2 , mouseY - 2, 4, 4);
//		gc.fillOval(player.getCenterPosition().getX() - 2, player.getCenterPosition().getY() - 2, 4, 4);
//		gc.strokeLine(player.getCenterPosition().getX(), player.getCenterPosition().getY(), mouseX, mouseY);
	}

	public void update(float secondsElapsed) {
		movePlayer();
		rotatePlayerToCursor();
	}

	private void rotatePlayerToCursor() {
		Vector2D playerCenterPosition = player.getCenterPosition();
		Vector2D cursorPosition = InputHandler.INSTANCE.getMousePosition();
		double degree = getDirectionInDegree(playerCenterPosition, cursorPosition);
		player.setRotation(degree);
	}

	private double getDirectionInDegree(Vector2D playerCenterPosition, Vector2D mousePosition) {
		double radians = getDirectionInRadians(playerCenterPosition, mousePosition);
		double degree = (360 + ((radians * (180 / Math.PI) * -1) + 90)) % 360;
		return degree;
	}

	private double getDirectionInRadians(Vector2D playerCenterPosition, Vector2D mousePosition) {
		Atan2 atan2 = new Atan2();
		double radians = atan2.value(mousePosition.getX() - playerCenterPosition.getX(), mousePosition.getY() - playerCenterPosition.getY());
		return radians;
	}

	boolean moveRight = false;
	boolean moveLeft = false;
	boolean moveUp = false;
	boolean moveDown = false;
	
	// TODO Create new class and extract method - PlayStateInputHandler
	// TODO Refactor code
	private void movePlayer() {
		checkPressedKeys();
		checkReleasedKeys();
		doMovement();
	}

	private void checkPressedKeys() {
		List<KeyCode> pressedKeys = InputHandler.INSTANCE.getKeyPressedList();

		if (pressedKeys.contains(KeyCode.D)) {
			moveRight = true;
		}

		if (pressedKeys.contains(KeyCode.A)) {
			moveLeft = true;
		}

		if (pressedKeys.contains(KeyCode.S)) {
			moveDown = true;
		}

		if (pressedKeys.contains(KeyCode.W)) {
			moveUp = true;
		}
		
		if(pressedKeys.contains(KeyCode.SHIFT)) {
			player.running();
		}
		
		if(pressedKeys.contains(KeyCode.CONTROL)) {
			player.sneak();
		}
	}
	
	private void checkReleasedKeys() {
		List<KeyCode> releasedKeys = InputHandler.INSTANCE.getKeyReleasedList();

		if (releasedKeys.contains(KeyCode.D)) {
			moveRight = false;
		}

		if (releasedKeys.contains(KeyCode.A)) {
			moveLeft = false;
		}

		if (releasedKeys.contains(KeyCode.S)) {
			moveDown = false;
		}

		if (releasedKeys.contains(KeyCode.W)) {
			moveUp = false;
		}
		
		if(releasedKeys.contains(KeyCode.SHIFT)) {
			player.walk();
		}
		
		if(releasedKeys.contains(KeyCode.CONTROL)) {
			player.walk();
		}
		
	}

	private void doMovement() {
		if (moveRight) {
			player.setPosition(player.getPosition().add(new Vector2D(player.getMovementSpeed(), 0)));
		}

		if (moveLeft) {
			player.setPosition(player.getPosition().subtract(new Vector2D(player.getMovementSpeed(), 0)));
		}

		if (moveDown) {
			player.setPosition(player.getPosition().add(new Vector2D(0, player.getMovementSpeed())));
		}

		if (moveUp) {
			player.setPosition(player.getPosition().subtract(new Vector2D(0, player.getMovementSpeed())));
		}
	}


}
