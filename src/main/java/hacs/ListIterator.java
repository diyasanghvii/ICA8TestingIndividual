package hacs;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Title:        HACS
 * Description:  SER ICA8:  TestingIndividual
 * @author Diya Roshan Sanghvi
 * @version 2.0
 */

public class ListIterator implements Iterator<Object> {
	ArrayList<Object> theList;
	int currentNumber = -1;

	public ListIterator(ArrayList<Object> list) {
		theList = list;
	}

	public boolean hasNext() {
		return currentNumber < theList.size() - 1;
	}

	public Object next() {
		if (hasNext()) {
			currentNumber++;
			return theList.get(currentNumber);
		} else {
			return null;
		}
	}

	public void remove() {
		theList.remove(currentNumber);
	}
}