package Algorithm;

import java.util.*;

public class B1766 {
    static int N = 0, M = 0;
    static ArrayList<Integer>[] quiz;
    static int[] indegree;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        quiz = new ArrayList[N + 1];
        indegree = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            quiz[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            quiz[x].add(y);
            indegree[y]++;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 1; i < N + 1; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            System.out.print(queue.peek() + " ");
            int current = queue.poll();

            for (int j = 0; j < quiz[current].size(); j++) {
                int next = quiz[current].get(j);
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }

        }
        sc.close();
    }

}
