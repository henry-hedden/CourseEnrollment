/*
 * Filename: Department.java
 * Created: 2017-04-27 12:18:05
 * Modified: 2017-05-06
 */
package courseenrollment;

/**
 * Represents all possible departments.
 * Used by {@link Student} to represent major,
 * and by {@link Course} to represent school.
 * 
 * <p>The value {@link #UNDECLARED} is only to be used by the <code>Student</code> class,
 * and not by the <code>Course</code> class, as every course must have a defined department.
 * 
 * @author Henry Hedden
 */
public enum Department {
	
	/** (No major) */
	UNDECLARED,
	
	/** Education */
	EDU,
	
	/** Biology */
	BIO,
	
	/** Computer Science */
	CS,
	
	/** Information Technology */
	IT,
	
	/** Mathematics */
	MAT,
	
	/** Medicine */
	MED,
	
	/** Art */
	ART,
	
	/** Sociology */
	SOC,
	
	/** French */
	FR,
	
	/** German */
	DE;
	
	/**
	 * Represents the department with a descriptive name.
	 * @return The name of the department
	 */
	@Override
	public String toString() {
		switch (this) {
			case EDU:
				return "Education";
			case BIO:
				return "Biology";
			case CS:
				return "Computer Science";
			case IT:
				return "Information Technology";
			case MAT:
				return "Mathematics";
			case MED:
				return "Medicine";
			case ART:
				return "Art";
			case SOC:
				return "Sociology";
			case FR:
				return "French";
			case DE:
				return "German";
			case UNDECLARED:
			default:
				return "Undeclared";
		}
	}

}
