package Questions_CCC;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// Question: https://dmoj.ca/problem/ccc03s3

public class s2003_3 {

    // To have a Integer Object, kinda stupid lol
    static class IntSize {
        int value;

        IntSize() {
            value = 0;
        }
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String line;
        int tiles = reader.nextInt();
        char[][] map = new char[reader.nextInt()][reader.nextInt()];

        reader.nextLine();
        for (int i = 0; i < map.length; i++) {
            line = reader.nextLine();
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        // Check for rooms and their sizes
        ArrayList<Integer> sizes = new ArrayList<>();
        IntSize size = new IntSize();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == '.') {
                    findSize(map, i, j, size);
                    sizes.add(size.value);
                    size.value = 0;
                }
            }
        }
        Collections.sort(sizes);
        Collections.reverse(sizes);

        // Find out how many rooms can be filled before tiles run out
        int rooms = 0;
        for (int i = 0; i < sizes.size(); i++) {
            if (tiles >= sizes.get(i)) {
                rooms++;
                tiles -= sizes.get(i);
            } else {
                break;
            }
        }

        if (rooms == 1) {
            System.out.println("1 room, " + tiles + " square metre(s) left over");
        } else {
            System.out.println(rooms + " rooms, " + tiles + " square metre(s) left over");
        }

    }

    // Method to find how big this room is
    public static void findSize(char[][] map, int i, int j, IntSize size) {
        size.value += 1;
        map[i][j] = 'I';

        // Up
        if (i - 1 >= 0 && map[i - 1][j] == '.') {
            findSize(map, i - 1, j, size);
        }

        // Down
        if (i + 1 < map.length && map[i + 1][j] == '.') {
            findSize(map, i + 1, j, size);
        }

        // Left
        if (j - 1 >= 0 && map[i][j - 1] == '.') {
            findSize(map, i, j - 1, size);
        }

        // Right
        if (j + 1 < map[0].length && map[i][j + 1] == '.') {
            findSize(map, i, j + 1, size);
        }
    }

}
