package hacs;

import java.text.DateFormat;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class AssignmentTest {
    hacs.Assignment assignment = new hacs.Assignment();
    hacs.Solution solution = new hacs.Solution();
    Date dueDate = new Date();
    @org.junit.jupiter.api.Test
    void setDueDate() {
        Date dueDateCheck = new Date();
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
        assignment.setDueDate(dueDate);
        assertEquals(dateFormat.format(dueDateCheck), assignment.getDueDateString());
    }

    @org.junit.jupiter.api.Test
    void setAssSpec() {
        String assSpecCheck = "assignment1";
        assignment.setAssSpec("assignment1");
        assertEquals(assSpecCheck, assignment.assSpec);
    }

    @org.junit.jupiter.api.Test
    void isOverDue() {
        assertTrue(assignment.isOverDue());
    }

    @org.junit.jupiter.api.Test
    void addSolution() {
        int expected = 1;
        assignment.addSolution(solution);
        assertEquals(expected, assignment.getSolutionList().size());
    }

    @org.junit.jupiter.api.Test
    void testAddSolution() {
        Solution solution = new Solution();
        assignment.addSolution(solution);
        assertTrue(assignment.theSolutionList.contains(solution));
    }

    @org.junit.jupiter.api.Test
    void getSolutionList() {
        assignment.addSolution(solution);
        int expected=1;
        SolutionList s = assignment.getSolutionList();
        assertEquals(expected, s.size());
    }

    @org.junit.jupiter.api.Test
    void getSolution() {
        assignment.getSugSolution();
    }

    @org.junit.jupiter.api.Test
    void getSugSolution() {
        assignment.getSugSolution();
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        assignment.assName = "AssignmentTest";
        assertEquals(assignment.toString(), "AssignmentTest");
    }

    @org.junit.jupiter.api.Test
    void getDueDateString() {
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
        assignment.dueDate = new Date();
        assertEquals(assignment.getDueDateString(), dateFormat.format(new Date()));
    }

}