package hacs;

/**
 * Title:        HACS
 * Description:  SER ICA8:  TestingIndividual
 * @author Diya Roshan Sanghvi
 * @version 2.0
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
			if (userInfoItem.userType == UserInfoItem.USER_TYPE.Student)
				theFacade.remind();
			boolean bLogout = false;
			while (!bLogout) {
				bLogout = theFacade.selectCourse();
				if (bLogout)
					break;
				bLogout = theFacade.courseOperation();
			}
		}
	}
}