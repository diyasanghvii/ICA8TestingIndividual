package hacs;

import javax.swing.JDialog;

/**
 * Title:        HACS
 * Description:  SER ICA8:  TestingIndividual
 * @author Diya Roshan Sanghvi
 * @version 2.0
 */

abstract public class AssignmentMenu extends JDialog {
  abstract void showMenu(Assignment ass, Person per);
  public AssignmentMenu() {
    setModal(true);
    setSize(575,330);
  }
}