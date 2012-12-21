package beans;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

public class Image implements Serializable{
	
	private int id_image;
	private String address;
	private User user;
	
	public Image(){
	}

	public int getId_image() {
		return id_image;
	}

	public void setId_image(int id_image) {
		this.id_image = id_image;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
