package de.krien.game.survivalists.model.entities;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import javafx.scene.image.Image;

public interface IGameEntity {

	Image getImage();
	
	void update();
	
	Vector2D getPosition();
	void setPosition(Vector2D position);
	
	double getRotation();
	void setRotation(double rotation);
}
