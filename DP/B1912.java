package DP;

import java.util.*;
import java.io.*;

public class B1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int[] num = new int[n + 1];
        int[] sum = new int[n + 1];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < n + 1; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, num[i]);
        }

        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (j + i - 1 < n + 1) {
                    sum[j] = sum[j] + num[j + i - 1];
                    max = Math.max(max, sum[j]);
                }
            }
        }

        // 정답
        /*
         * sum[1]=num[1]; for(int i=2;i<n+1;i++){
         * sum[i]=Math.max(sum[i-1]+num[i],num[i]); max=Math.max(max,sum[i]); }
         */
        System.out.println(max);
    }
}
