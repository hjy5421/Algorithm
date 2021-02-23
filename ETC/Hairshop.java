package ETC;

import java.util.*;

public class test {
    public static ArrayList<Integer>[] island;
    public static ArrayList<Integer> ansArr = new ArrayList<>();
    public static ArrayList<Integer> costArr = new ArrayList<>();

    public static int solution(int n, int[][] costs) {
        int answer = 0;
        island = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            island[i] = new ArrayList<>();
        }
        for (int i = 0; i < costs.length; i++) {
            island[costs[i][0]].add(costs[i][1]);
            island[costs[i][1]].add(costs[i][0]);
        }

        for (int i = 0; i < n; i++) {
            boolean[] visit = new boolean[n];
            dfs(i, n, 1, costs, visit);
        }

        Collections.sort(ansArr);
        answer = ansArr.get(0);
        return answer;
    }

    public static void dfs(int start, int n, int depth, int[][] costs, boolean[] visit) {
        if (depth == n) {
            System.out.println("finish");
            int sum = 0;
            for (int k = 0; k < costArr.size(); k++) {
                sum += costArr.get(k);
            }
            ansArr.add(sum);
            costArr.clear();
            return;
        }
        visit[start] = true;
        System.out.println("depth : " + depth);
        for (int i = 0; i < island[start].size(); i++) {
            int tmp = island[start].get(i);
            if (visit[tmp] == false) {
                visit[tmp] = true;
                int cost = findcost(costs, start, tmp);
                costArr.add(cost);
                System.out.println(start + " " + tmp + " " + cost);
                dfs(tmp, n, depth + 1, costs, visit);
                visit[tmp] = false;
            }
        }
    }

    public static int findcost(int[][] costs, int ln1, int ln2) {
        int ret = 0;
        for (int i = 0; i < costs.length; i++) {
            if (costs[i][0] == ln1 && costs[i][1] == ln2)
                ret = costs[i][2];
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] costs = { { 0, 1, 1 }, { 0, 2, 2 }, { 1, 2, 5 }, { 1, 3, 1 }, { 2, 3, 8 } };
        int n = 4;
        int answer = solution(n, costs);
        System.out.println(answer);
    }
}
