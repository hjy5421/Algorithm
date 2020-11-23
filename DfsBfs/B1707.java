package Algorithm;

import java.util.*;

public class B1707 {
    static int V = 0, E = 0;
    static ArrayList<Integer>[] graph;
    static int[] visit;
    static ArrayList<Boolean> ansArr = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        for (int i = 0; i < K; i++) {
            boolean answer = true;
            V = sc.nextInt();
            E = sc.nextInt();
            graph = new ArrayList[V + 1];
            visit = new int[V + 1];

            // 인접리스트 생성
            for (int j = 0; j < V + 1; j++) {
                graph[j] = new ArrayList<>();
            }
            for (int k = 0; k < E; k++) {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                graph[n1].add(n2);
                graph[n2].add(n1);
            }

            for (int p = 1; p < V + 1; p++) {
                if (visit[p] == 0)
                    dfs(p, 1);
            }

            for (int q = 1; q < V + 1; q++) {
                answer = search(q);
                if (answer == false)
                    break;
            }
            ansArr.add(answer);
        }

        for (int i = 0; i < ansArr.size(); i++) {
            if (ansArr.get(i) == true)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        sc.close();
    }

    public static void dfs(int node, int token) {
        visit[node] = token;

        for (int i = 0; i < graph[node].size(); i++) {
            if (visit[graph[node].get(i)] == 0) {
                // visit[graph[node].get(i)] = (++token);
                dfs(graph[node].get(i), token + 1);
            }
        }
    }

    public static boolean search(int node) {
        boolean ret = true;
        int n = visit[node];
        for (int i = 0; i < graph[node].size(); i++) {
            int cmp = visit[graph[node].get(i)];
            if (n % 2 == cmp % 2) {
                ret = false;
                break;
            }
        }
        return ret;
    }
}
