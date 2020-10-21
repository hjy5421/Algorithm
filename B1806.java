package Algorithm;

import java.util.*;

public class B1806 {
    static int N = 0;
    static long S = 0;
    static long[] numbers;
    static long[] numSum;

    public static void findSum() {
        long sum = 0;
        numSum[0] = sum;
        for (int i = 0; i < N; i++) {
            sum += numbers[i];
            numSum[i + 1] = sum;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextLong();
        numbers = new long[N];
        numSum = new long[N + 1];
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        findSum();
        int left = 0;
        int right = 0;
        int min = N + 1;
        while (right <= N && left <= N) {
            if (numSum[right] - numSum[left] < S) {
                right++;
            } else {
                min = Math.min(min, right - left);
                left++;
            }
        }
        if (min == N + 1)
            System.out.println(0);
        else
            System.out.println(min);

        sc.close();
    }
}
