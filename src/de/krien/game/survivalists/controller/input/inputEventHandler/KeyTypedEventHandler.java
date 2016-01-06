package de.krien.game.survivalists.controller.input.inputEventHandler;

import java.util.List;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KeyTypedEventHandler implements EventHandler<KeyEvent> {

	private List<KeyCode> keyTypedList;

	public KeyTypedEventHandler(List<KeyCode> keyTypedList) {
		super();
		this.keyTypedList = keyTypedList;
	}

	public void handle(KeyEvent event) {
		keyTypedList.add(event.getCode());
		event.consume();
	}

}
