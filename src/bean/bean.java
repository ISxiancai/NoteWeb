package bean;

import java.util.Date;

public class bean {

	private String name;
	private String pwd;
	private String email;
	
	
	private String note;
	private String date;
	private int iduser;
	private int idnote;
	
	
	public int getIdnote() {
		return idnote;
	}

	public void setIdnote(int idnote) {
		this.idnote = idnote;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}
	
	public int getIduser() {
		return iduser;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
