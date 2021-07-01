package DfsBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B14502 {
    static int[][] lab;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int N = Integer.parseInt(arr[0]);
        int M = Integer.parseInt(arr[1]);
        lab = new int[N][M];
        for (int i = 0; i < N; i++) {
            arr = br.readLine().split(" ");
            for (int j = 0; j < arr.length; j++) {
                lab[i][j] = Integer.parseInt(arr[j]);
            }
        }
    }

}
