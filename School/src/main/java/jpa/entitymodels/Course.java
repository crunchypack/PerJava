package jpa.entitymodels;


import java.lang.Integer;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


import javax.persistence.*;

/**
 * Entity implementation class for Entity: Course
 *
 */
@Entity
@Table
public class Course  {

	   
	@Id
	@Column(name="id")
	private Integer cId;
	@Column(name="name")
	private String cName;
	@Column(name="instructor")
	private String cInstructor;
	
	@ManyToMany(mappedBy = "sCourses")
	List<Student> students = new ArrayList<Student>();
	
	
	

	public Course(Integer cId, String cName, String cInstructor) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cInstructor = cInstructor;
		
	}
	public Course() {
		this.cId = 1;
		this.cName = "Course name";
		this.cInstructor = "Instructor name";
	}   
	public Integer getcId() {
		return this.cId;
	}

	public void setcId(Integer cId) {
		this.cId = cId;
	}   
	public String getcName() {
		return this.cName;
	}

	public void setcName(String name) {
		this.cName = name;
	}   
	public String getcInstructor() {
		return this.cInstructor;
	}

	public void setcInstructor(String instructor) {
		this.cInstructor = instructor;
	}
	public List<Student> getStudents() {
		
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Course) {
			Course other = (Course) obj;
			boolean sameId = (this.cId.equals(other.getcId()));
			boolean sameIns= (this.cInstructor.equals(other.getcInstructor()));
			boolean sameName = (this.cName.equals(other.getcName()));
			
			
			if(sameId && sameName && sameIns) return true;
		}
		return false;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cId,cInstructor,cName);
	}
   
}
