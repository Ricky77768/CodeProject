package Questions_CCC;
import java.util.Scanner;

/**
 * Assumed Completion (10/15 on CCC, but checked many cases and they all seem to be correct)
 */

public class s2018_3_assumedCompletion {
	
	public static void main(String[] args) {

		// Initializes the maze/array
		Scanner reader = new Scanner(System.in);
		String room_spec;
		int n = reader.nextInt();
		int m = reader.nextInt();
		char[][] room = new char[n][m];
		int[][] final_answer = new int[n][m];
	
		// Asks user for input
		for (int i = 0; i < n; i++) {
			if (i == 0) {
				reader.nextLine();
			}
			room_spec = reader.nextLine();
	
			for (int i2 = 0; i2 < m; i2++) {
				room[i][i2] = room_spec.charAt(i2);
			}
		}
		
		// Scans for the starting coordinate 
		int input_start_c = 0;
		int input_start_r = 0;
		for (int i = 0; i < n; i++) {
			for (int i2 = 0; i2 < m; i2++) {
				if (room[i][i2] == 'S') {
					input_start_c = i;
					input_start_r = i2;
					break;
				}
			}
		}
		
		// Invokes camera update method, denoting which elements can also not be moved to	
		room = update_room(room);
		
		// Invokes path finding method if the starting position cannot be detected by camera		
		if (room[input_start_c][input_start_r] != 'X') {
			final_answer = find_path(room, input_start_c, input_start_r);
		}

		// Prints out final answer, adjusted depending on settings (Start is 1, default is 0, -1 is impossible)
		for (int i = 0; i < n; i++) {
			for (int i2 = 0; i2 < m; i2++) {
				if (final_answer[i][i2] > 1) {
					System.out.println(final_answer[i][i2] - 1);
				}
				else if (final_answer[i][i2] == 0) {
					if (room[i][i2] != 'W' && room[i][i2] != 'U' && room[i][i2] != 'D' && room[i][i2] != 'L' && room[i][i2] != 'R' && room[i][i2] != 'C')
					System.out.println("-1");	
				}
			}
		}
		reader.close();
	}	
	
	/*
	 * @variable | u_room is the same 2D array, copied from previous array "room"
	 * 
	 * @function | Create a 2D boolean array of same size. Use a variable to check what elements can
	 * 			 | be detected by cameras. Then, it will transfer those elements into the character
	 * 			 | array (denoted 'X' to distinguish differences when outputting final answer)
	 * 
	 * @output   | A updated 2D character array which contains elements that the robot can not to go
	 * 			 | as it will be detected by cameras 
	 */
	public static char[][] update_room (char[][] u_room) {
		
		// Integer used to check how far the camera can reach (until it hits a wall)
		int increment;
		
		// Creates empty boolean to track what spots are needed to become walls (not passable)
		boolean[][] update = new boolean[u_room.length][u_room[0].length];

		for (int i = 0; i < u_room.length; i++) {
			for (int i2 = 0; i2 < u_room[0].length; i2++) {
				
				// For every camera, it changes into 'W' because robot can not walk onto it
				if (u_room[i][i2] == 'C') {
					u_room[i][i2] = 'W';
					
					// Up
					increment = -1;
					while (u_room[i + increment][i2] != 'W') {
						if (u_room[i + increment][i2] == '.' || u_room[i + increment][i2] == 'S') {
							update[i + increment][i2] = true;
						}
						increment--;
					}
					
					// Down
					increment = 1;
					while (u_room[i + increment][i2] != 'W') {
						if (u_room[i + increment][i2] == '.' || u_room[i + increment][i2] == 'S') {
							update[i + increment][i2] = true;
						}
						increment++;
					}
					
					// Left
					increment = -1;
					while (u_room[i][i2 + increment] != 'W') {
						if (u_room[i][i2 + increment] == '.' || u_room[i][i2 + increment] == 'S') {
							update[i][i2 + increment] = true;
						}
						increment--;
					}
					increment = 1;
					
					// Right
					while (u_room[i][i2 + increment] != 'W') {
						if (u_room[i][i2 + increment] == '.' || u_room[i][i2 + increment] == 'S') {
							update[i][i2 + increment] = true;
						}
						increment++;
					}					
				}
			}
		}
		
		// Change every element to 'X' where the robot will be caught
		for (int i = 0; i < u_room.length; i++) {
			for (int i2 = 0; i2 < u_room[0].length; i2++) {
				if (update[i][i2] == true) {
					u_room[i][i2] = 'X';
				}
			}
		}
		return u_room;
	}	
	
	/*
	 * @variable | map is the 2D char array
	 * @variable | start_c & start_r is the starting position of the robot
	 * 
	 * @function | Create a 2D integer array of same size. Use a variable called range, from the  
	 * 		     | start position to see where the robot can go to in the given amount of steps, 
	 * 			 | only the smallest number of steps will be recorded. When there are no progresses
	 * 			 | made, it will stop.
	 * 
	 * @output   | A 2D integer array that states how many steps minimum is needed. Default, not
	 * 			 | possible blocks ('.' or 'W') are 0, but can be compared with the original char
	 * 		 	 | array to distinguish them.
	 */
	
