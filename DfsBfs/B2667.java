package DfsBfs;

import java.util.*;

public class B2667 {
    static int N = 0;
    static int[][] graph;
    static boolean[][] visit;
    static int[][] direction = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };
    static int apartNum = 0;
    static int[] answer = new int[25 * 25];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        graph = new int[N][N];
        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String str = sc.next();
            for (int j = 0; j < N; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (visit[y][x] == false && graph[y][x] == 1) {
                    apartNum++;
                    dfs(y, x);
                }
            }
        }

        Arrays.sort(answer);
        System.out.println(apartNum);
        for (int i = 0; i < answer.length; i++) {
            if (answer[i] == 0)
                ;
            else
                System.out.println(answer[i]);
        }

        sc.close();
    }

    public static void dfs(int y, int x) {
        visit[y][x] = true;
        answer[apartNum]++;
        for (int i = 0; i < 4; i++) {
            int ny = y + direction[i][0];
            int nx = x + direction[i][1];
            if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
                if (graph[ny][nx] == 1 && visit[ny][nx] == false) {
                    dfs(ny, nx);
                }
            }
        }
    }
}
