package jpa.mainrunner;


import java.util.List;
import java.util.Scanner;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import jpa.entitymodels.Teacher;
import jpa.service.CourseService;
import jpa.service.StudentService;
import jpa.service.Teacherservice;

public class SMSRunner {
	// Declaring variables
	private Scanner sc;
	private CourseService cs;
	private StudentService ss;
	private Teacherservice ts;
	private Student currStudent;
	private Teacher currTeacher;
	
	/**
	 * Constructor
	 * Instantiates global variables
	 */
	public SMSRunner() {
		sc = new Scanner(System.in);
		 cs = new CourseService();
		ss = new StudentService();
		ts = new Teacherservice();
	}
	
	public static void main(String[] args) {
		// New instance of SMSRunner
		SMSRunner sms = new SMSRunner();
		sms.run();

	}
	/**
	 * Run the program
	 */
	private void run() {
		switch(menu()) { // get menu choice
		case 1:
			if(login()) {
				register();
			}
		case 2: // Extra  - teacher
			if(tlogin()) {
				int ch = tMenu();
				while(ch != 5) {
					switch(ch) {
					case 1:
						tCourses();
						break;
					case 2:
						tStudents();
						break;
					case 3:
						createStudent();
						break;
					case 4:
						unregister();
						break;
					default:
						System.out.println("Unknown choice");
					}
					ch = tMenu();
				}
				
			}
		case 3:
			System.out.println("Goodbye!");
			break;
		default:
			System.out.println("Unknown choice!\nShutting down..");
		}
		sc.close();
		ss.endAll();
		cs.endAll();
	}
	

	/**
	 * Prompt user to choose menu item
	 * @return user choice Integer
	 */
	private int menu() {
		
		int log = 0;
		while(true) { // Make sure user input is correct
			System.out.println("Are you a (n)");
			System.out.println("1. Student\n2. Teacher\n3. Quit");
			try{
				log = sc.nextInt();
				break;
			}catch(Exception e) {
				System.out.println("Please enter a number!");
				sc.nextLine();
			}
		}
		sc.nextLine();
		return log;
		
	}
	/**
	 * Prompts for credentials and log in. And prints out students courses
	 * @return true/false if login was successful or not
	 */
	private boolean login() {
		String email = "";
		String password = null;
		System.out.print("Enter email:");
		
		email = sc.nextLine();
		System.out.print("Enter password:");
		password = sc.nextLine();
		if(ss.validateStudent(email, password)) { // Validate credentials
			currStudent = ss.getStudentByEmail(email); // Store student
			List<Course> courses = ss.getStudentCourses(email); // Get student courses
			System.out.println("My Classes:");
			System.out.printf("%-20s %-25s %-20s \n", "#","COURSE NAME","INSTRUCTOR NAME");
			for(Course c : courses) {  // Prints the courses
				System.out.printf("%-20s %-25s %-20s \n", c.getcId(),c.getcName(),c.getcInstructor());
				}
			return true;
			}
		System.out.println("User Validation failed!");
		return false;
	}
	/**
	 * Presents available courses for registration
	 */
	private void register() {
		
		int choice = 0;
		while(true) {
			System.out.println("1. Register a class\n2. Logout");
			try{
				choice = sc.nextInt();
				break;
			}catch(Exception e) {
				System.out.println("Please enter a number!");
				sc.nextLine();
			}
		}
		sc.nextLine();
		switch(choice) { // Option to register or logout
		case 1: // Register
			System.out.println("All courses:");
			System.out.printf("%-20s %-25s %-20s \n", "ID","COURSE NAME","INSTRUCTOR NAME");
			List<Course> allC = cs.getAllCourses();	// Get all courses
			List<Course> studentC = ss.getStudentCourses(currStudent.getsEmail()); // Get all student courses
			
			allC.removeAll(studentC); // Remove courses already registered 
			for(Course c1 : allC) {
				System.out.printf("%-20s %-25s %-20s \n", c1.getcId(),c1.getcName(),c1.getcInstructor());
			}
			
			int course = 0;
			while(true) {
				try{
					System.out.print("Which course (id): ");
					course = sc.nextInt();
					if(cs.getCourseById(course) != null && !studentC.contains(cs.getCourseById(course))) {  // Check user input for valid course and course not already registered for
						ss.registerStudentToCourse(currStudent.getsEmail(), course); // Register user
						List<Course> ncourses = ss.getStudentCourses(currStudent.getsEmail()); // Get updated list of courses for student
						System.out.println("My Classes:");
						System.out.printf("%-20s %-25s %-20s \n", "#","COURSE NAME","INSTRUCTOR NAME");
						for(Course c : ncourses) {
							System.out.printf("%-20s %-25s %-20s \n", c.getcId(),c.getcName(),c.getcInstructor());
							}
						
						break;
						}
					else {
						System.out.println("Enter correct id");
						
					}
					
				}catch(Exception e) {
					System.out.println("Please enter a number!");
					sc.nextLine();
					}
				}
			break;
		case 2:
			System.out.println("Bye Bye");
			break;
		}
		
	}
	
	
	
