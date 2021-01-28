package DfsBfs;

import java.util.*;

public class B1260 {
    static int N = 0, M = 0, V = 0;
    static ArrayList<Integer>[] graph;
    static boolean[] visit;
    static ArrayList<Integer> dfsArr = new ArrayList<>();
    static ArrayList<Integer> bfsArr = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();
        graph = new ArrayList[N + 1];
        visit = new boolean[N + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            graph[n1].add(n2);
            graph[n2].add(n1);
        }

        for (int i = 0; i < graph.length; i++) {
            Collections.sort(graph[i]);
        }
        // dfs
        dfs(V);
        for (int i = 0; i < dfsArr.size(); i++)
            System.out.print(dfsArr.get(i) + " ");

        System.out.println();
        Arrays.fill(visit, false);

        // bfs
        bfs(V);
        for (int i = 0; i < bfsArr.size(); i++)
            System.out.print(bfsArr.get(i) + " ");
        sc.close();
    }

    public static void dfs(int node) {
        visit[node] = true;
        dfsArr.add(node);
        for (int i = 0; i < graph[node].size(); i++) {
            if (visit[graph[node].get(i)] == false) {
                dfs(graph[node].get(i));
            }
        }
    }

    public static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(node);
        visit[node] = true;
        bfsArr.add(node);

        while (queue.isEmpty() == false) {
            int cur = queue.poll();
            for (int i = 0; i < graph[cur].size(); i++) {
                if (visit[graph[cur].get(i)] == false) {
                    queue.offer(graph[cur].get(i));
                    visit[graph[cur].get(i)] = true;
                    bfsArr.add(graph[cur].get(i));
                }
            }
        }

    }
}
