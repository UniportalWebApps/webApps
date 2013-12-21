package org.uniportal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

	@Id
	private int id;
	private String firstName;
	private String lastName;

	@Lob
	@Column(name = "std_image", columnDefinition = "mediumblob")
	private byte[] stdImage;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public byte[] getStdImage() {
		return stdImage;
	}

	public void setStdImage(byte[] stdImage) {
		this.stdImage = stdImage;
	}

	@Override
	public String toString() {
		return "ID: " + this.getId() + "First Name: " + this.getFirstName()
				+ "Last Name: " + this.getLastName();
	}

}
