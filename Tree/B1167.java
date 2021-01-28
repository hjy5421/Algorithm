package Tree;

import java.util.*;
import java.io.*;

public class B1167 {
    static ArrayList<Integer>[] tree;
    static ArrayList<Integer>[] dist;
    static int max = 0;
    static int maxNode = 0;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        tree = new ArrayList[V + 1];
        dist = new ArrayList[V + 1];
        for (int i = 0; i < V + 1; i++) {
            tree[i] = new ArrayList<>();
            dist[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            String[] arr = br.readLine().split(" ");
            int parent = Integer.parseInt(arr[0]);
            int child = 0;
            int d = 0;
            for (int j = 1; j < arr.length; j++) {
                child = Integer.parseInt(arr[j]);
                if (child == -1)
                    break;

                d = Integer.parseInt(arr[++j]);
                tree[parent].add(child);
                dist[parent].add(d);

                tree[child].add(parent);
                dist[child].add(d);
            }
        }

        boolean[] visit = new boolean[V + 1];
        dfs(1, visit, 0);
        answer = Math.max(answer, max);

        max = 0;
        visit = new boolean[V + 1];
        dfs(maxNode, visit, 0);
        answer = Math.max(answer, max);

        System.out.println(answer);
    }

    public static void dfs(int node, boolean[] visit, int route) {
        visit[node] = true;
        if (route > max) {
            max = route;
            maxNode = node;
        }
        // System.out.println(node + " " + max);
        for (int i = 1; i < tree[node].size(); i++) {
            int cur = tree[node].get(i);
            if (visit[cur] == false) {
                dfs(cur, visit, route + dist[node].get(i));
            }
        }
    }
}
