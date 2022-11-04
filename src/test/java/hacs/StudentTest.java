package hacs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    hacs.Student student = new hacs.Student();

    @Test
    void createCourseMenu() {
        hacs.CourseMenu courseMenu = student.createCourseMenu(new hacs.Course("CSE 564", 0), 0);
        assertTrue(courseMenu instanceof hacs.HighLevelCourseMenu);
    }

    @Test
    void showMenu() {
    }
}