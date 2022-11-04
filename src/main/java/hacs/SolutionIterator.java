package hacs;

import java.util.Iterator;

/**
 * Title:        HACS
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:      msu
 * @author Zhang ji Zhu Wei
 * @version 1.0
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
    if (hasNext())
    {
      currentSolutionNumber++;
      return solutionList.get(currentSolutionNumber);
    }
    else
    {
      return null;
    }
  }

  public Object next(String UserName) {
    Solution theSolution;
    theSolution=(Solution)next();
    while(theSolution!=null)
    {
      if(UserName.equals(theSolution.theAuthor))
      {
        return theSolution;
      }
      theSolution=(Solution)next();
    }
    return null;
  }

  public void remove() {
    solutionList.remove(currentSolutionNumber);
  }
}