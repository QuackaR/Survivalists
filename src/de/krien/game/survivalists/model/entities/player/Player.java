package de.krien.game.survivalists.model.entities.player;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import de.krien.game.survivalists.model.entities.IGameEntity;
import de.krien.game.survivalists.model.entities.util.MovementUtil;
import de.krien.game.survivalists.model.entities.util.RotationUtil;
import javafx.scene.image.Image;

public class Player implements IGameEntity {

	private final int DEFAULT_POSITION = 250; // Temporary
	private final int DEFAULT_SIZE = 1;
	private final int SNEAK_MOVEMENT_SPEED = 1;
	private final int WALK_MOVEMENT_SPEED = 3;
	private final int RUN_MOVEMENT_SPEED = 5;
	private final double DEFAULT_ROTATION = 0;
	private final String DEFAULT_IMAGE = "res/player.png";

	private Vector2D position;
	private double sizeScalar;
	private int movementSpeed;
	private double rotation;
	private Image image;
	private PlayerMovement playerMovement;

	public Player() {
		super();
		this.position = new Vector2D(DEFAULT_POSITION, DEFAULT_POSITION);
		this.sizeScalar = DEFAULT_SIZE;
		this.movementSpeed = WALK_MOVEMENT_SPEED;
		this.rotation = DEFAULT_ROTATION;
		this.image = new Image(DEFAULT_IMAGE);
		this.playerMovement = new PlayerMovement();
	}

	public Player(Vector2D position, double sizeScalar, int movementSpeed, double rotation, Image image) {
		super();
		this.position = position;
		this.sizeScalar = sizeScalar;
		this.movementSpeed = movementSpeed;
		this.rotation = rotation;
		this.image = image;
	}

	@Override
	public void update() {
		MovementUtil.moveEntity(this);
		RotationUtil.rotateEntityToCursor(this);
	}
	
	public void running() {
		movementSpeed = RUN_MOVEMENT_SPEED;
	}

	public void sneak() {
		movementSpeed = SNEAK_MOVEMENT_SPEED;
	}

	public void walk() {
		movementSpeed = WALK_MOVEMENT_SPEED;
	}

	public Vector2D getPosition() {
		return position;
	}

	public void setPosition(Vector2D position) {
		this.position = position;
	}

	public double getSize() {
		return sizeScalar;
	}

	public void setSize(double sizeScalar) {
		this.sizeScalar = sizeScalar;
	}

	public int getMovementSpeed() {
		return movementSpeed;
	}

	public void setMovementSpeed(int movementSpeed) {
		this.movementSpeed = movementSpeed;
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

	public PlayerMovement getPlayerMovement() {
		return playerMovement;
	}

	public void setPlayerMovement(PlayerMovement playerMovement) {
		this.playerMovement = playerMovement;
	}
}
