package Questions_CCC;

import java.util.*;
public class j2009_5_User {
	
	private int id;
	private ArrayList<Integer> friendList = new ArrayList<Integer>();
	
	public j2009_5_User(int number) {
		id = number;
	}
	
	public int getID() {
		return id;
	}
	
	public ArrayList<Integer> getFriendList() {
		return friendList;
	}
	
	public void addFriendship(j2009_5_User other) {
		this.friendList.add(other.getID());
		other.getFriendList().add(this.id);
	}
	
	
	
	public void deleteFriendship(j2009_5_User other) {
		
		for (int i = 0; i < friendList.size(); i++) {
			if (friendList.get(i) == other.getID()) {
				friendList.remove(i);
			}
		}
		
		for (int i = 0; i < other.getFriendList().size(); i++) {
			if (other.getFriendList().get(i) == id) {
				other.getFriendList().remove(i);
			}
		}
	}
	
	public boolean hasFriendship(j2009_5_User other)
	{
		if (friendList.contains(other.getID())) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static ArrayList<Integer> clearDuplicates(ArrayList<Integer> input, ArrayList<Integer> dupes) {
		
		// For potential duplicated elements not in the oldList
		ArrayList<Integer> extraDupes = new ArrayList<Integer>();
		
		for (int i = 0; i < input.size(); i++) {
			if (dupes.contains(input.get(i)) || extraDupes.contains(input.get(i))) {
				input.remove(i);
				i--;
			}
			else {
				extraDupes.add(input.get(i));
			}
		}
		return input;
	}
}
