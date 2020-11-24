package Algorithm.DP;

import java.util.*;

//피보나치는 매우 큰 수이므로 int 대신 long
public class B2748 {
    static long[] fibo = new long[91];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        fibo[0] = 0;
        fibo[1] = 1;
        if (n < 2) {
            System.out.println(fibo[n]);
        } else {
            for (int i = 2; i <= n; i++) {
                fibo[i] = (fibo[i - 1] + fibo[i - 2]);
            }
            System.out.println(fibo[n]);
        }

    }
}
