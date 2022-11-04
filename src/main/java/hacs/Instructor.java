package hacs;

/**
 * Title:        HACS
 * Description:  SER ICA8:  TestingIndividual
 * @author Diya Roshan Sanghvi
 * @version 2.0
 */

public class Instructor extends Person {
	public Instructor() {
		type = 1;
	}

	public CourseMenu createCourseMenu(Course theCourse, int theLevel) {
		if (theLevel == 0)
		{
			theCourseMenu = new HighLevelCourseMenu();
		} else
		{
			theCourseMenu = new LowLevelCourseMenu();
		}
		return theCourseMenu;
	}

	public boolean showMenu() {
		super.showMenu();
		showAddButton();
		showViewButtons();
		showComboxes();
		showRadios();
		show();
		return ifLogout();
	}
}