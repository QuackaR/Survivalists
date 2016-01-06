package de.krien.game.survivalists.model.player;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Player {

	private final int DEFAULT_POSITION = 50; // Temporary
	private final int DEFAULT_SIZE = 75;
	private final int DEFAULT_MOVEMENT_SIZE = 5;
	private final int DEFAULT_ROTATION = 0;
	private final String DEFAULT_IMAGE = "res/player.jpg";

	private Vector2D position;
	private Vector2D size;
	private int movementSpeed;
	private int rotation;

	private Image image;
	private ImageView imageView;

	public Player() {
		super();
		this.position = new Vector2D(DEFAULT_POSITION, DEFAULT_POSITION);
		this.size = new Vector2D(DEFAULT_SIZE, DEFAULT_SIZE);
		this.movementSpeed = DEFAULT_MOVEMENT_SIZE;
		this.rotation = DEFAULT_ROTATION;
		this.image = new Image(DEFAULT_IMAGE);
	}

	public Player(Vector2D position, Vector2D size, int movementSpeed, int rotation, Image image) {
		super();
		this.position = position;
		this.size = size;
		this.movementSpeed = movementSpeed;
		this.rotation = rotation;
		this.image = image;
	}

	public Vector2D getPosition() {
		return position;
	}

	public void setPosition(Vector2D position) {
		this.position = position;
	}

	public Vector2D getSize() {
		return size;
	}

	public void setSize(Vector2D size) {
		this.size = size;
	}

	public int getMovementSpeed() {
		return movementSpeed;
	}

	public void setMovementSpeed(int movementSpeed) {
		this.movementSpeed = movementSpeed;
	}

	public int getRotation() {
		return rotation;
	}

	public void setRotation(int rotation) {
		this.rotation = rotation;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public ImageView getImageView() {
		return imageView;
	}

	public void setImageView(ImageView imageView) {
		this.imageView = imageView;
	}

}
