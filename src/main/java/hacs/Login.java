package hacs;

import hacs.UserInfoItem.USER_TYPE;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.io.FileReader;
import java.io.BufferedReader;

/**
 * Title:        HACS
 * Description:  SER ICA8:  TestingIndividual
 * @author Diya Roshan Sanghvi
 * @version 2.0
 */

public class Login extends JDialog {
	private boolean mbExit = false;
	private final JLabel jLabel1 = new JLabel();
	private final JLabel jLabel2 = new JLabel();
	private final JButton loginButton = new JButton();
	private final JButton buttonExit = new JButton();
	private final JTextField userNameText = new JTextField();
	private final JPasswordField passwordText = new JPasswordField();
	private final JRadioButton studentRadio = new JRadioButton();
	private final JRadioButton instructorRadio = new JRadioButton();
	private final ButtonGroup buttonGroup1 = new ButtonGroup();
	private String userBox = null;
	private USER_TYPE userType = USER_TYPE.Student; // default to Student

	public Login() {
		try {
			jbInit();
			setSize(300, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() {
		this.getContentPane().setLayout(null);
		jLabel1.setText("UserName");
		jLabel1.setBounds(new Rectangle(26, 52, 80, 18));
		jLabel2.setText("Password");
		jLabel2.setBounds(new Rectangle(23, 119, 80, 18));
		loginButton.setText("Login");
		loginButton.setBounds(new Rectangle(31, 212, 85, 28));
		loginButton.addActionListener(this::loginButtonActionPerformed);
		buttonExit.setText("Exit");
		buttonExit.setBounds(new Rectangle(180, 211, 97, 28));
		buttonExit.addActionListener(this::buttonExitActionPerformed);
		userNameText.setBounds(new Rectangle(119, 52, 144, 22));
		passwordText.setBounds(new Rectangle(118, 119, 147, 22));
		studentRadio.setSelected(true);
		studentRadio.setText("Student");
		studentRadio.setBounds(new Rectangle(37, 164, 103, 26));
		instructorRadio.setText("Instructor");
		instructorRadio.setBounds(new Rectangle(177, 162, 103, 26));
		this.getContentPane().add(jLabel1, null);
		this.getContentPane().add(jLabel2, null);
		this.getContentPane().add(loginButton, null);
		this.getContentPane().add(buttonExit, null);
		this.getContentPane().add(userNameText, null);
		this.getContentPane().add(passwordText, null);
		this.getContentPane().add(studentRadio, null);
		this.getContentPane().add(instructorRadio, null);
		buttonGroup1.add(studentRadio);
		buttonGroup1.add(instructorRadio);
	}

	void loginButtonActionPerformed(ActionEvent e) {
		BufferedReader file;
		mbExit = false;
		System.out.println("login clicked");
		try {
			if (studentRadio.isSelected()) {
				userType = USER_TYPE.Student;
				file = new BufferedReader(new FileReader("C:\\Users\\DIYA\\IdeaProjects\\ICA8TestingIndividual\\src\\main\\java\\hacs\\StuInfo.txt"));
			} else {
				userType = USER_TYPE.Instructor;
				file = new BufferedReader(new FileReader("C:\\Users\\DIYA\\IdeaProjects\\ICA8TestingIndividual\\src\\main\\java\\hacs\\InsInfor.txt"));
			}
			userBox = userNameText.getText();
			String passwordBox = new String(passwordText.getPassword());
			String loginName = null;
			String aLine, userName, password;
			while ((aLine = file.readLine()) != null) {
				userName = getUserName(aLine);
				password = getPassword(aLine);
				if (userName.compareTo(userBox) == 0 && password.compareTo(passwordBox) == 0)
					loginName = userName;
			}
			if (loginName != null) {
				this.setVisible(false);
			}
		} catch (Exception ee) {
			/* Ignore ee. */
		}

	}

	/*
	 * get the user name from aline userName:Password
	 */
	private String getUserName(String aLine) {
		int sep = aLine.lastIndexOf(':');
		return aLine.substring(0, sep);
	}

	/*
	 * get the password from aLine userName:Password
	 */
	private String getPassword(String aLine) {
		int sep = aLine.lastIndexOf(':');
		return aLine.substring(sep + 1);
	}

	/* after login get the userName of the login interface */
	public String getUserName() {
		return userBox;
	}

	/* after login get the userType of the login interface */
	public USER_TYPE getUserType() {
		return userType;
	}

	public boolean isExit() {
		return mbExit;
	}

	void buttonExitActionPerformed(ActionEvent e) {
		mbExit = true;
		setVisible(false);
	}
}