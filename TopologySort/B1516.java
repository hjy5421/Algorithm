package TopologySort;

import java.util.*;

public class B1516 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Integer>[] list = new ArrayList[N + 1];
        int[] indegree = new int[N + 1];
        int[] build = new int[N + 1];
        int[] answer = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            build[i + 1] = sc.nextInt();
            int tmp = sc.nextInt();
            while (tmp != -1) {
                list[tmp].add(i + 1);
                indegree[i + 1]++;
                tmp = sc.nextInt();
            }
        }
        sc.close();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                answer[i] = build[i];
            }
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i = 0; i < list[now].size(); i++) {
                int next = list[now].get(i);
                indegree[next]--;
                answer[next] = Math.max(answer[now] + build[next], answer[next]);

                if (indegree[next] == 0)
                    queue.offer(next);
            }
        }

        for (int i = 1; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
}
