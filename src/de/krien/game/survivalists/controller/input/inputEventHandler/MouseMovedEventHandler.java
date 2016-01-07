package de.krien.game.survivalists.controller.input.inputEventHandler;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import de.krien.game.survivalists.controller.input.inputObjects.MouseInputWrapper;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MouseMovedEventHandler implements EventHandler<MouseEvent> {

	private MouseInputWrapper mouseInputWrapper;

	public MouseMovedEventHandler(MouseInputWrapper mouseInputWrapper) {
		super();
		this.mouseInputWrapper = mouseInputWrapper;
	}

	@Override
	public void handle(MouseEvent event) {
		Vector2D mousePosition = new Vector2D(event.getX(), event.getY());
		mouseInputWrapper.setMousePosition(mousePosition);
	}
	
	

}
