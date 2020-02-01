package Questions_CCC;
import java.io.*;
import java.util.*;

// Problem: https://dmoj.ca/problem/ccc12s3

public class s2012_3 {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }

        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine() {
            String str = "";

            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }

    public static void main(String[] args) throws IOException {
        FastReader reader = new FastReader();
        int[] frequency = new int[1001];

        int size = reader.nextInt();
        for (int i = 0; i < size; i++) {
            frequency[reader.nextInt()] += 1;
        }

        int[] temp = Arrays.copyOf(frequency, frequency.length);
        Arrays.sort(temp);

        int max = temp[temp.length - 1];
        int secondMax = 0;
        for (int i = temp.length - 1; i >= 0; i--) {
            if (temp[i] != max) {
                secondMax = temp[i];
                break;
            }
        }
        if (secondMax == 0) { secondMax = max; }

        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();


        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] == max) {
                first.add(i);
            }

            if (frequency[i] == secondMax) {
                second.add(i);
            }
        }
        Collections.sort(first);
        Collections.sort(second);

        if (max == secondMax || first.size() >= 2) {
            System.out.println(Math.abs(first.get(0) - first.get(first.size() - 1)));
        } else {
            int x = Math.abs(first.get(0) - second.get(second.size() - 1));
            int y = Math.abs(second.get(0) - first.get(first.size() - 1));

            if (x > y) {
                System.out.println(x);
            } else {
                System.out.println(y);
            }
        }

    }
}
