package Algorithm.DP;

import java.util.*;

public class B10844 {
    static long[][] stair = new long[101][10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        for (int i = 1; i < 10; i++) {
            stair[1][i] = 1;
            if (i == 9)
                stair[2][i] = 1;
            else
                stair[2][i] = 2;
        }

        if (n > 2) {
            for (int i = 3; i <= n; i++) {
                for (int j = 1; j < 10; j++) {
                    if (j == 1)
                        stair[i][j] = (stair[i - 2][j] + stair[i - 1][j + 1]) % 1000000000;
                    else if (j == 9)
                        stair[i][j] = stair[i - 1][j - 1] % 1000000000;
                    else
                        stair[i][j] = (stair[i - 1][j - 1] + stair[i - 1][j + 1]) % 1000000000;
                }
            }
        }

        long answer = 0;
        for (int i = 1; i < 10; i++) {
            answer += stair[n][i];
        }
        System.out.println(answer % 1000000000);
    }
}
