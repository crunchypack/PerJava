package jpa.entitymodels;



import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;


@Entity
@Table
@NamedQueries({
	@NamedQuery(
			name="getAllStudents",
			query="SELECT e FROM Student e"),
	@NamedQuery(
			name="validate", 
	query="SELECT e FROM Student e Where e.sEmail = :semail AND e.sPassword = :spass")
})
public class Student  {

	   
	@Id
	@Column(name="email")
	private String sEmail;
	@Column(name="name")
	private String sName;
	@Column(name="password")
	private String sPassword;
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable( 
		name = "student_course",
		joinColumns = @JoinColumn(name = "sEmail"),
		inverseJoinColumns = @JoinColumn(name = "cId")
	)
	List<Course> sCourses = new ArrayList<Course>();

	public Student(String sEmail, String sName, String sPassword) {
		super();
		this.sEmail = sEmail;
		this.sName = sName;
		this.sPassword = sPassword;
		
	}
	public Student() {
		this.sEmail = "user@school.com";
		this.sName = "Student Name";
		this.sPassword = "SecurePass";
	}   
	public String getsEmail() {
		return this.sEmail;
	}

	public void setsEmail(String email) {
		this.sEmail = email;
	}   
	public String getName() {
		return this.sName;
	}

	public void setName(String name) {
		this.sName = name;
	}   
	public String getPassword() {
		return this.sPassword;
	}

	public void setPassword(String password) {
		this.sPassword = password;
	}
	public List<Course> getCourses() {
		return sCourses;
	}

	public void setCourses(List<Course> courses) {
		this.sCourses = courses;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student other = (Student) obj;
			boolean sameEmail = (this.sEmail.equals(other.getsEmail()));
			boolean sameName = (this.sName.equals(other.getName()));
			boolean samePass = (this.sPassword.equals(other.getPassword()));
			
			if(sameEmail && sameName && samePass) return true;
		}
		return false;
	}
	@Override
	public int hashCode() {
		return Objects.hash(sEmail,sName,sPassword);
	}
	
   
}
