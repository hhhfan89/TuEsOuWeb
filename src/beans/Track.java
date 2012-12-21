package beans;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.HashSet;

public class Track implements Serializable{
	
	private int id_track;
	private String name;
	private Date date;
	private Time start_time;
	private Time finish_time;
	private User user;
	private HashSet<Coordinate> coordinates = new HashSet<Coordinate>();
	
	public Track(){
		
	}

	public int getId_track() {
		return id_track;
	}

	public void setId_track(int id_track) {
		this.id_track = id_track;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getStart_time() {
		return start_time;
	}

	public void setStart_time(Time start_time) {
		this.start_time = start_time;
	}

	public Time getFinish_time() {
		return finish_time;
	}

	public void setFinish_time(Time finish_time) {
		this.finish_time = finish_time;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public HashSet<Coordinate> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(HashSet<Coordinate> coordinates) {
		this.coordinates = coordinates;
	}
	
	
}
