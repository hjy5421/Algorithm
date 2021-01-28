package BruteForce;

import java.util.*;

public class B1436 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int idx = 0;
        long num = 666;
        while (idx < N) {
            long rest = 0;
            long quote = num;
            while (quote > 100) {
                rest = quote % 1000;
                quote = quote / 10;
                if (rest == 666) {
                    idx++;
                    break;
                }
            }
            num++;
        }
        System.out.println(num - 1);
        sc.close();
    }
}
