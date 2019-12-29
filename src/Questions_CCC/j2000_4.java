package Questions_CCC;
import java.util.*;

// Question: https://dmoj.ca/problem/ccc00j4

/* Mistake: Not realizing “77”, “88”, “99” can be percentages too. Previous version recognized 88/99 percentages as commands,
 * and 77 percentage as end of input
 */

public class j2000_4 {
     public static void main(String[] args) {
         Scanner reader = new Scanner(System.in);
         ArrayList<Double> streams = new ArrayList<>();
         ArrayList<Integer> commands = new ArrayList<>();

         int n = reader.nextInt();
         for (int i = 0; i < n; i++) {
             streams.add((double) reader.nextInt());
         }
         reader.nextLine();

         String input = reader.nextLine();
         while (reader.hasNextLine()) {
             commands.add(Integer.parseInt(input));
             input = reader.nextLine();
         }
         commands.add(77);

         int index, percentage;
         double value;
         for (int i = 0; i < commands.size(); i++) {
             if (commands.get(i) == 99) {
                 index = commands.get(i + 1) - 1; // index of stream being split
                 value = streams.get(index); // original left stream value
                 percentage = commands.get(i + 2); // percentage of flow to left stream

                 streams.set(index, value * ((double) percentage / 100));
                 streams.add(index + 1, value * ((double) (100 - percentage) / 100));
                 // System.out.println(">>SPLIT<< Index: " + (index + 1) + " Percent to left: " + percentage);
                 i += 2; // Skip over indices to prevent repetition

             } else if (commands.get(i) == 88) {
                 index = commands.get(i + 1) - 1; // index of left stream merge to right stream

                 streams.set(index + 1, streams.get(index) + streams.get(index + 1));
                 streams.remove(index);
                 // System.out.println(">>MERGE<< Streams: " + (index + 1) + "&" + (index + 2));
                 i++; // Skip over index to prevent repetition
             }
         }

         for (double x : streams) {
             System.out.print((int) (x + 0.5) + " ");
         }
     }

}