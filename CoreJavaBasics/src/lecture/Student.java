package lecture;

public class Student {
	
	private int ID;
	private String fName;
	private String lName;
	private String email;
	private String phone;
	
	public Student(int ID, String fName, String lName, String email, String phone) {
		this.ID = ID;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.phone = phone;
	}
	public Student() {
		super();
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getID() {
		return ID;
	}
	public void setFirstName(String name) {
		this.fName = name;
	}
	public String getFirstName() {
		return fName;
	}
	
	public void setLastName(String name) {
		this.lName = name;
	}
	public String getLastName() {
		return lName;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPhone() {
		return phone;
	}
	public void printInfo() {
		System.out.printf("%-15s%-15s%-15s%-15s",fName,lName,email,phone);
	}

}
