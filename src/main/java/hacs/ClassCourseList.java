package hacs;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Title:        HACS
 * Description:  SER ICA8:  TestingIndividual
 * @author Diya Roshan Sanghvi
 * @version 2.0
 */

public class ClassCourseList extends ArrayList<Course> {

	public ClassCourseList() {
	}
	//// initialize the list by reading from the file.
	void initializeFromFile() {
		try {
			BufferedReader file;
			String courseName;
			file = new BufferedReader(new FileReader("C:\\Users\\DIYA\\IdeaProjects\\ICA8TestingIndividual\\src\\main\\java\\hacs\\CourseInfo.txt"));
			while ((courseName = file.readLine()) != null) {
				Course theCourse;
				theCourse = new Course(courseName, 0);
				add(theCourse);
			}
		} catch (Exception ee) {
			/* IGNORE EXCEPTION ee */
		}
	}

	Course findCourseByCourseName(String CourseName) {
		for (Course theCourse : this) {
			if (theCourse.courseName.compareTo(CourseName) == 0)
				return theCourse;
		}
		return null;
	}

}