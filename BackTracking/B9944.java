package BackTracking;

import java.io.*;
import java.util.*;

public class B9944 {
    static int N = 0;
    static int M = 0;
    static int[][] board;
    static int total = 0;
    static int[][] move = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        int n = 0;
        while ((input = br.readLine()) != null) {
            String[] arr = input.split(" ");
            int N = Integer.parseInt(arr[0]);
            int M = Integer.parseInt(arr[1]);
            board = new int[N][M];

            int obCnt = 0;
            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                for (int j = 0; j < s.length(); j++) {
                    if (s.charAt(j) == '*') {
                        board[i][j] = -1;
                        obCnt++;
                    }
                }

            }

            total = N * M - obCnt;
            int answer = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (board[i][j] != -1) {
                        boolean[][] visit = new boolean[N][M];
                        route(i, j, visit, 1, -1);
                    }
                }
            }

            System.out.println(answer);
        }
    }

    public static void route(int startR, int startC, boolean[][] visit, int sum, int cnt) {
        visit[startR][startC] = true;
        if (sum == total) {
            return;
        }

        int r = startR;
        int c = startC;
        for (int i = 0; i < 4; i++) {
            int nr = r + move[i][0];
            int nc = c + move[i][1];
            if (check(nr, nc) && board[nr][nc] != -1 && visit[nr][nc] == false) {
                while (true) {
                    visit[nr][nc] = true;
                    nr = nr + move[i][0];
                    nc = nc + move[i][1];

                    if (!check(nr, nc) || board[nr][nc] == -1 && visit[nr][nc]) {
                        route(nr, nc, visit, sum++, cnt++);
                    }
                }
                // route(nr, nc, visit, ++sum, i);
                // visit[nr][nc] = false;
            }
        }
    }

    public static boolean check(int nr, int nc) {
        if (nr < 0 || nr >= N || nc < 0 || nc >= M)
            return false;
        else
            return true;
    }
}
