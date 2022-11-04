package hacs;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ListIteratorTest {

    @Test
    void hasNext() {
        ArrayList<Object> testList = new ArrayList<>();
        testList.add(6);
        hacs.ListIterator listIterator = new hacs.ListIterator(testList);
        assertTrue(listIterator.hasNext());
    }

    @Test
    void next() {
        ArrayList<Object> testList = new ArrayList<>();
        testList.add(79);
        hacs.ListIterator listIterator = new hacs.ListIterator(testList);
        assertNotNull(listIterator.next());
    }

    @Test
    void remove() {
    }
}