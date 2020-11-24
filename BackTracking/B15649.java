package Algorithm.BackTracking;

import java.util.*;

public class B15649 {
    static int N;
    static int M;
    static ArrayList<Integer> answer = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.close();

        for (int i = 1; i < N + 1; i++) {
            boolean[] visit = new boolean[N + 1];
            dfs(i, visit, 0);
            answer.clear();
        }
    }

    public static void dfs(int node, boolean[] visit, int count) {
        visit[node] = true;
        count++;
        answer.add(node);
        if (count == M) {
            print();
            return;
        }
        for (int i = 1; i < visit.length; i++) {
            if (visit[i] == false) {
                dfs(i, visit, count);
                visit[i] = false;
                answer.remove(answer.size() - 1);
            }
        }
    }

    public static void print() {
        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i) + " ");
        }
        System.out.println();
    }
}
