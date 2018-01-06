/*
 * Filename: Teacher.java
 * Created: 2017-04-25 20:36:07
 * Modified: 2017-05-12 23:24
 */
package courseenrollment;

/**
 * Represents a teacher, with a name and office.
 * @author Henry Hedden
 */
public class Teacher extends Person {

	/** An office (not a lecture hall) */
	public final Room office;
	
	/**
	 * Create a new Teacher, with a name and office.
	 * @param firstName The teacher's first name
	 * @param lastName The teacher's last name
	 * @param office The teacher's office
	 */
	public Teacher(String firstName, String lastName, Room office) {
		super(firstName, lastName);
		this.office = office;
	}
	
	/**
	 * Slightly modified version of the {@link Person#toString()} method.
	 * @return "Prof. [firstname] [lastname]"
	 */
	@Override
	public String toString() {
		return "Prof. " + super.toString();
	}
	
}
