package com.example.atmloc.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Deepak Katariya
 * @date Sep 28, 2020
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AtmLocDto {

	private Address address;
	private float distance;
	private String type;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public float getDistance() {
		return distance;
	}

	public void setDistance(float distance) {
		this.distance = distance;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "AtmLocDto [address=" + address + ", distance=" + distance + ", type=" + type + "]";
	}
}
