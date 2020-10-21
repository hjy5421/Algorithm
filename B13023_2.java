package Algorithm;

import java.util.*;

public class B13023_2 {
    static ArrayList<Integer>[] graph;
    static boolean[] visit;
    static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            graph[n1].add(n2);
            graph[n2].add(n1);
        }

        visit = new boolean[N];
        for (int i = 0; i < N; i++) {
            dfs(i, 1);
            if (ans == 1)
                break;
        }
        System.out.println(ans);
        sc.close();
    }

    public static void dfs(int i, int depth) {
        if (depth == 5) {
            ans = 1;
            return;
        }
        visit[i] = true;
        for (int j = 0; j < graph[i].size(); j++) {
            if (visit[graph[i].get(j)] == false) {
                visit[graph[i].get(j)] = true;
                dfs(graph[i].get(j), depth + 1);
                visit[graph[i].get(j)] = false;
            }
        }
        visit[i] = false;
    }
}
