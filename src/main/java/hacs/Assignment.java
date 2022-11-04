package hacs;

/**
 * Title:        HACS
 * Description:  SER ICA8:  TestingIndividual
 * @author Diya Roshan Sanghvi
 * @version 2.0
 */

import java.util.Date;
import java.text.DateFormat;

public class Assignment {
  protected String assName;
  protected Date dueDate = new Date();
  protected String assSpec;
  protected SolutionList theSolutionList = new SolutionList();
  protected Solution suggestSolution = new Solution();

  public Assignment() {
  }

  public void setDueDate(Date theDueDate){
    this.dueDate = theDueDate;
  }

  public void setAssSpec(String theSpec){
    this.assSpec = theSpec;
  }

  public boolean isOverDue(){
    Date today;
    today = new Date();
    if (today.after(this.dueDate)) {
      return true;
    } else {
      return false;
    }
  }

  public Solution addSolution() {
    Solution mySolution = new Solution();
    return mySolution;
  }

  ////add the theSolution to the Solutionlist
  public void addSolution(Solution theSolution)
  {
    theSolutionList.add(theSolution);
  }

  public void submitSolution() {
  }

  public SolutionList getSolutionList() {
    return theSolutionList;
  }

  /* return the solution of the give name
  */
  public Solution getSolution(String studentName)
  {
    SolutionIterator iterator = (SolutionIterator)theSolutionList.iterator();
    return (Solution)iterator.next(studentName);
  }

  public Solution getSugSolution(){
    return suggestSolution;
  }

  public SolutionIterator getSolutionIterator() {
    SolutionIterator theSolutionIterator = new SolutionIterator(theSolutionList);
    return theSolutionIterator;
  }

  public String toString()
  {
    return assName;
  }

  public String getDueDateString()
  {
    DateFormat dateFormat=DateFormat.getDateInstance(DateFormat.SHORT);
    return  dateFormat.format(dueDate);
  }

  public void accept(NodeVisitor visitor)
  {
    visitor.visitAssignment(this);
  }
}