package de.krien.game.survivalists.controller.input.inputEventHandler;

import java.util.List;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KeyReleasedEventHandler implements EventHandler<KeyEvent> {

	private List<KeyCode> keyReleasedList;

	public KeyReleasedEventHandler(List<KeyCode> keyReleasedList) {
		super();
		this.keyReleasedList = keyReleasedList;
	}

	public void handle(KeyEvent event) {
		keyReleasedList.add(event.getCode());
		event.consume();
	}

}
