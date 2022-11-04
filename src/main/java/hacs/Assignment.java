package hacs;

/*
  Title:        HACS
  Description:  SER ICA8:  TestingIndividual
  @author Diya Roshan Sanghvi
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
    return today.after(this.dueDate);
  }

  ////add the theSolution to the Solutionlist
  public void addSolution(Solution theSolution)
  {
    theSolutionList.add(theSolution);
  }

  public SolutionList getSolutionList() {
    return theSolutionList;
  }

  public void getSugSolution(){
  }

  public SolutionIterator getSolutionIterator() {
    return new SolutionIterator(theSolutionList);
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