/*
 * Filename: Course.java
 * Created:  2017-04-27 13:04:28
 * Modified: 2017-05-08
 */
package courseenrollment;

/**
 * Represents a course for students to take.
 * @author Henry Hedden
 */
public class Course {
	
	/** A department, or "school" */
	public final Department dept;
	/** A course number */
	public final int num;
	/** A course name */
	public final String name;
	/** A room */
	public final Room hall;
	/** A teacher */
	public final Teacher professor;
	
	/**
	 * Initializes a course.
	 * @param dept Any <code>Department</code> value except {@link Department#UNDECLARED}
	 * @param num The course number
	 * @param name The course name
	 * @param hall The lecture hall
	 */
	public Course(Department dept, int num, String name, Room hall, Teacher professor) {
		this.dept = dept;
		this.num = num;
		this.name = name;
		this.hall = hall;
		this.professor = professor;
	}
	
	/**
	 * Displays the course.
	 * Format: <code>[DEPT]-[NUM] "[COURSE NAME]"</code>
	 * @return String representing the course
	 */
	@Override
	public String toString() {
		return String.format("%s-%03d", dept.name(), num);
	}
	
	/**
	 * Tests whether this course is identical to another course.
	 * @param c another course
	 * @return <strong>true</strong> if and only if both departments and course numbers match,
	 * otherwise <strong>false</strong>
	 */
	public boolean equals(Course c) {
		return dept.equals(c.dept) && num == c.num;
	}
	
}
