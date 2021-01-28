import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
다익스트라
*/
class Node implements Comparable<Node> {
    int node;
    int weight;

    Node(int node, int weight) {
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
    public int compareTo(Node n) {
        return weight - n.weight;
    }
}

public class B1753 {
    static int[] dist;
    static List<Node>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        list = new ArrayList[V + 1];
        for (int i = 0; i < V + 1; i++) {
            list[i] = new ArrayList<>();
        }

        int start = Integer.parseInt(br.readLine());
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer((br.readLine()));
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Node(v, w));
        }

        dijkstra(start);
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                System.out.println("INF");
            else
                System.out.println(dist[i]);
        }
    }

    public static void dijkstra(int start) {
        boolean[] visit = new boolean[dist.length];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            int cur = pq.poll().getNode();

            if (visit[cur])
                continue;
            visit[cur] = true;

            for (Node node : list[cur]) {
                int newDist = dist[cur] + node.getWeight();
                if (newDist < dist[node.getNode()]) {
                    dist[node.getNode()] = newDist;
                    pq.add(new Node(node.getNode(), dist[node.getNode()]));
                }
            }
        }
    }
}
