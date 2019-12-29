package Questions_Other;

// Question: https://leetcode.com/problems/decode-string/

public class decodeString {
    public static void main(String[] args) {
        String input = "4[x3[yy]d]";

        int leftIndex = 0;
        int rightIndex = 0;
        int tempIndex = 0; // For finding number
        int numberIndex = 0; // For first digit index
        int repeat = 0;
        String pattern = "";
        String segment = "";

        while(input.contains("[")) {
            // find "[" with highest index, then find first matching bracket
            while (input.substring(leftIndex).contains("[")) {
                leftIndex += input.substring(leftIndex).indexOf("[") + 1;
            }
            leftIndex--; // Cancel + 1 at the end
            rightIndex = leftIndex + input.substring(leftIndex).indexOf("]");

            // read pattern inside
            pattern = input.substring(leftIndex + 1, rightIndex);

            // read number before, first find first digit of number, then read value
            tempIndex = leftIndex - 1;
            while (isNumber(input.charAt(tempIndex))) {
                tempIndex--;

                // If already checking first index, skip loop
                if (tempIndex == -1) {
                    break;
                }
            }
            tempIndex++; // Move index onto first number digit
            numberIndex = tempIndex;

            while (isNumber(input.charAt(tempIndex))) {
                repeat = repeat * 10 + Integer.parseInt(String.valueOf(input.charAt(tempIndex)));
                tempIndex++;
            }

            // Create String segment to replace
            for (int i = 0; i < repeat; i++) {
                segment += pattern;
            }

            // Replace segment into input
            input = rebuildString(input, segment, numberIndex, rightIndex);

            // Reset variables
            leftIndex = 0;
            rightIndex = 0;
            tempIndex = 0;
            numberIndex = 0;
            repeat = 0;
            pattern = "";
            segment = "";
        }

        System.out.println(input);
    }

    public static boolean isNumber(char c) {
        if (c > 47 && c < 58) {
            return true;
        }
        return false;
    }

    public static String rebuildString(String original, String modifier, int start, int end) {
        String output = original.substring(0, start);
        output += modifier;
        output += original.substring(end + 1);
        return output;
    }

}