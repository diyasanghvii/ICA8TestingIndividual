package hacs;

/**
 * Title:        HACS
 * Description:  SER ICA8:  TestingIndividual
 * @author Diya Roshan Sanghvi
 * @version 2.0
 */

public class Student extends Person {
	public Student() {
		type = 0;
	}

	public CourseMenu createCourseMenu(Course theCourse, int theLevel) {

		if (theLevel == 0) {
			theCourseMenu = new HighLevelCourseMenu();
		} else {
			theCourseMenu = new LowLevelCourseMenu();
		}
		return theCourseMenu;
	}

	@Override
	public boolean showMenu() {
		super.showMenu();
		showViewButtons();
		showComboxes();
		showRadios();
		show();
		return ifLogout();
	}
}