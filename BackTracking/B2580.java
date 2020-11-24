package Algorithm.BackTracking;

import java.io.*;
import java.util.*;

public class B2580 {
    static int[][] sdoqu = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            for (int j = 0; j < 9; j++) {
                sdoqu[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sdoqu[i][j] == 0) {

                }
            }
        }
    }

    public static void isPossible(int row, int col) {

    }
}
