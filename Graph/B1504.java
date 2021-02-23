package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Road implements Comparable<Road> {
    int node;
    int weight;

    Road(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    public int getNode() {
        return node;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Road n) {
        return weight - n.weight;
    }
}

public class B1504 {
    static List<Road>[] list;
    static int[] dist;
    static int[] v = new int[2];
    static final int INF = 200_000_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        dist = new int[N + 1];

        list = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Road(b, c));
            list[b].add(new Road(a, c));
        }

        st = new StringTokenizer(br.readLine());
        v[0] = Integer.parseInt(st.nextToken());
        v[1] = Integer.parseInt(st.nextToken());

        /*
         * 방법 1) 1->v0->v1->N 방법 2) 1->v1->v0->N
         */

        int answer1 = dijkstra(1, v[0]) + dijkstra(v[0], v[1]) + dijkstra(v[1], N);
        int answer2 = dijkstra(1, v[1]) + dijkstra(v[1], v[0]) + dijkstra(v[0], N);
        int answer = Math.min(answer1, answer2);
        if (answer >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }

    }

    public static int dijkstra(int start, int end) {
        Arrays.fill(dist, INF);
        PriorityQueue<Road> pq = new PriorityQueue<>();
        pq.add(new Road(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            int cur = pq.poll().getNode();

            for (Road node : list[cur]) {
                int newDist = dist[cur] + node.getWeight();
                if (newDist < dist[node.getNode()]) {
                    dist[node.getNode()] = newDist;
                    pq.add(new Road(node.getNode(), dist[node.getNode()]));
                }
            }
        }

        return dist[end];
    }
}
