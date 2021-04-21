package jpa.entitymodels;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Teacher
 *
 */
@Entity
@Table
@NamedQueries({
	@NamedQuery(
			name="getAllTeachers",
			query="SELECT e FROM Teacher e"),
	@NamedQuery(
			name="validateTeach", 
	query="SELECT e FROM Teacher e Where e.tEmail = :email AND e.tPassword = :pass")
})
public class Teacher implements Serializable {

	   
	@Id
	private String tEmail;
	private String tName;
	private String tPassword;
	private static final long serialVersionUID = 1L;
	
	@OneToMany(targetEntity = Course.class)
	private List<Course> courses = new ArrayList<Course>();

	public Teacher(String tEmail, String tName, String tPassword) {
		super();
		this.tEmail = tEmail;
		this.tName = tName;
		this.tPassword = tPassword;
		
		
	}
	public Teacher() {
		super();
	}   
	public String getTEmail() {
		return this.tEmail;
	}

	public void setTEmail(String tEmail) {
		this.tEmail = tEmail;
	}   
	public String getTName() {
		return this.tName;
	}

	public void setTName(String tName) {
		this.tName = tName;
	}   
	public String getTPassword() {
		return this.tPassword;
	}

	public void setTPassword(String tPassword) {
		this.tPassword = tPassword;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Teacher) {
			Teacher other = (Teacher) obj;
			boolean sameEmail = (this.tEmail.equals(other.getTEmail()));
			boolean sameName = (this.tName.equals(other.getTName()));
			boolean samePass = (this.tPassword.equals(other.getTPassword()));
			
			if(sameEmail && sameName && samePass) return true;
		}
		return false;
	}
	@Override
	public int hashCode() {
		return Objects.hash(tEmail,tName,tPassword);
	}
   
}
