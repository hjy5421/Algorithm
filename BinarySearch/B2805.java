package BinarySearch;

import java.util.*;

public class B2805 {
    static int N = 0, M = 0;
    static int[] wood;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        wood = new int[N];
        for (int i = 0; i < N; i++) {
            wood[i] = sc.nextInt();
        }

        Arrays.sort(wood);
        long left = 0;
        long right = wood[N - 1];
        long mid = 0;
        while (right >= left) {
            mid = (left + right) / 2;
            long num = 0;
            for (int i = 0; i < N; i++) {
                if (wood[i] - mid < 0)
                    num += 0;
                else
                    num += (wood[i] - mid);
            }

            if (num >= M) {
                left = mid + 1;
            } else if (num < M) {
                right = mid - 1;
            }
        }
        System.out.println(right);
        sc.close();
    }
}
