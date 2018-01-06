/*
 * Program:     Course Enrollment
 * Written by:  Henry Hedden
 * Challenges:  toString method, enums
 * Time Spent:  10 hrs
 * Given Input:               Expected Output:
 * --------------------       -------------------------
 * [username] [password]      "Invalid username or password" / "Welcome, ____!"
 * a [course number]          "Course not found!" / "Enrolling in ____..."
 * d [course number]          "Course not found!" / "Dropping ____..."
 * l                          [list of all courses]
 * v [course number]          "Course not found!" / course #, dept, name, room
 * s                          "You have not signed up for any courses." / [list of enrolled courses]
 *
 *                   Revision History
 * Date:                   By:               Action:
 * ---------------------------------------------------
 * 2017-04-25              HH                Created
 * 2017-04-27              HH                Added classes: Person, Room, Teacher, Student, Course
 * 2017-05-02              HH                Created main method stub
 * 2017-05-06              HH                Added more complete Javadoc comments
 * 2017-05-08              HH                Allowed user to list courses and view schedule
 * 2017-05-08              HH                Allowed user to add and drop courses
 * 2017-05-09              HH                Minor updates before demo
 *
 * Filename: Client.java
 * Created:  2017-04-25
 * Modified: 2017-05-12 23:18
 */
package courseenrollment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Handles input and output, as well as the user interface.
 * @see GUIClient
 * @author Henry Hedden
 */
public class Client {
	
	/** An intruduction displayed immediately after the program starts */
	static final String BANNER = "STUDENT COURSE ENROLLMENT\n-------------------------\n";
	
	/** User-entered student ID */
	static int id;
	/** User-entered password */
	static String passwd;
	
	/** Gets input from the command line */
	static Scanner stdin = new Scanner(System.in);
	
	/** A list of registered students, mapped by student ID */
	static HashMap<Integer, Student> students = new HashMap<>();
	/** The user currently logged in */
	static Student user;
	
	/** Option selected by user */
	static char option;
	
	/** course selected for add/drop/description */
	static Course current;
	
	/** Main loop repeats as long as this is true */
	static boolean repeat = true;

	/**
	 * This method handles input and output via the command line.
	 * @param args the command line arguments (unused)
	 */
	public static void main(String[] args) {
		students.put(55555, new Student("John", "Smith", Department.CS, "P@55w0rd"));
		
		Database.createCourseList();
		
		System.out.println(BANNER);
		
		do {
			System.out.print("Enter Student ID: ");
			id = stdin.nextInt();
			System.out.print("Enter Password: ");
			passwd = stdin.next();
		} while(!login(id, passwd));
		
		do {
			System.out.println();
			System.out.println("What would you like to do?");
			System.out.println("1. [A]dd course");
			System.out.println("2. [D]rop course");
			System.out.println("3. [L]ist courses");
			System.out.println("4. [V]iew course description");
			System.out.println("5. View [S]chedule");
			System.out.println("6. [Q]uit");
			
			System.out.print("Enter an option: ");
			option = stdin.next().toUpperCase().charAt(0);
			switch(option) {
				case '1':
				case 'A':
					System.out.print("Select a course to enroll in: ");
					current = Database.courses.get(stdin.next().toUpperCase());
					if (current == null) {
						System.err.println("Course not found!");
						break;
					}
					System.out.println("Enrolling in " + current + "...");
					user.addCourse(current);
					break;
				case '2':
				case 'D':
					System.out.print("Select a course to drop: ");
					current = Database.courses.get(stdin.next().toUpperCase());
					if (current == null) {
						System.err.println("Course not found!");
						break;
					}
					System.out.println("Dropping " + current + "...");
					user.dropCourse(current);
					break;
				case '3':
				case 'L':
					listCourses();
					break;
				case '4':
				case 'V':
					System.out.print("Select a course to describe: ");
					current = Database.courses.get(stdin.next().toUpperCase());
					if (current == null)
						System.err.println("Course not found!");
					else
						System.out.printf("Course #: %s%nDepartment: %s%nName: %s%nRoom: %s%n"
								+ "Professor: %s%n", current, current.dept, current.name,
								current.hall, current.professor);
					break;
				case '5':
				case 'S':
					if (user.getSchedule().isEmpty()) {
						System.out.println("You have not signed up for any courses.");
						break;
					}
					System.out.println("Courses for" + user + " :");
					for (Course c: user.getSchedule())
						System.out.println("* " + c);
					break;
				case '6':
				case 'Q':
					System.out.print("Are you sure you want to quit? (Y/N) ");
					repeat = stdin.next().toUpperCase().charAt(0)!='Y';
					break;
				default:
					System.err.println("INVALID OPTION!");
			}
		} while (repeat);
		
		System.out.println("Goodbye, " + user + "!");
	}
	
	/**
	 * Tests if user-submitted login info is valid.
	 * Prints a statement notifying the user as to whether or not the login was successful.
	 * @see Student#authenticate(java.lang.String) Student.authenticate
	 * @param id the user-submitted student ID
	 * @param passwd the user-submitted password
	 * @return <strong>true</strong> if and only if both username <em>and</em> password are valid.
	 */
	public static boolean login(int id, String passwd) {
		user = students.get(id);
		boolean valid = user != null && user.authenticate(passwd);
		System.out.println(valid ? "Welcome, " + user + "!": "Invalid student ID or password!");
		return valid;
	}
	
	/**
	 * Displays a list of available courses as a bulleted list.
	 */
	public static void listCourses() {
		System.out.println("Available Courses:");
		for (String s: Database.courses.keySet())
			System.out.println("* " + s);
	}
	
}
