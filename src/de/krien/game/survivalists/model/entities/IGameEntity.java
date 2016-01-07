package de.krien.game.survivalists.model.entities;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import javafx.scene.image.Image;

public interface IGameEntity {

	EGameEntity getEntityType();
	Image getImage();
	
	void update();
	
	Vector2D getPosition();
	void setPosition(Vector2D position);
	
	Vector2D getCenterPosition();
	
	double getRotation();
	void setRotation(double rotation);
}
