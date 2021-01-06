package Algorithm.BruteForce;

import java.io.*;

public class B7568 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] people = new int[N][2];
        for (int i = 0; i < N; i++) {
            String[] info = br.readLine().split(" ");
            people[i][0] = Integer.parseInt(info[0]);
            people[i][1] = Integer.parseInt(info[1]);
        }

        /*
         * Arrays.sort(people, new Comparator<int[]>() {
         * 
         * @Override public int compare(int[] s1, int[] s2) { return
         * Integer.compare(s2[0], s1[0]); } });
         */

        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            int bigger = 0;
            for (int j = 0; j < N; j++) {
                if (people[j][0] > people[i][0] && people[j][1] > people[i][1]) {
                    bigger++;
                }
            }
            answer[i] = (bigger + 1);
        }

        for (int i = 0; i < N; i++) {
            System.out.print(answer[i] + " ");
        }
    }

}
