package jpa.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import jpa.entitymodels.Course;
import jpa.entitymodels.Teacher;
import jpa.service.Teacherservice;

class TestTeacher {
	private static Teacher testTeacher;
	private static Teacherservice ts;
	
	private final static String TEST_EMAIL = "Master@perscholas.com";
	private final static String TEST_NAME = "Creator man";
	private final static String TEST_PASS = "SecrEtStUfF";
	private final static Integer COURSE_ID = 7;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		testTeacher = new Teacher(TEST_EMAIL, TEST_NAME, TEST_PASS);
		ts = new Teacherservice();
	}



	@Test
	void testAddnGetByEmail() {
		ts.addTeacher(testTeacher);
		
		Teacher act = ts.getTeacherByEmail(TEST_EMAIL);
		
		assertEquals(testTeacher, act);
	}
	@Test
	void testValidate() {
		
		ts.addTeacher(testTeacher);
		boolean val = ts.validateTeacher(TEST_EMAIL, TEST_PASS);
		assertTrue(val);
		
		boolean val1 = ts.validateTeacher("Mas@mes.com",TEST_PASS);
		
		assertFalse(val1);
	}
	@Test
	void testTeachCoursenStop(){
		ts.addTeacher(testTeacher);
		ts.teachClass(TEST_EMAIL, COURSE_ID);
		Course c = new Course (COURSE_ID,"Object Oriented Programming","Giselle Ardy");
		
		List<Course> courses = ts.getTeacherCourses(TEST_EMAIL);
		assertTrue(courses.contains(c));
			
	}
	@Test
	void testStopTeach() {
		ts.addTeacher(testTeacher);
		ts.teachClass(TEST_EMAIL, COURSE_ID);
		
		ts.removeCourse(TEST_EMAIL, COURSE_ID);
		
		assertTrue(ts.getTeacherCourses(TEST_EMAIL).size() == 0);
		
		
	}
	@AfterEach
	void tearDown() {
		ts.removeTeacher(TEST_EMAIL);
		Teacher not = ts.getTeacherByEmail(TEST_EMAIL);
		assertNull(not);
	}
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		ts.endAll();
	}

}
