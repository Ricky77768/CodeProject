package Questions_Other;

// Question: https://leetcode.com/problems/surrounded-regions/

public class surroundedRegions {
    public static void main(String[] args) {
        char[][] region = { {'X', 'X', 'X', 'X', 'X'},
                            {'X', 'X', 'X', 'O', 'X'},
                            {'X', 'O', 'O', 'X', 'X'},
                            {'X', 'O', 'X', 'X', 'X'}, };
        boolean[][] isImmune = new boolean[region.length][region[0].length]; // Doubles as "visited" boolean

        // Check around edges to mark interconnected 'O's that shouldn't be changed
        for (int i = 0; i < region.length; i++) {
            for (int j = 0; j < region[0].length; j++) {
                if ((i == 0 || i == region.length - 1) && region[i][j] == 'O') {
                    checkRegion(region, isImmune, i, j);
                } else {
                    if ((j == 0 || j == region[0].length - 1) && region[i][j] == 'O') {
                        checkRegion(region, isImmune, i, j);
                    }
                }
            }
        }

        // Mark everything else as 'X'
        for (int i = 0; i < region.length; i++) {
            for (int j = 0; j < region[0].length; j++) {
                if (region[i][j] == 'O' && !isImmune[i][j]) {
                    region[i][j] = 'X';
                }
            }
        }

        // Printing Result
        for (char[] x : region) {
            for (char y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }

    }

    public static void checkRegion(char[][] arr, boolean[][] isImmune, int i, int j) {
        isImmune[i][j] = true;

        // up
        if (i - 1 >= 0 && arr[i - 1][j] == 'O' && !isImmune[i - 1][j]) {
            checkRegion(arr, isImmune, i - 1, j);
        }

        // down
        if (i + 1 < arr.length && arr[i + 1][j] == 'O' && !isImmune[i + 1][j]) {
            checkRegion(arr, isImmune, i + 1, j);
        }

        // left
        if (j - 1 >= 0 && arr[i][j - 1] == 'O' && !isImmune[i][j - 1]) {
            checkRegion(arr, isImmune, i, j - 1);
        }

        // right
        if (j + 1 < arr[0].length && arr[i][j + 1] == 'O' && !isImmune[i][j + 1]) {
            checkRegion(arr, isImmune, i, j + 1);
        }
    }

}
