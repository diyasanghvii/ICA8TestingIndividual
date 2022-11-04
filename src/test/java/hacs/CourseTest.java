package hacs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CourseTest {
    int level = 1;
    String strCourse = "SER 501";
    hacs.Course course = new hacs.Course(strCourse, level);
    hacs.Assignment assignment = new hacs.Assignment();
    @Test
    void addAssignment() {
        course.addAssignment(assignment);
        assertTrue(course.assignmentList.contains(assignment));
    }

    @Test
    void testToString() {
        assertEquals(strCourse, course.toString());
    }
}