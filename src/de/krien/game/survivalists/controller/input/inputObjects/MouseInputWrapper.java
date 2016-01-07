package de.krien.game.survivalists.controller.input.inputObjects;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

public class MouseInputWrapper {

	private Vector2D mousePosition;
	
	public MouseInputWrapper() {
		super();
		this.mousePosition = new Vector2D(0, 0);
	}

	public Vector2D getMousePosition() {
		return mousePosition;
	}

	public void setMousePosition(Vector2D mousePosition) {
		this.mousePosition = mousePosition;
	}
	
	
	
}
