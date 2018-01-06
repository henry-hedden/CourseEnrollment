/*
 * Program:     Course Enrollment
 * Written by:  Henry Hedden
 * Challenges:  toString method, enums
 * Time Spent:  10 hrs
 * Given Input:               Expected Output:
 * --------------------       -------------------------
 * N/A                        "This is a template."
 *
 *
 *                   Revision History
 * Date:                   By:               Action:
 * ---------------------------------------------------
 * 2017-04-25              HH                Created
 * 2017-04-27              HH                Added classes: Person, Room, Teacher, Student, Course
 * 2017-05-02              HH                Created main method stub
 * 2017-05-06              HH                Added more complete Javadoc comments
 *
 * Filename: GUIClient.java
 * Created:  2017-05-07
 * Modified: 2017-05-07 19:16
 */
package courseenrollment;

import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 * Handles input and output via a Graphical User Interface (GUI).
 * @see Client
 * @author Henry Hedden
 */
public class GUIClient {
	
	/** User-entered student ID */
	static int id;
	/** User-entered password */
	static String passwd;
	
	/** A list of registered students, mapped by student ID */
	static HashMap<Integer, Student> students = new HashMap<>();
	/** The user currently logged in */
	static Student user;
	
	/** Option selected by user */
	static char option;
	
	/** A list of available courses. */
	static HashMap<String, Course> courses = new HashMap<>();
	
	/**
	 * This method has the same functionality as {@link Client#main(java.lang.String[])}, but  it
	 * uses {@link JOptionPane} for both input and output, instead of the command line.
	 * @param args the command line arguments (unused)
	 */
	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "STUDENT COURSE ENROLLMENT", "Course Enrollment",
				JOptionPane.OK_CANCEL_OPTION);
	}
	
	/**
	 * Tests if user-submitted login info is valid.
	 * @see Student#authenticate(java.lang.String) Student.authenticate
	 * @param id the user-submitted student ID
	 * @param passwd the user-submitted password
	 * @return <strong>true</strong> if and only if both username <em>and</em> password are valid.
	 */
	public static boolean login(int id, String passwd) {
		user = students.get(id);
		return user != null && user.authenticate(passwd);
	}
	
}
