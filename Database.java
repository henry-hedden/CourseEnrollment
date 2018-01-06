/*
 * Filename: Database.java
 * Created:  2017-05-09 12:57:33 
 * Modified: 2017-05-12
 */
package courseenrollment;

import java.util.ArrayList;
import java.util.Random;
import java.util.HashMap;

/**
 * A collection of all the information about students, teachers, courses, and rooms.
 * @see Client
 * @see GUIClient
 * @author Henry Hedden
 */
public class Database {
	
	/** A list of registered students, mapped by student ID */
	static HashMap<Integer, Student> students = new HashMap<>();
	/** The user currently logged in */
	static Student user;
	
	/** A list of available courses */
	static HashMap<String, Course> courses = new HashMap<>();
	/** A list of classrooms */
	static Room[] rooms = {
		new Room("Stein", 173),
		new Room("Smith", 426),
		new Room("Library", 49),
		new Room("Smith", 55),
		new Room("Smith", 96),
		new Room("Stein", 87),
		new Room("Stein", 682),
		new Room("Stein", 701)
	};
	
	/** Used to randomize data */
	static Random randGen = new Random();
	
	static Teacher[] professors = {
		new Teacher("Daniel", "Schiller", rooms[randGen.nextInt(rooms.length)]),
		new Teacher("William", "Goethe", rooms[randGen.nextInt(rooms.length)]),
		new Teacher("Fredrick", "Helmholz", rooms[randGen.nextInt(rooms.length)]),
		new Teacher("Joseph", "Ernst", rooms[randGen.nextInt(rooms.length)]),
		new Teacher("Peter", "Blum", rooms[randGen.nextInt(rooms.length)]),
		new Teacher("Helmut", "Kohl", rooms[randGen.nextInt(rooms.length)])
	};
	
	/**
	 * Randomly generates a list of courses
	 */
	public static void createCourseList() {
		for (int i=0; i<10; i++) {
			Department dept = Department.values()[randGen.nextInt(10) + 1];
			int num = randGen.nextInt(500) + 100;
			String level;
			
			switch (num % 100 / 10) {
				case 0:
				case 1:
				case 2:
					level = "Basic";
					break;
				case 3:
				case 4:
				case 5:
				case 6:
					level = "Intermediate";
					break;
				default:
					level = "Advanced";
			}
			
			Course c = new Course(dept, num, String.format("%s %s %d", level, dept, num / 100),
					rooms[rooms.length-1], professors[randGen.nextInt(professors.length)]);
			courses.put(c.toString(), c);
		}
	}
	
}
