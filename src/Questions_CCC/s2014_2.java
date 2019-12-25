package Questions_CCC;
import java.util.*;

public class s2014_2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        String p1, p2;
        String[] list1 = new String[n];
        String[] list2 = new String[n];
        HashMap<String, String> relation = new HashMap<>();

        for (int i = 0; i < n; i++) {
            list1[i] = reader.next();
        }

        for (int i = 0; i < n; i++) {
            list2[i] = reader.next();
        }

        for (int i = 0; i < n; i++) {
            p1 = list1[i];
            p2 = list2[i];

            if (p1.equals(p2)) {
                System.out.println("bad");
                System.exit(420);
            }

            if (relation.containsKey(p1)) {
                if (!p2.equals(getKey(relation, p1))) {
                    System.out.println("bad");
                    System.exit(1337);
                }
            } else {
                relation.put(p1, p2);
                relation.put(p2, p1);
            }

        }

        System.out.println("good");
        reader.close();
    }

    private static <K, V> K getKey(Map<K, V> map, V value) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return null;
    }
}
