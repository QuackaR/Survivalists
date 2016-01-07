package de.krien.game.survivalists.model.entities.util;

import java.util.List;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import de.krien.game.survivalists.controller.input.InputHandler;
import de.krien.game.survivalists.model.entities.player.Player;
import javafx.scene.input.KeyCode;

public class MovementUtil {

	// TODO Create new class and extract method - PlayStateInputHandler
	// TODO Refactor code
	public static void moveEntity(Player player) {
		checkPressedKeys(player);
		checkReleasedKeys(player);
		doMovement(player);
	}

	private static void checkPressedKeys(Player player) {
		List<KeyCode> pressedKeys = InputHandler.INSTANCE.getKeyPressedList();

		if (pressedKeys.contains(KeyCode.D)) {
			player.getPlayerMovement().setMoveRight(true);
		}

		if (pressedKeys.contains(KeyCode.A)) {
			player.getPlayerMovement().setMoveLeft(true);
		}

		if (pressedKeys.contains(KeyCode.S)) {
			player.getPlayerMovement().setMoveDown(true);
		}

		if (pressedKeys.contains(KeyCode.W)) {
			player.getPlayerMovement().setMoveUp(true);
		}

		if (pressedKeys.contains(KeyCode.SHIFT)) {
			player.running();
		}

		if (pressedKeys.contains(KeyCode.CONTROL)) {
			player.sneak();
		}
	}

	private static void checkReleasedKeys(Player player) {
		List<KeyCode> releasedKeys = InputHandler.INSTANCE.getKeyReleasedList();

		if (releasedKeys.contains(KeyCode.D)) {
			player.getPlayerMovement().setMoveRight(false);
		}

		if (releasedKeys.contains(KeyCode.A)) {
			player.getPlayerMovement().setMoveLeft(false);
		}

		if (releasedKeys.contains(KeyCode.S)) {
			player.getPlayerMovement().setMoveDown(false);
		}

		if (releasedKeys.contains(KeyCode.W)) {
			player.getPlayerMovement().setMoveUp(false);
		}

		if (releasedKeys.contains(KeyCode.SHIFT)) {
			player.walk();
		}

		if (releasedKeys.contains(KeyCode.CONTROL)) {
			player.walk();
		}
	}

	private static void doMovement(Player player) {
		if (player.getPlayerMovement().isMoveRight()) {
			player.setPosition(player.getPosition().add(new Vector2D(player.getMovementSpeed(), 0)));
		}

		if (player.getPlayerMovement().isMoveLeft()) {
			player.setPosition(player.getPosition().subtract(new Vector2D(player.getMovementSpeed(), 0)));
		}

		if (player.getPlayerMovement().isMoveDown()) {
			player.setPosition(player.getPosition().add(new Vector2D(0, player.getMovementSpeed())));
		}

		if (player.getPlayerMovement().isMoveUp()) {
			player.setPosition(player.getPosition().subtract(new Vector2D(0, player.getMovementSpeed())));
		}
	}

}
