package de.krien.game.survivalists.model.entities.util;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import de.krien.game.survivalists.model.entities.IGameEntity;

public class PositionUtil {

	public static Vector2D getCenterPosition(IGameEntity entity) {
		double centerX = entity.getPosition().getX() + (entity.getImage().getWidth() / 2);
		double centerY = entity.getPosition().getY() + (entity.getImage().getHeight() / 2);
		Vector2D centerPosition = new Vector2D(centerX, centerY);
		return centerPosition;
	}
	
}
