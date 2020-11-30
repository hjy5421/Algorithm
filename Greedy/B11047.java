package Algorithm.Greedy;

import java.util.*;

public class B11047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] coin = new int[N];
        for (int i = 0; i < N; i++) {
            coin[i] = sc.nextInt();
        }

        int answer = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (K >= coin[i]) {
                answer += (K / coin[i]);
                K = K % coin[i];
            }
        }
        System.out.println(answer);
    }
}