	// 1 is start
	public static int[][] find_path (char[][] map, int start_c, int start_r) {
		int range = 0;
		
		// Creates a copy of array
		int[][] c_map = new int[map.length][map[0].length];
			c_map[start_c][start_r] = 1;

		// Last value of last array is used as a boolean, -2 means false
		while (true) {
			range += 1;
			c_map = expand_range(map, c_map, range);
			if (c_map[c_map.length - 1][c_map[0].length - 1] == -2) { 
				break;
			}
		}
		return c_map;
	}
	
	/*
	 * @variable | original is the same char array in the beginning, never modified
	 * @variable | e_map is a copy of the previous 2D integer array, c_map
	 * @variable | e_range is a copy of the previous integer, range
	 * 
	 * @function | It will use the variable range to check for any number less than 1 (Which is
	 * 			 | any previous moves), and expand it's possible locations
	 * 
	 * @output   | *Same output of method find path, except it is a draft version as more elements
	 * 			 | may be filled in*
	 */
	public static int[][] expand_range(char[][] original, int[][] e_map, int e_range) {
		
		// Used to check if any progress can be made. If not, break the loop in main function
		boolean can_progress = false;
	
		for (int i = 0; i < e_map.length; i++) {
			for (int i2 = 0; i2 < e_map[0].length; i2++) {
				if (e_map[i][i2] == e_range) {
					
					// Up
					if (e_map[i - 1][i2] == 0 && (original[i - 1][i2] != 'W' || original[i - 1][i2] != 'X')) {
						e_map = check_path(e_map, original, i, i2, -1, 0, e_range);
						can_progress = true;
					}
					
					// Down
					if (e_map[i + 1][i2] == 0 && (original[i + 1][i2] != 'W' || original[i + 1][i2] != 'X')) {
						e_map = check_path(e_map, original, i, i2, 1, 0, e_range);
						can_progress = true;
					}
					
					// Left
					if (e_map[i][i2 - 1] == 0 && (original[i][i2 - 1] != 'W' || original[i][i2 - 1] != 'X')) {
						e_map = check_path(e_map, original, i, i2, 0, -1, e_range);
						can_progress = true;
					}
					
					// Right
					if (e_map[i][i2 + 1] == 0 && (original[i][i2 + 1] != 'W' || original[i][i2 + 1] != 'X')) {
						e_map = check_path(e_map, original, i, i2, 0, 1, e_range);
						can_progress = true;
					}
				}
			}
		}
		
		// Testing of arrays
		//print_array(e_map);
		
		// check if any progresses are made. If not, use last element (always 'W') as boolean
		if (can_progress == false) {
			e_map[e_map.length - 1][e_map[0].length - 1] = -2;
		}
		return e_map;
	}	
	
	/*
	 * @variable | original is the same char array in the beginning, never modified
	 * @variable | c_map is a copy of the previous 2D integer array, e_map
	 * @variable | c_range is a copy of the previous integer, e_range
	 * @variable | v_start, h_start are the element in the array that this method is testing	 
	 * @variable | v_factor, h_factor are integers that keeps track of where the robot will move
	 * 			   after one step (affected by tread mill or not)
	 * 
	 * @function | It will load in previous required informations (see @variable) from the method
	 * 			 | check_path, and check the element it is directed to. Since there will be 
	 * 			 | tread mills, the method will run, changing the element it checks based on
	 * 			 | scanned elements, until it reaches a '.'
	 * 			 | *It will stop automatically after an amount of time to prevent infinite loop*
	 * 
	 * @output   | *Same output of method find path, except it is a draft version as more elements
	 * 			 | may be filled in*
	 */
	public static int[][] check_path (int[][] c_map, char[][] original, int v_start, int h_start, int v_factor, int h_factor, int c_range) {
		
		// Integers used to check how the target element changes
		int v_change = 0;
		int h_change = 0;
		
		// Integer to prevent infinite loop (Stop at 10000)
		int step = 0;
		
		while (original[v_start + v_factor + v_change][h_start + h_factor + h_change] != '.') {
			
			if (original[v_start + v_factor + v_change][h_start + h_factor + h_change] == 'U') {
				v_change--;
			}
				
			if (original[v_start + v_factor + v_change][h_start + h_factor + h_change] == 'D') {
				v_change++;
			}

			if (original[v_start + v_factor + v_change][h_start + h_factor + h_change] == 'L') {
				h_change--;
			}

			if (original[v_start + v_factor + v_change][h_start + h_factor + h_change] == 'R') {
				h_change++;
			}
			
			step++;
			if (original[v_start + v_factor + v_change][h_start + h_factor + h_change] == 'W' || step > 10000 ) {
				return c_map;
			}
		}
		
		// check if there is already a smaller number on the target element (Because minimum is required)
		if (c_map[v_start + v_factor + v_change][h_start + h_factor + h_change] < c_range && c_map[v_start + v_factor + v_change][h_start + h_factor + h_change] == 0) {
			c_map[v_start + v_factor + v_change][h_start + h_factor + h_change] = c_range + 1;
		}
		return c_map;
	}
	
	// Just a function that prints out an integer array formatted
	public static void print_array (int[][] test_array) {
		for (int i = 0; i < test_array.length; i++) {
			for (int i2 = 0; i2 < test_array[0].length; i2++) {
				
				if (test_array[i][i2] >= 0) {
					System.out.print("0" + test_array[i][i2] + " ");
				}
				else {
					System.out.print(test_array[i][i2] + " ");
				}
			}
			System.out.println("");
		}
		System.out.println("");
	} 	
	
}