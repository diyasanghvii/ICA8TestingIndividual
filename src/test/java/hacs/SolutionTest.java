package hacs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    hacs.Solution solution = new hacs.Solution();

    @Test
    void getGradeString() {
        String expected = "-1";
        assertEquals(expected, solution.getGradeString());
    }

    @Test
    void getGradeInt() {
        int expected = 0;
        assertEquals(expected, solution.getGradeInt());
    }

    @Test
    void setReported() {
        solution.setReported(true);
        assertTrue(solution.isReported());
    }

    @Test
    void isReported() {
        solution.setReported(true);
        assertTrue(solution.isReported());
    }
}