package hacs;

import java.util.Iterator;

/**
 * Title:        HACS
 * Description:  SER ICA8:  TestingIndividual
 * @author Diya Roshan Sanghvi
 * @version 2.0
 */

abstract public class Person {
	int type = 0; // type=0 : student, type=1 instructor
	String userName;
	ClassCourseList courseList;
	CourseMenu theCourseMenu;
	Course currentCourse;

	public Person() {
		courseList = new ClassCourseList();
	}

	abstract public CourseMenu createCourseMenu(Course theCourse, int theLevel);

	public void showAddButton() {
		theCourseMenu.showAddButtons();
	}

	public void showViewButtons() {
		theCourseMenu.showViewButtons();
	}

	public void showComboxes() {
		theCourseMenu.showComboBoxes();
	}

	public void showRadios() {
		theCourseMenu.showRadios();
	}

	public void show() {
		theCourseMenu.setVisible(true);
	}

	public boolean ifLogout() {
		return theCourseMenu.ifLogout();
	}

	public boolean showMenu() {
		Iterator<Assignment> theIter = currentCourse.assignmentList.iterator();
		theCourseMenu.theCourse = currentCourse;
		Assignment theAssignment;
		while (theIter.hasNext()) {
			theAssignment = theIter.next();
			theCourseMenu.assignmentComboBox.addItem(theAssignment);
		}
		return false;
	}

	public void addCourse(Course theCourse) {
		courseList.add(theCourse);
	}
}