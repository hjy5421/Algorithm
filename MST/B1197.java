package MST;

import java.io.*;
import java.util.*;

public class B1197 {
    static int[][] costs;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int V = Integer.parseInt(arr[0]);
        int E = Integer.parseInt(arr[1]);
        costs = new int[E][3];
        for (int i = 0; i < E; i++) {
            String[] vinfo = br.readLine().split(" ");
            for (int j = 0; j < vinfo.length; j++) {
                costs[i][j] = Integer.parseInt(vinfo[j]);
            }
        }

        parent = new int[V + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] n1, int[] n2) {
                return Integer.compare(n1[2], n2[2]);
            }
        });

        int answer = 0;
        for (int i = 0; i < costs.length; i++) {
            int v1 = find(costs[i][0]);
            int v2 = find(costs[i][1]);
            if (v1 != v2) {
                parent[v2] = v1;
                answer += costs[i][2];
            }
        }
        System.out.println(answer);
    }

    public static int find(int child) {
        if (parent[child] == child) {
            return child;
        }
        return parent[child] = find(parent[child]);
    }
}
