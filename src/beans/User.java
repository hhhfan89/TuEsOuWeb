package beans;

import java.io.Serializable;
import java.util.HashSet;

import org.hibernate.mapping.Set;

public class User implements Serializable {
    
    private int id_user;
    private String username;
    private String email;
    private String pwd;
    private String name;
    private String surname;
    private String telephone;
    private Address address;
    private Image image;
    private Message message;
    private HashSet<Track> tracks = new HashSet<Track>();
    
    public User() {
    }


	public int getId_user() {
		return id_user;
	}


	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

    public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public Image getImage() {
		return image;
	}


	public void setImage(Image image) {
		this.image = image;
	}


	public Message getMessage() {
		return message;
	}


	public void setMessage(Message message) {
		this.message = message;
	}

	public HashSet<Track> getTracks() {
		return tracks;
	}

	public void setTracks(HashSet<Track> tracks) {
		this.tracks = tracks;
	}
    
    
}


