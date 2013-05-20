/*
 * Copyright 2013 Jeanfrancois Arcand
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package de.beuth.atemapp.client;

import java.io.Serializable;
import java.util.Date;

/**
 * @author p.havelaar
 */
public class ToggleClickEvent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1663436861853554912L;

	private String buttonID;

	private Boolean value;

	private Date time;

	public ToggleClickEvent() {
		this("", false);
	}

	public ToggleClickEvent(String buttonID, Boolean value) {
		this.buttonID = buttonID;
		this.value = value;
		this.time = new Date();
	}

	public Boolean getValue() {
		return value;
	}

	public void setValue(Boolean value) {
		this.value = value;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getButtonID() {
		return buttonID;
	}

	public void setButtonID(String buttonID) {
		this.buttonID = buttonID;
	}

}
