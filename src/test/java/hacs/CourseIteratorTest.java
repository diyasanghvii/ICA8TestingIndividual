package hacs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseIteratorTest {

    @Test
    void hasNext() {
        ClassCourseList testCourseList = new ClassCourseList();
        Course course = new hacs.Course("SER515", 0);
        testCourseList.add(course);
        CourseIterator testCourseIter= new CourseIterator(testCourseList);
        assertTrue(testCourseIter.hasNext());
    }

    @Test
    void next() {
        ClassCourseList courseList = new ClassCourseList();
        Course course = new hacs.Course("SER501", 1);
        courseList.add(course);
        hacs.CourseIterator courseIterator = new hacs.CourseIterator(courseList);
        assertTrue(courseIterator.hasNext());
    }

    @Test
    void remove() {
        ClassCourseList courseList = new ClassCourseList();
        Course course = new hacs.Course("CSE563", 1);
        Course course2 = new hacs.Course("CSE564", 1);
        courseList.add(course);
        courseList.add(course2);
        CourseIterator testCourseIter = new CourseIterator(courseList);
        testCourseIter.next();
        testCourseIter.remove();
        assertFalse(testCourseIter.hasNext());
    }
}