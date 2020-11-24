package Algorithm.DfsBfs;

import java.util.*;

class Node {
    public int value = 0;
    public int time = 0;

    Node(int value, int time) {
        this.value = value;
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    public int getValue() {
        return value;
    }

}

public class B1697 {
    static int N = 0, K = 0;
    static int[] route;
    static boolean[] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        visit = new boolean[100000 + 1];
        int answer = bfs(N, K);
        System.out.println(answer);
        sc.close();
    }

    public static int bfs(int now, int end) {
        Queue<Node> queue = new LinkedList<>();
        visit[now] = true;
        queue.offer(new Node(now, 0));

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.getValue() == end) {
                return cur.getTime();
            }

            if (cur.getValue() - 1 >= 0) {
                if (visit[cur.getValue() - 1] == false) {
                    visit[cur.getValue() - 1] = true;
                    queue.offer(new Node(cur.getValue() - 1, cur.getTime() + 1));
                }
            }

            if (cur.getValue() + 1 < visit.length) {
                if (visit[cur.getValue() + 1] == false) {
                    visit[cur.getValue() + 1] = true;
                    queue.offer(new Node(cur.getValue() + 1, cur.getTime() + 1));
                }
            }

            if (cur.getValue() * 2 < visit.length) {
                if (visit[cur.getValue() * 2] == false) {
                    visit[cur.getValue() * 2] = true;
                    queue.offer(new Node(cur.getValue() * 2, cur.getTime() + 1));

                }
            }
        }
        return 0;
    }
}
