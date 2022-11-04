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
        classCourseList.initializeFromFile("C:\\Users\\DIYA\\IdeaProjects\\ICA8TestingIndividual\\src\\main\\java\\hacs\\CourseInfo.txt");
        assertEquals(courseName, classCourseList.findCourseByCourseName(courseName).toString());
    }
}