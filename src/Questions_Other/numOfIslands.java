package Questions_Other;

/**
 * Given a 2D array of 0s (water) and 1s (land), determine how many islands are there.
 *
 * 0 0 0 1   0 1 0 1
 * 0 0 1 1   0 1 0 0
 * 1 0 0 0   1 0 0 0
 * 1 1 0 0   1 0 0 1
 *  ^^^ 2     ^^^ 4
 */

public class numOfIslands {
    public static void main(String[] args) {
        int islands = 0;
        int[][] map = { {1, 0, 0, 0},
                        {1, 1, 0, 0},
                        {0, 0, 1, 0},
                        {0, 0, 0, 0} };

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 1) {
                    checkRegion(map, i, j);
                    islands++;
                }
            }
        }
        System.out.println(islands);
    }

    public static void checkRegion(int[][] arr, int i, int j) {
        arr[i][j] = 0;

        // up
        if (i - 1 >= 0 && arr[i - 1][j] == 1) {
            checkRegion(arr, i - 1, j);
        }

        // down
        if (i + 1 < arr.length && arr[i + 1][j] == 1) {
            checkRegion(arr, i + 1, j);
        }

        // left
        if (j - 1 >= 0 && arr[i][j - 1] == 1) {
            checkRegion(arr, i, j - 1);
        }

        // right
        if (j + 1 < arr[0].length && arr[i][j + 1] == 1) {
            checkRegion(arr, i, j + 1);
        }
    }

}

