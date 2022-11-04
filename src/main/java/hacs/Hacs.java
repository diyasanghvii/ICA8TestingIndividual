package hacs;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author mjfindler
 * @version 2.0
 * 
 * Update to Java 8
 */

public class Hacs {

	static Facade theFacade = new Facade();

	public Hacs() {
	}

	public static void main(String[] args) {
		UserInfoItem userInfoItem = new UserInfoItem();
		theFacade.createCourseList();
		while(true) {
			boolean bExit;
			bExit = theFacade.Login(userInfoItem);
			if (bExit)
				break;
			theFacade.createUser(userInfoItem);
			theFacade.attachCourseToUser();
			if (userInfoItem.UserType == UserInfoItem.USER_TYPE.Student)
				theFacade.remind();
			boolean bLogout = false;
			while (!bLogout) {
				bLogout = theFacade.SelectCourse();
				if (bLogout)
					break;
				bLogout = theFacade.CourseOperation();
			}
		}
	}
}