	/**
	 * Removes student from course
	 */
	private void unregister() {
		List<Course> courses = ts.getTeacherCourses(currTeacher.getTEmail()); // get the teachers courses
		int course = 0;
		System.out.printf("%-20s %-25s\n", "#","COURSE NAME");
		for(Course c : courses) {  // Prints the courses
			System.out.printf("%-20s %-25s \n", c.getcId(),c.getcName());
			}
		while(true) { // picks a course with ID
			System.out.println("Pick course");
			try {
				course = sc.nextInt();
				break;

			}catch(Exception e) {
				System.out.println("Enter a number!");
			}
		}
		sc.nextLine();
		// Check that course exists and that the teacher teaches that course
		if(cs.getCourseById(course) != null && ts.getTeacherCourses(currTeacher.getTEmail()).contains(cs.getCourseById(course))) {
			List<Student> students = cs.getStudents(course); // get all students from that course
			System.out.printf("%-20s %-25s\n", "#","STUDENT NAME");
			for(Student s: students) {
				System.out.printf("%-20s %-25s \n", s.getsEmail(),s.getName());
				}
			String student = "";
			System.out.println("Pick a student email or cancel 0");
			student = sc.nextLine(); // Enter email to remove student
			
			//check that student exists and is taking the course
			if(ss.getStudentByEmail(student) != null && cs.getStudents(course).contains(ss.getStudentByEmail(student))) {
				ss.removeStudentsCourse(student, course);
				System.out.println("Student unregistered");
			}else if(Integer.parseInt(student) == 0) { 
				System.out.println("Cancelling...");
			}
			else {
				System.out.print("Student doesn't exist or is not in this course");
			}
		}else {
			System.out.println("Course doesn't exist or you don't teach it");
		}
		
		
		
	}
	
	/**
	 * Create a student account
	 */
	private void createStudent() {
		String email, name, pass;
		System.out.println("------------------------------------------------------------");
		System.out.print("Enter email: ");
		email = sc.nextLine();
		System.out.print("Enter name: ");
		name = sc.nextLine();
		System.out.print("Enter password: ");
		pass = sc.nextLine();
		ss.addStudent(email, name, pass);
		System.out.println("------------------------------------------------------------");
		
	}
	
	/**
	 * Display all students the teacher has in his courses
	 */
	private void tStudents() {
		List<Course> courses = ts.getTeacherCourses(currTeacher.getTEmail()); // get all courses
		System.out.println("------------------------------------------------------------");
		
		for(Course c : courses) {  // Prints the courses
			System.out.printf("\n%-20s %-25s\n", "#","COURSE NAME");
			System.out.printf("%-20s %-25s \n", c.getcId(),c.getcName());
			List<Student> students  = c.getStudents(); // get all students
			System.out.printf("%-25s %-25s\n", "STUDENT EMAIL","STUDENT NAME");
			for(Student s: students) {
				System.out.printf("%-25s %-25s \n", s.getsEmail(),s.getName());
				}
			System.out.println("------------------------------------------------------------");
			}
		
	}
	
	/**
	 * Get all courses taught by teacher
	 */
	private void tCourses() {
		List<Course> courses = ts.getTeacherCourses(currTeacher.getTEmail());
		
		System.out.println("------------------------------------------------------------");
		System.out.printf("\n%-20s %-25s\n", "#","COURSE NAME");
		for(Course c : courses) {  // Prints the courses
			System.out.printf("%-20s %-25s \n", c.getcId(),c.getcName());
			}
		System.out.println("------------------------------------------------------------");
	}
	
	/**
	 * Menu options for teacher
	 * @return Teacher choice Integer
	 */
	private int tMenu() {
		int tlog = 0;
		while(true) {
			System.out.println("1. Show courses\n2. Show students \n3. Create student account \n4. Unregister student \n5. Logout");
			System.out.print("Your choice: ");
			try {
				tlog = sc.nextInt();
				break;
			}catch (Exception e) {
				System.out.println("Please enter a number!");
				sc.nextLine();
			}		
		}
		sc.nextLine();
		return tlog;
	}
	
	/**
	 * Teacher login validation
	 * @return true or false based on entered credentials
	 */
	private boolean tlogin() {
		String email = "";
		String password = null;
		System.out.print("Enter email:");
		
		email = sc.nextLine();
		System.out.print("Enter password:");
		password = sc.nextLine();
		if(ts.validateTeacher(email, password)) { // Validate credentials
			currTeacher = ts.getTeacherByEmail(email); // Store Teacher
			return true;
			}
		System.out.println("User Validation failed!");
		return false;
	}
		

}
