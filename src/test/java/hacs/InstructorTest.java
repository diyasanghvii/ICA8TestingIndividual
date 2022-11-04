package hacs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InstructorTest {

    hacs.Instructor instructor = new hacs.Instructor();

    @Test
    void createCourseMenu() {
        hacs.CourseMenu courseMenu = instructor.createCourseMenu(new hacs.Course("CSE 564", 0), 0);
        assertTrue(courseMenu instanceof hacs.HighLevelCourseMenu);
    }

    @Test
    void showMenu() {
        int expected = 1;
        assertEquals(expected, instructor.type);
    }
}