package hacs;

import java.util.ArrayList;

/**
 * Title:        HACS
 * Description:  SER ICA8:  TestingIndividual
 * @author Diya Roshan Sanghvi
 * @version 2.0
 */

public class Course {
  String courseName;
  public ArrayList<Assignment> assignmentList = new ArrayList<>();
  int numOfAss;
  int courseLevel;


  public Course(String course, int theLevel) {
    this.courseName = course;
    this.courseLevel = theLevel;
    this.numOfAss = 0;
  }
  
  public void addAssignment(Assignment newAss) {
    assignmentList.add(newAss);
  }
  
  public String toString() {
    return courseName;
  }
  
  void accept(NodeVisitor visitor) {
    visitor.visitCourse(this);
  }

}