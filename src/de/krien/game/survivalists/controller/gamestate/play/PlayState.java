package de.krien.game.survivalists.controller.gamestate.play;

import java.util.List;

import org.apache.commons.math3.analysis.function.Atan2;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import de.krien.game.survivalists.controller.game.GraphicsContextFactory;
import de.krien.game.survivalists.controller.gamestate.IGameState;
import de.krien.game.survivalists.controller.input.InputHandler;
import de.krien.game.survivalists.model.player.Player;
import javafx.geometry.Point2D;
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
		double playerCenterX = player.getPosition().getX() + player.getImage().getWidth() / 2;
		double playerCenterY = player.getPosition().getY() + player.getImage().getHeight() / 2;

		rotate(
				graphicsContext, 
				player.getRotation(), 
				playerCenterX, 
				playerCenterY
		);
		graphicsContext.drawImage(
				player.getImage(), 
				player.getPosition().getX(), 
				player.getPosition().getY()
		);
		graphicsContext.strokeRect(
				player.getPosition().getX(),
				player.getPosition().getY(),
				player.getImage().getWidth(),
				player.getImage().getHeight()
		);
		GraphicsContext gc = GraphicsContextFactory.createNewGraphicsContext();
		
		double mouseX = InputHandler.INSTANCE.getMousePosition().getX();
		double mouseY = InputHandler.INSTANCE.getMousePosition().getY();
		
		gc.fillOval(mouseX, mouseY, 5, 5);
		gc.fillOval(playerCenterX, playerCenterY, 5, 5);
		gc.strokeLine(playerCenterX, playerCenterY, mouseX, mouseY);
	}

	public void update(float secondsElapsed) {
		handleMovement();
		handleDirection2();
	}

	private void handleDirection() {
		Vector2D playerPosition = player.getPosition();
		Vector2D mousePoisition = InputHandler.INSTANCE.getMousePosition();

		Atan2 atan2 = new Atan2();
		double radians = atan2.value(
				mousePoisition.getX() - (playerPosition.getX() + player.getImage().getWidth())/2,
				mousePoisition.getY() - (playerPosition.getY() + player.getImage().getHeight())/2
		);
		double degree = (radians * (180 / Math.PI) * -1) + 90;
		player.setRotation(degree);
		System.out.println("##################");
		System.out.println("Player Position: " + playerPosition.getX() + "/" + playerPosition.getY());
		System.out.println("Mouse Position: " + mousePoisition.getX() + "/" + mousePoisition.getY());
		System.out.println("Radian: " + radians);
		System.out.println("Degree: " + degree);
		System.out.println("##################");
	}
	
	private void handleDirection2() {
		Vector2D playerPosition = player.getPosition();
		Vector2D mousePosition = InputHandler.INSTANCE.getMousePosition();
		
		double imageCenterX = (playerPosition.getX() + player.getImage().getWidth()) / 2;
		double imageCenterY = (playerPosition.getY() + player.getImage().getHeight()) / 2;
		
		Point2D centerPos = new Point2D(imageCenterX, imageCenterY);
		Point2D mousePos = new Point2D(mousePosition.getX(), mousePosition.getY());
		
		double distanceX = mousePosition.getX() - imageCenterX;
		double distanceY = mousePosition.getY() - imageCenterY;
		
		double radians = Math.atan2(distanceX, distanceY);
		double angle = (360 - Math.toDegrees(radians)) % 360 + 90;
		double degree = new Point2D(1, 0).angle(mousePos.subtract(centerPos));
		player.setRotation(degree);
		
		System.out.println("##################");
		System.out.println("Image Center: " + imageCenterX + "/" + imageCenterY);
		System.out.println("Mouse Position: " + mousePosition.getX() + "/" + mousePosition.getY());
		System.out.println("Distance: " + distanceX + "/" + distanceY);
		System.out.println("Radians: " + radians);
		System.out.println("Angle: " + angle + " vs " + degree);
		System.out.println("##################");
	}	

	// TODO Create new class and extract method - PlayStateInputHandler
	// TODO Refactor code
	private void handleMovement() {
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

	// TODO http://stackoverflow.com/questions/33613664/javafx-drawimage-rotated
	// private void rotateImage(double rotation) {
	//
	//
	//// ImageView imageView = new ImageView(player.getImage());
	//// double rotationToApply = rotation - player.getRotation();
	//// player.setRotation(rotation);
	//// imageView.setRotate(rotationToApply);
	//// SnapshotParameters params = new SnapshotParameters();
	//// params.setFill(Color.TRANSPARENT);
	//// player.setImage(imageView.snapshot(params, null));
	// }
}
