package TopologySort;

import java.util.*;

public class B2252 {
    static int N = 0, M = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        ArrayList<Integer> answer = new ArrayList<>();

        int[] indegree = new int[N + 1];
        ArrayList<Integer>[] list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            list[x].add(y);
            indegree[y]++;
        }

        // 위상정렬
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < N + 1; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            System.out.println(queue.peek());
            int current = queue.poll();
            answer.add(current);

            for (int i = 0; i < list[current].size(); i++) {
                int next = list[current].get(i);
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.add(next);
                }
            }

        }
        sc.close();
    }
}
