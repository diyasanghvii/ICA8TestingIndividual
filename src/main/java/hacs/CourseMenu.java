package hacs;

import javax.swing.JDialog;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.*;

/**
 * Title:        HACS
 * Description:  SER ICA8:  TestingIndividual
 * @author Diya Roshan Sanghvi
 * @version 2.0
 */

abstract public class CourseMenu extends JDialog {
  Course theCourse;
  boolean bLogout=true;
  JRadioButton assignmentRadio = new JRadioButton();
  JComboBox<Assignment> assignmentComboBox = new JComboBox<>();
  JButton assignmentViewButton = new JButton();
  JButton assignmentAddButton = new JButton();
  JRadioButton optionRadio = new JRadioButton();
  JComboBox optionCombo = new JComboBox();
  JButton optionViewButton = new JButton();
  JButton optionAddButton = new JButton();
  JButton buttonChangeCourse = new JButton();
  JButton buttonLogout = new JButton();

  public CourseMenu() {
    try {
      jbInit();
    } catch(Exception e) {
      e.printStackTrace();
    }
    setModal(true);
    setSize(503,294);
  }

  private void jbInit() {
    buttonChangeCourse.setText("ChangeCourse");
    buttonChangeCourse.setBounds(new Rectangle(101, 211, 73, 37));
    buttonChangeCourse.addActionListener(this::buttonChangeCourseActionPerformed);
    this.getContentPane().setLayout(null);
    this.setTitle("");
    buttonLogout.setText("Logout");
    buttonLogout.setBounds(new Rectangle(267, 215, 73, 37));
    buttonLogout.addActionListener(this::buttonLogoutActionPerformed);
    this.getContentPane().add(buttonChangeCourse, null);
    this.getContentPane().add(buttonLogout, null);
  }

  /* when the add button is pressed, call add assignment
  function of facade, after that refresh window
  */

  /* when the add button is pressed, call viewAssignment
  function of facade, after that refresh window
  */

  abstract void showAddButtons();
  abstract void showViewButtons();
  abstract void showRadios();
  abstract void showComboBoxes();

  void assignmentAddButtonActionPerformed(ActionEvent ignoredE) {
    Hacs.theFacade.addAssignment(theCourse);
    refresh();
  }

  void assignmentViewButtonActionPerformed(ActionEvent ignoredE) {
    Assignment theAssignment = (Assignment)assignmentComboBox.getSelectedItem();
    Hacs.theFacade.viewAssignment(theAssignment);
  }

  void refresh() {
    assignmentComboBox.removeAllItems();
    for (Assignment assignment : theCourse.assignmentList) {
      assignmentComboBox.addItem(assignment);
    }
  }

  void buttonChangeCourseActionPerformed(ActionEvent e) {
    bLogout=false;
    setVisible(false);
  }

  void buttonLogoutActionPerformed(ActionEvent e) {
    bLogout=true;
    setVisible(false);
  }

  boolean ifLogout() {
    return bLogout;
  }
}