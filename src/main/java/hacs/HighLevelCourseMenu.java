package hacs;

/**
 * Title:        HACS
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:      msu
 * @author Zhang ji Zhu Wei
 * @version 1.0
 */
import java.awt.*;
import java.awt.event.*;

public class HighLevelCourseMenu extends CourseMenu {

	/*
	 * JButton assignmentAddButton = new JButton(); JRadioButton optionRadio = new
	 * JRadioButton(); JComboBox optionCombo = new JComboBox(); JButton
	 * optionViewButton = new JButton(); JButton optionAddButton = new JButton();
	 */

	public HighLevelCourseMenu() {
	}

	void showMenu(Course theCourse) {
		showViewButtons();
		showRadios();
		showComboBoxes();
		show();
	}

	void showAddButtons() {
		assignmentAddButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				assignmentAddButtonActionPerformed(e);
			}
		});
		assignmentAddButton.setText("Add");
		assignmentAddButton.setBounds(new Rectangle(389, 54, 79, 29));
		optionAddButton.setText("Add");
		optionAddButton.setBounds(new Rectangle(390, 125, 79, 29));
		this.getContentPane().add(assignmentAddButton, null);
		this.getContentPane().add(optionAddButton, null);
	}

	void showRadios() {
		assignmentRadio.setText("Assignment");
		assignmentRadio.setBounds(new Rectangle(21, 55, 103, 26));
		this.getContentPane().add(assignmentRadio, null);
		optionRadio.setText("HighLevel Presentation");
		optionRadio.setBounds(new Rectangle(21, 128, 103, 26));
		this.getContentPane().add(optionRadio, null);
	}

	void showComboBoxes() {
		assignmentComboBox.setBounds(new Rectangle(140, 57, 126, 22));
		optionCombo.setBounds(new Rectangle(137, 127, 126, 22));
		this.getContentPane().add(assignmentComboBox, null);
		this.getContentPane().add(optionCombo, null);
		refresh();
	}

	void showViewButtons() {
		assignmentViewButton.setText("View");
		assignmentViewButton.setBounds(new Rectangle(290, 54, 79, 29));
		assignmentViewButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				assignmentViewButtonActionPerformed(e);
			}
		});
		optionViewButton.setText("View");
		optionViewButton.setBounds(new Rectangle(290, 124, 79, 29));
		this.getContentPane().add(assignmentViewButton, null);
		this.getContentPane().add(optionViewButton, null);
	}

	void showLabel() {
		assignmentContentLabel.setText("AssigmentContent");
		assignmentContentLabel.setBounds(new Rectangle(23, 186, 432, 99));
		this.getContentPane().add(assignmentContentLabel, null);
	}
}