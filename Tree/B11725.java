package Tree;

import java.util.*;

public class B11725 {
    static boolean[] visit;
    static ArrayList<Integer>[] tree;
    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        tree = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            tree[n1].add(n2);
            tree[n2].add(n1);
        }

        visit = new boolean[N + 1];
        parent = new int[N + 1];
        dfs(1);
        for (int i = 2; i < N + 1; i++) {
            System.out.println(parent[i]);
        }
    }

    public static void dfs(int node) {
        visit[node] = true;
        for (int i = 0; i < tree[node].size(); i++) {
            int next = tree[node].get(i);
            if (visit[next] == false) {
                parent[next] = node;
                dfs(next);
            }
        }
    }
}
