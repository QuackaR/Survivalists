package de.krien.game.survivalists.controller.input.inputEventHandler;

import java.util.List;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KeyPressedEventHandler implements EventHandler<KeyEvent> {

	private List<KeyCode> keyPressedList;

	public KeyPressedEventHandler(List<KeyCode> keyPressedList) {
		super();
		this.keyPressedList = keyPressedList;
	}

	public void handle(KeyEvent event) {
		keyPressedList.add(event.getCode());
		event.consume();
	}

}
