package hacs;

import java.util.Iterator;

/**
 * Title:        HACS
 * Description:  SER ICA8:  TestingIndividual
 * @author Diya Roshan Sanghvi
 * @version 2.0
 */

public class CourseIterator implements Iterator
{
  ClassCourseList theCourseList;
  int currentCourseNumber =-1;


  public CourseIterator(ClassCourseList courseList) {
    theCourseList = courseList;
  }

  public boolean hasNext() {
    return currentCourseNumber < theCourseList.size() - 1;
  }

  public Object next() {
    if (hasNext()) {
      currentCourseNumber++;
      return theCourseList.get(currentCourseNumber);
    } else {
      return null;
    }
  }
  public void remove() {
    theCourseList.remove(currentCourseNumber);
  }

  public Object next(String courseName) {
    Course theCourse;
    theCourse = (Course)next();
    while(theCourse != null)
    {
      if(courseName.compareTo(theCourse.toString()) == 0)
      {
        return theCourse;
      }
      theCourse = (Course)next();
    }
    return null;
  }


}