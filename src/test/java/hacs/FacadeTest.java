package hacs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FacadeTest {
    hacs.Facade facade = new hacs.Facade();
    hacs.Assignment assignment = new hacs.Assignment();

    @Test
    void reportSolutions() {
        assignment.theSolutionList.add(new Solution());
        facade.reportSolutions(assignment);
        assertTrue(assignment.theSolutionList.get(0).reported);
    }

    @Test
    void submitSolution() {
        int expected = 1;
        hacs.Assignment theAssignment = new hacs.Assignment();
        hacs.Solution theSolution = new hacs.Solution();
        facade.submitSolution(theAssignment, theSolution);
        assertEquals(expected, theAssignment.getSolutionList().size());
    }

    @Test
    void createUser() {
        hacs.UserInfoItem userInfoItem = new hacs.UserInfoItem();
        userInfoItem.userType = hacs.UserInfoItem.USER_TYPE.Student;
        facade.createUser(userInfoItem);
        assertTrue(facade.thePerson instanceof hacs.Student);
    }

    @Test
    void createCourseList() {
        int expected = 3;
        facade.createCourseList();
        assertEquals(expected, facade.theCourseList.size());
    }

    @Test
    void attachCourseToUser() {
        facade.thePerson = new Student();
        facade.thePerson.userName = "mimi";
        facade.createCourseList();
        facade.attachCourseToUser();
        assertEquals(facade.thePerson.courseList.get(0).courseName, "CSE470");
    }

}