/*
 * Filename: Student.java
 * Created: 2017-04-27 12:21:50
 * Modified: 2017-05-08
 */
package courseenrollment;

import java.util.ArrayList;

/**
 * Represents a student, with a name, major, and login info.
 * @author Henry Hedden
 */
public class Student extends Person {
	
	/** A student's major */
	private Department major;
	/** A password */
	private final String PASSWD;
	
	private ArrayList<Course> schedule;
	
	/**
	 * Initializes student with specified major.
	 * @param firstName Student's first name
	 * @param lastName Student's last name
	 * @param major Any <code>Department</code> value
	 * @param PASSWD Student's password
	 */
	public Student(String firstName, String lastName, Department major, String PASSWD) {
		super(firstName, lastName);
		this.major = major;
		this.PASSWD = PASSWD;
		schedule = new ArrayList<>();
	}
	
	/**
	 * Initializes student without major.
	 * Sets the major to {@link Department#UNDECLARED} by default.
	 * @param firstName Student's first name
	 * @param lastName Student's last name
	 * @param PASSWD Student's password
	 */
	public Student(String firstName, String lastName, String PASSWD) {
		super(firstName, lastName);
		this.major = Department.UNDECLARED;
		this.PASSWD = PASSWD;
		schedule = new ArrayList<>();
	}
	
	/**
	 * Setter method for major.
	 * For a student with no major, or a student who wants to change majors.
	 * @param major The student's new major
	 */
	public void setMajor(Department major) {
		this.major = major;
	}
	
	/**
	 * Getter method for major.
	 * @return The student's current major
	 */
	public Department getMajor() {
		return major;
	}
	
	/**
	 * Determines whether login info is correct.
	 * (Password is hidden from the rest of the program.)
	 * @see Client#login(int, java.lang.String) Client.login
	 * @see GUIClient#login(int, java.lang.String) GUIClient.login
	 * @param passwd User-entered password
	 * @return boolean indicating whether submitted login info is correct.
	 */
	public boolean authenticate(String passwd) {
		return PASSWD.equals(passwd);
	}
	
	/**
	 * Adds a course to the student's schedule.
	 * Does nothing if the student has already enrolled in the course.
	 * @param c The new course
	 */
	public void addCourse(Course c) {
		if (!schedule.contains(c))
			schedule.add(c);
	}
	
	/**
	 * Removes a course from the student's schedule.
	 * Does nothing if the student is not enrolled in the course.
	 * @param c The course to be dropped
	 */
	public void dropCourse(Course c) {
		schedule.remove(c);
	}
	
	/**
	 * Gets the student's current schedule.
	 * @return An ArrayList of <code>Course</code> objects
	 */
	public ArrayList<Course> getSchedule() {
		return schedule;
	}
	
}
