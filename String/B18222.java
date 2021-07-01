package String;

import java.util.*;

public class B18222 {
    static long[] arr = new long[64];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long k = sc.nextLong();
        findArr();
        int answer = find(k);
        System.out.println(answer);
    }

    public static int find(long k) {
        if (k == 1) {
            return 0;
        }

        long N = 0;
        for (int i = 0; i < arr.length; i++) {
            if (k > arr[i]) {
                N = arr[i];
            } else {
                break;
            }
        }
        return 1 - find(k - N);
    }

    public static void findArr() {
        int n = 0;
        while (n < 64) {
            arr[n] = (long) Math.pow(2, n);
            n++;
        }
    }

}
