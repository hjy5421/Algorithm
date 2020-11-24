package Algorithm.BackTracking;

import java.util.*;

public class B15652 {
    static int N;
    static int M;
    static ArrayList<Integer> answer = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.close();

        for (int i = 1; i < N + 1; i++) {
            // boolean[] visit = new boolean[N + 1];
            dfs(i, 0);
            answer.clear();
        }
        System.out.print(sb);
    }

    public static void dfs(int node, int count) {
        answer.add(node);
        count++;
        if (count == M) {
            print();
            return;
        }

        for (int i = node; i < N + 1; i++) {
            dfs(i, count);
            answer.remove(answer.size() - 1);
        }
    }

    public static void print() {
        for (int i = 0; i < answer.size(); i++) {
            sb.append(answer.get(i) + " ");
        }
        sb.append("\n");
    }
}
