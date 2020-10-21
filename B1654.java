package Algorithm;

import java.util.*;

public class B1654 {
    static int K = 0, N = 0;
    static int[] line;
    static long answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        K = sc.nextInt();
        N = sc.nextInt();
        line = new int[K];
        for (int i = 0; i < K; i++) {
            line[i] = sc.nextInt();
        }

        Arrays.sort(line);

        long left = 1;
        long right = line[K - 1];
        while (right >= left) {
            long num = 0;
            long mid = (left + right) / 2;
            for (int i = 0; i < K; i++) {
                num += (line[i] / mid);
            }

            if (num < N)
                right = mid - 1;
            else if (num >= N)
                left = mid + 1;
        }
        System.out.println(right);
        sc.close();
    }
}
