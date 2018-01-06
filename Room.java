/*
 * Filename: Room.java
 * Created:  2017-04-25 20:38:04
 * Modified: 2017-04-27 22:11
 */
package courseenrollment;

/**
 * Represents a lecture hall or office.
 * Used by both {@link Teacher} and {@link Course}.
 * @author Henry Hedden
 */
public class Room {
	
	/** A building */
	public final String bldg;
	
	/** A room numer */
	public final int num;
	
	/**
	 * Instantiates a room with a building and number.
	 * @param bldg The building where the room is located
	 * @param num The room number
	 */
	public Room(String bldg, int num) {
		this.bldg = bldg;
		this.num = num;
	}
	
	/**
	 * Determines whether two objects represent the same room.
	 * Because the fields are public, this object does not need to call getter methods.
	 * @param r The other <code>Room</code> object to be compared
	 * @return <code>true</code> if rooms are identical, <code>false</code> otherwise
	 */
	public boolean equals(Room r) {
		return bldg.equals(r.bldg) && num == r.num;
	}
	
	/**
	 * Shows the name of the room.
	 * @return A String. Format: <code>[BLDG]-[NUMBER]</code>
	 */
	@Override
	public String toString() {
		return bldg + '-' + num;
	}
	
}
