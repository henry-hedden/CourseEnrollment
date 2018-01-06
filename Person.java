/*
 * filename: Person.java
 * Created: 2017-04-25 11:59:06
 * Modified: 2017-05-06
 */
package courseenrollment;

/**
 * Represents a person.
 * Extended by {@link Teacher} and {@link Student}.
 * @author Henry Hedden
 */
public class Person {
	
	/** A person's name */
	public final String firstName, lastName;
	
	/**
	 * Generic constructor used by both <code>Teacher</code> and <code>Student</code>.
	 * @param firstName The person's first name
	 * @param lastName The person's last name
	 */
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	/**
	 * Display the person as a string.
	 * @return Person's full name
	 */
	@Override
	public String toString() {
		return firstName + ' ' + lastName;
	}
	
}
