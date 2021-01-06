package Algorithm.BruteForce;

import java.io.*;

public class B1018 {
    static String[] board;
    static boolean[][] chess; // Black=true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int N = Integer.parseInt(arr[0]);
        int M = Integer.parseInt(arr[1]);
        board = new String[N];
        chess = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine();
            for (int j = 0; j < M; j++) {
                if (board[i].charAt(j) == 'B')
                    chess[i][j] = true;
            }
        }
        br.close();

        int min = 64;
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                min = Math.min(checkChess(i, j), min);
            }
        }

        System.out.println(min);
    }

    public static int checkChess(int row, int col) {
        boolean isB = chess[row][col];
        int ret = 0;
        for (int i = row; i < row + 8; i++) {
            for (int j = col; j < col + 8; j++) {
                if (chess[i][j] != isB) {
                    ret++;
                }
                isB = !isB;
            }
            isB = !isB;
        }
        /*
         * chess[row][col] 색깔로 칠하기 시작할 때, 반대 색깔로 칠하기 시작할 때 2가지 경우가 존재
         */
        ret = Math.min(ret, 64 - ret);
        return ret;
    }

}
