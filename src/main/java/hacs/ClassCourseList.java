package hacs;

import java.util.ArrayList;
import java.io.*;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author mjfindler
 * @version 2.0 update to Java 8
 */

public class ClassCourseList extends ArrayList<Course> {

	public ClassCourseList() {
	}
	//// initialize the list by reading from the file.
	void initializeFromFile(String theFileName) {
		try {
			BufferedReader file;
			String courseName = null;
			file = new BufferedReader(new FileReader("C:\\Users\\DIYA\\IdeaProjects\\ICA8TestingIndividual\\src\\main\\java\\hacs\\CourseInfo.txt"));
			while ((courseName = file.readLine()) != null) {
				Course theCourse;
				theCourse = new Course(courseName, 0);
				add(theCourse);
			}
		} catch (Exception ee) {
			/* Ignore ee */
		}
	}

	Course findCourseByCourseName(String CourseName) {
		int courseCount = size();
		for (int i = 0; i < courseCount; i++) {
			Course theCourse = get(i);
			if (theCourse.courseName.compareTo(CourseName) == 0)
				return theCourse;
		}
		return null;
	}

}