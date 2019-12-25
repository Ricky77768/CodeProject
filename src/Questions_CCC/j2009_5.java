package Questions_CCC;

import java.util.*;
public class j2009_5 {
	
	public static void main (String args[]) {
		Scanner reader = new Scanner(System.in);
		int n1, n2;
		String input;
		
		// Used specifically in "f" and "s" function
		ArrayList<Integer> duplicates = new ArrayList<Integer>();
		ArrayList<Integer> listOld = new ArrayList<Integer>();
		ArrayList<Integer> listNew = new ArrayList<Integer>();
		int range = 0;
		boolean directFriends = false;
		
		// Initialization
		j2009_5_User[] user = new j2009_5_User[50];
		
		for (int i = 1; i < 19; i++) {
			user[i] = new j2009_5_User(i);
		}
		
		// Adding existing friendships
		user[1].addFriendship(user[6]);
		user[2].addFriendship(user[6]);
		user[3].addFriendship(user[4]);
		user[3].addFriendship(user[5]);
		user[3].addFriendship(user[6]);
		user[3].addFriendship(user[15]);
		user[4].addFriendship(user[5]);
		user[4].addFriendship(user[6]);
		user[5].addFriendship(user[6]);
		user[6].addFriendship(user[7]);
		user[7].addFriendship(user[8]);
		user[8].addFriendship(user[9]);
		user[9].addFriendship(user[10]);
		user[9].addFriendship(user[12]);
		user[10].addFriendship(user[11]);
		user[11].addFriendship(user[12]);
		user[12].addFriendship(user[13]);
		user[13].addFriendship(user[14]);
		user[13].addFriendship(user[15]);
		user[16].addFriendship(user[17]);
		user[16].addFriendship(user[18]);
		user[17].addFriendship(user[18]);

		// Main Function
		while (true) {
			input = reader.next();
			
			// Add Friendship
			if (input.equals("i")) {
				n1 = reader.nextInt();
				n2 = reader.nextInt();
				
				if (user[n1] == null) {
					user[n1] = new j2009_5_User(n1);
					System.out.println("*** User " + n1 + " is created ***");
				}
				
				if (user[n2] == null) {
					user[n2] = new j2009_5_User(n2);
					System.out.println("*** User " + n2 + " is created ***");
				}
				
				if (!user[n1].hasFriendship(user[n2])) {
					user[n1].addFriendship(user[n2]);
					System.out.println("Friendship between " + n1 + " and " + n2 + " established");
				}
				else {
					System.out.println("Friendship between " + n1 + " and " + n2 + " already exists");
				}
			}
			
			// Delete Friendship
			if (input.equals("d")) {
				n1 = reader.nextInt();
				n2 = reader.nextInt();
				
				if (user[n1].hasFriendship(user[n2])) {
					user[n1].deleteFriendship(user[n2]);
					System.out.println("Friendship between " + n1 + " and " + n2 + " deleted");
				}
				else {
					System.out.println("Friendship between " + n1 + " and " + n2 + " does not exist");
				}
			}
			
			// Find how many friend(s) this user has
			if (input.equals("n")) {
				n1 = reader.nextInt();
				System.out.println("User " + n1 + " has " + user[n1].getFriendList().size() + " friends");
			}
			
			// Find how many friends of friends this user has
			if (input.equals("f")) {
				n1 = reader.nextInt();
				listOld.addAll(user[n1].getFriendList());
				
				// Add elements that should be removed because they are direct friends
				duplicates.add(n1);
				duplicates.addAll(listOld);
				
				// Find all friends of friends (with duplicates)
				for (int i = 0; i < listOld.size(); i++) {
					listNew.addAll(user[listOld.get(i)].getFriendList());
				}
			
				listNew = j2009_5_User.clearDuplicates(listNew, duplicates);
				System.out.println("User " + n1 + " has " + listNew.size() + " friends of friends");

				// Clear all related array lists for next function
				listOld.clear();
				listNew.clear();
				duplicates.clear();
			}
			
			// Find degree of separation between two friends
			if (input.equals("s")) {
				n1 = reader.nextInt();
				n2 = reader.nextInt();
				listOld.addAll(user[n1].getFriendList());
				duplicates.add(n1);
				duplicates.addAll(listOld);
				
				// Check if they are direct friends
				if (listOld.contains(n2)) {
					System.out.println("Degree of separation between " + n1 + " and " + n2 + " is " + "1");
					directFriends = true;
				}
				else {
					directFriends = false;
					range = 2;
				}
				
				while (directFriends == false) {

					// Find all friends of friends (with duplicates)
					for (int i = 0; i < listOld.size(); i++) {
						listNew.addAll(user[listOld.get(i)].getFriendList());
					}
					
					listNew = j2009_5_User.clearDuplicates(listNew, duplicates);
					
					// Check if the friends of friends has the target friend
					if (listNew.contains(n2)) {
						System.out.println("Degree of separation between " + n1 + " and " + n2 + " is " + range);
						break;
					}
					else {
						// Updating the array lists for new round of friends of friends checking 
						range++;
						duplicates.addAll(listNew);
						listOld.addAll(listNew);
					}
					
					// Since maximum degree of separation is 48, anything above it means they are not connected
					if (range > 48) {
						System.out.println("User " + n1 + " and " + n2 + " are not connected");
						break;
					}
				}
				
				// Clear all related array lists/variables for next function
				listOld.clear();
				listNew.clear();
				duplicates.clear();	
			}
			
			// Extra - Print all friendships
			if (input.equals("p")) {
				for (int i = 1; i < 50; i++) {
					if (user[i] == null) {
						System.out.println("User" + " " + i + ": ***NULL***");
					}
					else {
						System.out.println("User" + " " + i + ": " + user[i].getFriendList());
					}
				}
			}
			
			// Quitting
			if (input.equals("q")) {
				break;
			}
		}		
		reader.close();
	}	
}
		
