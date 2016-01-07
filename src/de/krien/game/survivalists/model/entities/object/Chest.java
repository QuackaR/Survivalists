package de.krien.game.survivalists.model.entities.object;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import de.krien.game.survivalists.model.entities.IGameEntity;
import javafx.scene.image.Image;

public class Chest implements IGameEntity {

	private final int DEFAULT_POSITION = 500; // Temporary
	private final int DEFAULT_SIZE = 1;
	private final double DEFAULT_ROTATION = 0;
	private final String DEFAULT_IMAGE = "res/chest.png";

	private Vector2D position;
	private double sizeScalar;
	private double rotation;
	private Image image;

	public Chest() {
		super();
		this.position = new Vector2D(DEFAULT_POSITION, DEFAULT_POSITION);
		this.sizeScalar = DEFAULT_SIZE;
		this.rotation = DEFAULT_ROTATION;
		this.image = new Image(DEFAULT_IMAGE);
	}

	@Override
	public void update() {

	}

	public Vector2D getPosition() {
		return position;
	}

	public void setPosition(Vector2D position) {
		this.position = position;
	}

	public double getSizeScalar() {
		return sizeScalar;
	}

	public void setSizeScalar(double sizeScalar) {
		this.sizeScalar = sizeScalar;
	}

	public double getRotation() {
		return rotation;
	}

	public void setRotation(double rotation) {
		this.rotation = rotation;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

}
