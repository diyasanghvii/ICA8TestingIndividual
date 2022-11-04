package hacs;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Title:        HACS
 * Description:  SER ICA8:  TestingIndividual
 * @author Diya Roshan Sanghvi
 * @version 2.0
 */

public class Facade {
	public int userType;
	private Course theSelectedCourse = null;
	private int nCourseLevel = 0;
	ClassCourseList theCourseList;
	Person thePerson;

	public Facade() {
	}

	static public boolean Login(UserInfoItem userInfoItem) {
		Login login = new Login();
		login.setModal(true);
		login.setVisible(true);
		userInfoItem.strUserName = login.getUserName();
		userInfoItem.userType = login.getUserType();
		return login.isExit();
	}

	/*
	 * When click the add button of the CourseMenu , call this function this
	 * function will new an assignment fill the required infomation this function
	 * will call InstructorAssignmentMenu or StudentAssignmentMenu according to the
	 * type of the user it will not update the course menu. the coursemenu need to
	 * refreshed outside the function
	 */

	void addAssignment(Course theCourse) {
		AssignmentMenu theAssignmentMenu;
		if (thePerson.type == 0)
		{
			theAssignmentMenu = new StudentAssignmentMenu();
		} else {
			theAssignmentMenu = new InstructorAssignmentMenu();
		}
		Assignment theAssignment = new Assignment();
		theAssignmentMenu.showMenu(theAssignment, thePerson);
		theCourse.addAssignment(theAssignment);
	}

	/*
	 * When click the view button of the CourseMenu , call this function and pass
	 * the pointer of the Assignment and the person pointer to this function this
	 * function will new an assignment fill the required infomation this function
	 * will call InstructorAssignmentMenu or StudentAssignmentMenu according to the
	 * type of the user
	 */
	void viewAssignment(Assignment theAssignment) {
		AssignmentMenu theAssignmentMenu;
		if (thePerson.type == 0)
		{
			theAssignmentMenu = new StudentAssignmentMenu();
		} else {
			theAssignmentMenu = new InstructorAssignmentMenu();
		}
		theAssignmentMenu.showMenu(theAssignment, thePerson);
	}

	/*
	 * this function will grade the give Solution: theSolution this function calls
	 */

	void gradeSolution(Solution theSolution) {
		SolutionMenu solutionMenu = new SolutionMenu();
		solutionMenu.ShowMenu(theSolution);
	}

	void reportSolutions(Assignment theAssignment) {
		Solution theSolution;
		SolutionIterator theSolutionIterator;
		theSolutionIterator = theAssignment.getSolutionIterator();
		theSolution = (Solution) theSolutionIterator.next();
		while (theSolution != null) {
			theSolution.setReported(true);
			theSolution = (Solution) theSolutionIterator.next();
		}
	}

	void submitSolution(Assignment theAssignment, Solution theSolution) {
		theAssignment.addSolution(theSolution);
	}

	void remind() {
		Reminder theReminder = new Reminder();
		theReminder.showReminder(thePerson.getCourseList());
	}

	void createUser(UserInfoItem userinfoitem) {
		if (userinfoitem.userType == UserInfoItem.USER_TYPE.Student) /// student
		{
			thePerson = new Student();
		} else {
			thePerson = new Instructor();
		}
		thePerson.userName = userinfoitem.strUserName;
	}

	/*
	 * create a course list and intitialize it with the file CourseInfo.txt
	 */
	void createCourseList() {
		theCourseList = new ClassCourseList();
		theCourseList.initializeFromFile("C:\\Users\\DIYA\\IdeaProjects\\ICA8TestingIndividual\\src\\main\\java\\hacs\\CourseInfo.txt");
	}

	/*
	 * call this function after create user, create courselist read the
	 * UserCourse.txt file match the coursename with theCouresList attach the
	 * Matched course object to the new create user Facade.thePerson.courseList
	 */
	void attachCourseToUser() {
		BufferedReader file;
		try {
			file = new BufferedReader(new FileReader("C:\\Users\\DIYA\\IdeaProjects\\ICA8TestingIndividual\\src\\main\\java\\hacs\\UserCourse.txt"));
			String aLine, strUserName, strCourseName;
			while ((aLine = file.readLine()) != null)
			{
				strUserName = getUserName(aLine);
				strCourseName = getCourseName(aLine);
				if (strUserName.compareTo(thePerson.userName) == 0)
				{
					theSelectedCourse = findCourseByCourseName(strCourseName);
					if (theSelectedCourse != null)
					{
						thePerson.addCourse(theSelectedCourse);
					}
				}
			}
		} catch (Exception ee) {
			/* Ignore ee */
		}
	}

	/*
	 * get the user name from aline userName:courseName
	 */
	private String getUserName(String aLine) {
		int Sep = aLine.lastIndexOf(':');
		return aLine.substring(0, Sep);
	}

	/*
	 * get the courseName from aline userName:courseName
	 */
	private String getCourseName(String aLine) {
		int Sep = aLine.lastIndexOf(':');
		return aLine.substring(Sep + 1, aLine.length());
	}

	/*
	 * show the course selection dlg, show the course attatched to theperson and
	 * return the selected course and assign the course to the class member
	 * theSelectedCourse, the Course Level to courseLevel CourseLeve=0 High,
	 * CourseLeve=1 Low
	 */
	public boolean selectCourse() {
		CourseSelectDlg theDlg = new CourseSelectDlg();
		theSelectedCourse = theDlg.showDlg(thePerson.courseList);
		thePerson.currentCourse = theSelectedCourse;
		nCourseLevel = theDlg.nCourseLevel;
		return theDlg.isLogout();
	}

	/*
	 * call the thePerson.createCourseMenu according to the really object(student or
	 * instructor) and the nCourseLevel it will call different menu creater and show
	 * the menu;
	 */

	public boolean courseOperation() {
		thePerson.createCourseMenu(theSelectedCourse, nCourseLevel);
		return thePerson.showMenu();//// 0: logout 1 select an other course
	}

	/*
	 * find the course in theCourseList that matches strCourseName 1 create a
	 * CourseIterator for the List 2 Find the Course with the Iterator return the
	 * pointer of the Course if not fine, return null;
	 */
	private Course findCourseByCourseName(String strCourseName) {
		CourseIterator Iterator = new CourseIterator(theCourseList);
		return (Course) Iterator.next(strCourseName);
	}

}