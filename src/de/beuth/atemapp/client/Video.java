package de.beuth.atemapp.client;

import java.io.Serializable;

public class Video implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3689122921730006499L;

	private Integer id;

	private String name;

	public Video() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
