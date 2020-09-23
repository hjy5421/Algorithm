package Algorithm;

import java.util.*;

public class B11724 {
    static int N = 0, M = 0;
    static boolean[] visit;
    static int[][] graph;
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        graph = new int[N + 1][N + 1];
        visit = new boolean[N + 1];
        // visit[0]=true;
        for (int i = 0; i < M; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            graph[n1][n2] = 1;
            graph[n2][n1] = 1;
        }

        for (int i = 1; i < N + 1; i++) {
            if (visit[i] == false) {
                dfs(i);
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static void dfs(int node) {
        visit[node] = true;

        for (int i = 1; i < N + 1; i++) {
            if (visit[i] == false && graph[node][i] == 1) {
                visit[i] = true;
                dfs(i);
            }
        }
    }
}
