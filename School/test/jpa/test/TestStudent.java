package jpa.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import jpa.service.StudentService;

class TestStudent {
	private static Student testStudent;
	private static StudentService ss;
	private final static String TEST_EMAIL = "JUnit@Test.co.uk";
	private final static String TEST_NAME = "J Unit";
	private final static String TEST_PASS = "SecrEt";
	
	private final static Integer COURSE_ID = 2;

	@BeforeAll
	static void setUp(){
		testStudent = new Student(TEST_EMAIL, TEST_NAME, TEST_PASS);
		ss = new StudentService();
	}

	@Test
	void testValidate() {
		boolean val = ss.validateStudent("aiannitti7@is.gd", "TWP4hf5j");
		assertTrue(val);
		
		boolean val2 = ss.validateStudent("Wromng", "erorr");
		assertFalse(val2);
	}
	@Test
	void testAddStudentGetEmail() {
		ss.addStudent(TEST_EMAIL, TEST_NAME, TEST_PASS);
		Student act = ss.getStudentByEmail(TEST_EMAIL);
		
		assertEquals(testStudent.getName(), act.getName());
	}
	@Test
	void testRegisterGetCourse() {

		ss.registerStudentToCourse(TEST_EMAIL, COURSE_ID);
		Course c = new Course(COURSE_ID, "Mathematics", "Eustace Niemetz");
		
		List<Course> courses = ss.getStudentCourses(TEST_EMAIL);

		
		assertTrue(courses.contains(c));
						
		
	}
	@Test
	void testRemoveStudentCourse() {

		ss.removeStudentsCourse(TEST_EMAIL, COURSE_ID);
		List<Course> courses = ss.getStudentCourses(TEST_EMAIL);

		assertEquals(0, courses.size());
	}
	@AfterAll
	static void tearDown() {
		ss.removeStudent(TEST_EMAIL);
		
		Student non = ss.getStudentByEmail(TEST_EMAIL);
		
		assertNull(non);
		
		ss.endAll();
	}


}
