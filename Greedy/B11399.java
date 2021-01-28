package Greedy;

import java.util.*;

public class B11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] p = new int[N];
        for (int i = 0; i < N; i++) {
            p[i] = sc.nextInt();
        }
        Arrays.sort(p);
        int[] sum = new int[N];
        sum[0] = p[0];
        int answer = 0;
        answer += sum[0];
        for (int i = 1; i < N; i++) {
            sum[i] = sum[i - 1] + p[i];
            answer += sum[i];
        }
        System.out.println(answer);
        sc.close();
    }
}
