package com.example.atmloc.dto;

/**
 * @author Deepak Katariya
 * @date Sep 28, 2020
 */
public class GeoLocation {

	private float lat;
	private float lng;

	public float getLat() {
		return lat;
	}

	public void setLat(float lat) {
		this.lat = lat;
	}

	public float getLng() {
		return lng;
	}

	public void setLng(float lng) {
		this.lng = lng;
	}

	@Override
	public String toString() {
		return "GeoLocation [lat=" + lat + ", lng=" + lng + "]";
	}
}
