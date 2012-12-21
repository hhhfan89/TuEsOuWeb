package beans;

import java.io.Serializable;

public class Message implements Serializable {
	
	private int id_message;
	private String text;
	private User user;
	
	public Message() {
	}
	
	public int getId_message() {
		return id_message;
	}
	public void setId_message(int id_message) {
		this.id_message = id_message;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}