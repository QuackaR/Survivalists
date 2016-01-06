package de.krien.game.survivalists.controller.input;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import de.krien.game.survivalists.controller.input.inputEventHandler.KeyPressedEventHandler;
import de.krien.game.survivalists.controller.input.inputEventHandler.MouseMovedEventHandler;
import de.krien.game.survivalists.controller.input.inputObjects.MouseInputWrapper;
import javafx.scene.Group;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public enum InputHandler {

	INSTANCE();

	private List<KeyCode> keyPressedList;
	private List<KeyCode> keyReleasedList;
	private List<KeyCode> keyTypedList;
	private MouseInputWrapper mouseInputWrapper;

	private InputHandler() {
		keyPressedList = new ArrayList<>();
		keyReleasedList = new ArrayList<>();
		keyTypedList = new ArrayList<>();
		mouseInputWrapper = new MouseInputWrapper();
	}

	public void addKeyEventHandler(Group root) {
		root.getScene().addEventHandler(KeyEvent.KEY_PRESSED, new KeyPressedEventHandler(keyPressedList));
		root.getScene().addEventHandler(KeyEvent.KEY_RELEASED, new KeyPressedEventHandler(keyReleasedList));
		root.getScene().addEventHandler(KeyEvent.KEY_TYPED, new KeyPressedEventHandler(keyTypedList));
		root.getScene().addEventFilter(MouseEvent.MOUSE_MOVED, new MouseMovedEventHandler(mouseInputWrapper));
	}

	public List<KeyCode> getKeyPressedList() {
		return keyPressedList;
	}

	public List<KeyCode> getKeyReleasedList() {
		return keyReleasedList;
	}

	public List<KeyCode> getKeyTypedList() {
		return keyTypedList;
	}

	public Vector2D getMousePosition() {
		return mouseInputWrapper.getMousePosition();
	}
	
	public void reset() {
		keyPressedList.clear();
		keyReleasedList.clear();
		keyTypedList.clear();
	}

}
