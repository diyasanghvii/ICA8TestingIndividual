package hacs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SolutionIteratorTest {

    hacs.SolutionList solutionList = new hacs.SolutionList();
    hacs.Solution solution = new hacs.Solution();

    @Test
    void getCurrentSolutionNumber() {
    }

    @Test
    void moveToHead() {
        int expected = -1;
        solutionList.add(solution);
        hacs.SolutionIterator solutionIterator = new hacs.SolutionIterator(solutionList);
        solutionIterator.moveToHead();
        assertEquals(expected, solutionIterator.getCurrentSolutionNumber());
    }

    @Test
    void hasNext() {
        solutionList.add(solution);
        hacs.SolutionIterator solutionIterator = new hacs.SolutionIterator(solutionList);
        assertTrue(solutionIterator.hasNext());
    }

    @Test
    void next() {
        solutionList.add(solution);
        hacs.SolutionIterator solutionIterator = new hacs.SolutionIterator(solutionList);
        assertNotNull(solutionIterator.next());
    }

    @Test
    void testNext() {
        SolutionList list = new SolutionList();
        SolutionIterator itr = new SolutionIterator(list);
        assertNull(itr.next());
    }

    @Test
    void remove() {
        SolutionList list = new SolutionList();
        Solution sol = new Solution();
        list.add(sol);
        list.add(sol);
        SolutionIterator itr = new SolutionIterator(list);
        itr.next();
        itr.remove();
        assertEquals(0,itr.getCurrentSolutionNumber());
    }
}