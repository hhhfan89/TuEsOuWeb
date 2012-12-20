package beans;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

public class Coordinate implements Serializable{
	
	private int id_coordinate;
	private float latitude;
	private float longitude;
	
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
	
}
