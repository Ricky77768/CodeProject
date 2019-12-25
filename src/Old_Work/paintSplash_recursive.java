package Old_Work;

public class paintSplash_recursive {

	public static void main(String[] args) {
		char[][] chart = { {'r', 'r', 'b', 'g', 'y', 'y'},
						   {'b', 'r', 'b', 'y', 'r', 'r'}, 
						   {'y', 'r', 'r', 'r', 'r', 'b'},
						   {'y', 'r', 'r', 'y', 'r', 'b'} };
		
		print2DArray(chart);
		paintRegion(chart, 3, 0, 'g', 'y');
		System.out.println("------------");
		print2DArray(chart);
		
	}
	
	public static void paintRegion(char[][] map, int row, int col, char newColor, char oldColor) {
		
		if (oldColor == newColor) {
			return;
		}
		
		if ((row < 0 || row > map.length - 1) || (col < 0 || col > map[0].length - 1)) {
			return;
		}
	
		if (map[row][col] == oldColor) {
			map[row][col] = newColor;
			paintRegion(map, row + 1, col, newColor, oldColor);
			paintRegion(map, row - 1, col, newColor, oldColor);
			paintRegion(map, row, col + 1, newColor, oldColor);
			paintRegion(map, row, col - 1, newColor, oldColor);
		}
		else {
			return;
		}
	}
	
	public static void print2DArray(char[][] array) {
		for (char[] i : array) {
			for (char j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}

}

