package hacs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClassCourseListTest {

    hacs.ClassCourseList classCourseList = new hacs.ClassCourseList();

    @Test
    void initializeFromFile() {
    }

    @Test
    void findCourseByCourseName() {
        String courseName = "CSE470";
        classCourseList.initializeFromFile();
        assertEquals(courseName, classCourseList.findCourseByCourseName(courseName).toString());
    }
}