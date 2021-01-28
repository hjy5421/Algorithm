import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

/*
2차원 배열 arr[노드번호][0]=비용, arr[노드번호][1]=최소시간으로 할 경우,
예외) 인천(1)->LA(4) : 1->3까지의 가는 어느 경로가 시간은 최소지만, 비용은 초과할 경우
다른 경로가 최종적으로는 1->4까지 가는 최소시간경로에 포함되지만 1->3까지에서는 최소시간이 아님.
*/
class Airport implements Comparable<Airport> {
    int node;
    int cost;
    int time;

    Airport(int node, int cost, int time) {
        this.node = node;
        this.cost = cost;
        this.time = time;
    }

    @Override
    public int compareTo(Airport n) {
        return time - n.time;
    }

    public int getNode() {
        return node;
    }

    public int getCost() {
        return cost;
    }

    public int getTime() {
        return time;
    }
}

public class B10217 {
    static ArrayList<Airport>[] list;
    static int[][] route;
    static int M = 0;
    static int N = 0;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            list = new ArrayList[N + 1];
            for (int j = 0; j < N + 1; j++) {
                list[j] = new ArrayList<>();
            }
            route = new int[N + 1][M + 1];
            for (int j = 0; j < N + 1; j++) {
                Arrays.fill(route[j], Integer.MAX_VALUE);
            }

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                list[u].add(new Airport(v, c, d));
            }

            dijkstra();
            if (answer == Integer.MAX_VALUE) {
                bw.write("Poor KCM\n");
            } else {
                bw.write(answer + "\n");
            }
            answer = Integer.MAX_VALUE;
        }
        bw.flush();
        bw.close();
    }

    public static void dijkstra() {
        PriorityQueue<Airport> pq = new PriorityQueue<>();
        pq.add(new Airport(1, 0, 0));
        route[1][0] = 0;

        while (!pq.isEmpty()) {
            Airport cur = pq.poll();

            if (cur.node == N) {
                answer = Math.min(answer, cur.time);
                break;
            }

            for (Airport n : list[cur.node]) {
                int newNode = n.getNode();
                int newCost = cur.cost + n.getCost();
                int newTime = cur.time + n.getTime();
                if (newCost > M)
                    continue;

                if (newTime < route[newNode][newCost]) {
                    route[newNode][newCost] = newTime;
                    pq.add(new Airport(newNode, newCost, newTime));
                }
            }
        }

    }
}
