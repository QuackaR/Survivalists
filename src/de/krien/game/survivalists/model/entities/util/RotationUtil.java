package de.krien.game.survivalists.model.entities.util;

import org.apache.commons.math3.analysis.function.Atan2;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import de.krien.game.survivalists.controller.input.InputHandler;
import de.krien.game.survivalists.model.entities.IGameEntity;

public class RotationUtil {
	
	public static void rotateEntityToOtherEntity(IGameEntity rotateEntity, IGameEntity destinationEntity) {
		double degree = getDirectionInDegree(rotateEntity.getCenterPosition(), destinationEntity.getCenterPosition());
		rotateEntity.setRotation(degree);
	}

	public static void rotateEntityToCursor(IGameEntity entity) {
		Vector2D playerCenterPosition = entity.getCenterPosition();
		Vector2D cursorPosition = InputHandler.INSTANCE.getMousePosition();
		double degree = getDirectionInDegree(playerCenterPosition, cursorPosition);
		entity.setRotation(degree);
	}

	private static double getDirectionInDegree(Vector2D playerCenterPosition, Vector2D mousePosition) {
		double radians = getDirectionInRadians(playerCenterPosition, mousePosition);
		double degree = (360 + ((radians * (180 / Math.PI) * -1) + 90)) % 360;
		return degree;
	}

	private static double getDirectionInRadians(Vector2D playerCenterPosition, Vector2D mousePosition) {
		Atan2 atan2 = new Atan2();
		double radians = atan2.value(mousePosition.getX() - playerCenterPosition.getX(),
				mousePosition.getY() - playerCenterPosition.getY());
		return radians;
	}

}
