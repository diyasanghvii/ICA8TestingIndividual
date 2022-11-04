package hacs;

import java.util.Iterator;

/**
 * Title:        HACS
 * Description:  SER ICA8:  TestingIndividual
 * @author Diya Roshan Sanghvi
 * @version 2.0
 */
public class SolutionIterator implements Iterator
{
  SolutionList solutionList;
  int currentSolutionNumber = -1;

  public SolutionIterator() {
  }
  public SolutionIterator(SolutionList theSolutionList) {
    solutionList = theSolutionList;
    moveToHead();
  }
  public int getCurrentSolutionNumber() {
    return currentSolutionNumber;
  }

  public void moveToHead() {
    currentSolutionNumber =-1;
  }

  public boolean hasNext() {
    if (currentSolutionNumber >= solutionList.size()-1)
      return false;
    else
      return true;
  }
  public Object next() {
    if (hasNext()) {
      currentSolutionNumber++;
      return solutionList.get(currentSolutionNumber);
    } else {
      return null;
    }
  }

  public Object next(String userName) {
    Solution theSolution;
    theSolution = (Solution)next();
    while(theSolution != null) {
      if(userName.equals(theSolution.theAuthor)) {
        return theSolution;
      }
      theSolution = (Solution)next();
    }
    return null;
  }

  public void remove() {
    solutionList.remove(currentSolutionNumber);
  }
}