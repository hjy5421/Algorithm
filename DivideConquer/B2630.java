package DivideConquer;

import java.io.*;

public class B2630 {
    static int N;
    static boolean[][] board;
    static int blue = 0; // 1
    static int white = 0; // 0

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String[] arr = br.readLine().split(" ");
            for (int j = 0; j < arr.length; j++) {
                if (arr[j].equals("1"))
                    board[i][j] = true;
            }
        }

        divide(0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }

    public static void divide(int is, int js, int N) {
        // System.out.println(is + " " + ie + " " + js + " " + je + " ");
        if (check(is, js, N)) {
            return;
        }
        divide(is, js, N / 2);
        divide(is, js + N / 2, N / 2);
        divide(is + N / 2, js, N / 2);
        divide(is + N / 2, js + N / 2, N / 2);

    }

    public static boolean check(int is, int js, int N) {
        boolean ret = board[is][js];
        for (int i = is; i < is + N; i++) {
            for (int j = js; j < js + N; j++) {
                if (ret != board[i][j])
                    return false;
            }
        }

        if (ret)
            blue++;
        else
            white++;
        return true;
    }
}
