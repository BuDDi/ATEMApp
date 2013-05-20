package de.beuth.atemapp.client;

import java.io.Serializable;
import java.util.Date;

public class SliderEvent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2347174684080337247L;

	private String sliderID;

	private Integer value;

	private Integer connectionID;

	private Date time;

	public SliderEvent() {
		this(null, null, null);
	}

	public SliderEvent(Integer connectionID, String sliderID, Integer value) {
		this.connectionID = connectionID;
		this.sliderID = sliderID;
		this.value = value;
		this.time = new Date();
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getSliderID() {
		return sliderID;
	}

	public void setSliderID(String sliderID) {
		this.sliderID = sliderID;
	}

	public Integer getConnectionID() {
		return connectionID;
	}

	public void setConnectionID(Integer connectionID) {
		this.connectionID = connectionID;
	}

}
