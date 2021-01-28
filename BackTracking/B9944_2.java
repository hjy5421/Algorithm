package BackTracking;

import java.io.*;
import java.util.*;

public class B9944_2 {
    static int N = 0;
    static int M = 0;
    static int[][] board;
    static int total = 0;
    static int[][] move = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
    static List<Integer> minArr = new ArrayList<>();
    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] arr = sc.nextLine().split(" ");
            N = Integer.parseInt(arr[0]);
            M = Integer.parseInt(arr[1]);
            board = new int[N][M];

            int obCnt = 0;
            for (int i = 0; i < N; i++) {
                String s = sc.nextLine();
                for (int j = 0; j < s.length(); j++) {
                    if (s.charAt(i) == '*') {
                        board[i][j] = -1;
                        obCnt++;
                    }
                }
            }

            total = N * M - obCnt;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    boolean[][] visit = new boolean[N][M];
                    route(i, j, visit, 1, 1);
                }
            }
            Collections.sort(minArr);
            answer.add(minArr.get(0));
            minArr.clear();
        }
    }

    public static void route(int r, int c, boolean[][] visit, int cnt, int sum) {
        visit[r][c] = true;
        if (sum == total) {
            minArr.add(cnt);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nr = r + move[i][0];
            int nc = c + move[i][1];
            if (check(nr, nc) && board[nr][nc] != -1 && visit[nr][nc] == false) {
                route(nr, nc, visit, ++cnt, ++sum);
                visit[nr][nc] = false;
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
