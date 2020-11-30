package Algorithm.BruteForce;

import java.util.*;

public class B1107 {
    static boolean[] broken = new boolean[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            int b = sc.nextInt();
            broken[b] = true;
        }
        sc.close();

        int answer = Math.abs(N - 100);
        for (int i = 0; i < 1000000; i++) {
            int len = isPossible(i);
            if (len > 0) {
                int press = Math.abs(i - N);
                if (answer > len + press) {
                    answer = len + press;
                }
            }
        }
        System.out.println(answer);
    }

    public static int isPossible(int num) {
        int ret = 0;
        if (num == 0) {
            if (broken[num] == false)
                return 1;
            else
                return 0;
        }
        while (num > 0) {
            if (broken[num % 10] == false) {
                ret += 1;
                num /= 10;
            } else {
                return 0;
            }
        }
        return ret;
    }
}
