package de.krien.game.survivalists.controller.input;

import java.util.ArrayList;
import java.util.List;

import de.krien.game.survivalists.controller.input.inputEventHandler.KeyPressedEventHandler;
import javafx.scene.Group;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public enum InputHandler {

	INSTANCE();
	
	private List<KeyCode> keyPressedList;
	private List<KeyCode> keyReleasedList;
	private List<KeyCode> keyTypedList;
	
	private InputHandler() {
		keyPressedList = new ArrayList<>();
		keyReleasedList = new ArrayList<>();
		keyTypedList = new ArrayList<>();
	}
	
	public void addKeyEventHandler(Group root) {
		root.getScene().addEventHandler(KeyEvent.KEY_PRESSED, new KeyPressedEventHandler(keyPressedList));
		root.getScene().addEventHandler(KeyEvent.KEY_RELEASED, new KeyPressedEventHandler(keyReleasedList));
		root.getScene().addEventHandler(KeyEvent.KEY_TYPED, new KeyPressedEventHandler(keyTypedList));
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
	
	public void reset() {
		keyPressedList.clear();
		keyReleasedList.clear();
		keyTypedList.clear();
	}

	
	
}
