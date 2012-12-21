package beans;

import java.io.Serializable;
import java.util.HashSet;

public class Coordinate implements Serializable{
	
	private int id_coordinate;
	private float latitude;
	private float longitude;
	private HashSet<Track> tracks = new HashSet<Track>();
	
	public Coordinate(){
		
	}
	
	public int getId_coordinate() {
		return id_coordinate;
	}

	public void setId_coordinate(int id_coordinate) {
		this.id_coordinate = id_coordinate;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public HashSet<Track> getTracks() {
		return tracks;
	}

	public void setTracks(HashSet<Track> tracks) {
		this.tracks = tracks;
	}
	
}
