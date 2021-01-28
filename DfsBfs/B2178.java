package DfsBfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class B2178 {
    static int N;
    static int M;
    static int[][] maze;
    static boolean[][] visit;
    static int[][] move = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        N = Integer.parseInt(arr[0]);
        M = Integer.parseInt(arr[1]);
        maze = new int[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                maze[i][j] = (int) (s.charAt(j) - '0');
            }
        }

        bfs();

        System.out.println(maze[N - 1][M - 1]);
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        int[] node = { 0, 0 };
        visit[0][0] = true;
        queue.add(node);

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (cur[0] == N - 1 && cur[1] == M - 1) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int n0 = cur[0] + move[i][0];
                int n1 = cur[1] + move[i][1];
                if (n0 >= 0 && n0 < N && n1 >= 0 && n1 < M) {
                    if (maze[n0][n1] > 0 && !visit[n0][n1]) {
                        int[] newNode = { n0, n1 };
                        queue.add(newNode);
                        /*
                         * 최소경로 알 수 있었던 방법
                         */
                        maze[n0][n1] = maze[cur[0]][cur[1]] + 1;
                        visit[n0][n1] = true;
                    }
                }
            }
        }
    }
}
