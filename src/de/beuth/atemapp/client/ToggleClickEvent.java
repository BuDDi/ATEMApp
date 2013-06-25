package de.beuth.atemapp.client;

import java.io.Serializable;

/**
 * @author S. Buder
 */
public class ToggleClickEvent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1663436861853554912L;

	private String buttonID;

	private Boolean value;

	public ToggleClickEvent() {
		this("", false);
	}

	public ToggleClickEvent(String buttonID, Boolean value) {
		this.buttonID = buttonID;
		this.value = value;
	}

	public Boolean getValue() {
		return value;
	}

	public void setValue(Boolean value) {
		this.value = value;
	}

	public String getButtonID() {
		return buttonID;
	}

	public void setButtonID(String buttonID) {
		this.buttonID = buttonID;
	}

}
