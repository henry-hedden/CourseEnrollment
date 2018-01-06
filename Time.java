/*
 * Filename: Time.java
 * Created:  2017-04-27 22:14:18
 * Modified: 2017-04-28 01:24
 */
package courseenrollment;

/**
 * Represents a time of day, in 24 hours.
 * Used by {@link Teacher} and {@link Course}.
 * @author Henry Hedden
 */
public class Time {
	
	final int hours, minutes;
	
	/**
	 * Instantiates a new time.
	 * @param hours (0-23)
	 * @param minutes (0-59)
	 */
	public Time(int hours, int minutes) {
		this.hours = hours;
		this.minutes = minutes;
	}
	
	/**
	 * Tests whether two <code>Time</code> objects represent the same time.
	 * @param t Object to be compared
	 * @return <code>True</code> if both fields match, else <code>false</code>
	 */
	public boolean equals(Time t) {
		return this.hours == t.hours && this.minutes == t.minutes;
	}
	
	/**
	 * Determines whether another <code>Time</code> object is before or after this.
	 * @param t The other <code>Time</code> object
	 * @return -1 if t is after this time, +1 if it is before this time, 0 if they are equal
	 */
	public int compareTo(Time t) {
		if (hours < t.hours)
			return -1;
		if (hours > t.hours)
			return 1;
		if (minutes < t.minutes)
			return -1;
		if (minutes > t.minutes)
			return 1;
		return 0;
	}
	
	/**
	 * Displays the time.
	 * @return format: <code>HH:MM</code> (24hr)
	 */
	@Override
	public String toString() {
		return String.format("%02d:%02d", hours, minutes);
	}
	
}
