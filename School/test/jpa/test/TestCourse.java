package jpa.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import jpa.service.CourseService;

class TestCourse {
	private static Course testCourse;
	private static CourseService cs;

	private final static String COURSE_NAME = "JAVA";
	private final static String INSTRUCTOR = "JOE";
	private final static Integer COURSE_ID = 100;
	

	@BeforeAll
	static void setUp() {
		testCourse = new Course();
		cs = new CourseService();
	}



	@Test
	void testAddnGetAll() {
		testCourse.setcId(COURSE_ID);
		testCourse.setcName(COURSE_NAME);
		testCourse.setcInstructor(INSTRUCTOR);
		
		cs.addCourse(COURSE_ID, COURSE_NAME, INSTRUCTOR);
		
		List<Course> courses = cs.getAllCourses();
		
		assertTrue(courses.contains(testCourse));
	}
	@Test
	void testGetStudents() {
		Student s = new Student("aiannitti7@is.gd","Alexandra Iannitti","TWP4hf5j");
		Integer course = 2;
		
		Student s1 = cs.getStudents(course).get(0);
		assertEquals(s,s1);
	}
	@AfterAll
	static void tearDown()  {
		cs.removeCourse(COURSE_ID);
		List<Course> courses = cs.getAllCourses();
		
		assertFalse(courses.contains(testCourse));

		cs.endAll();
	}

}
