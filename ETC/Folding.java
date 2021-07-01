package ETC;

import java.util.*;

class Process implements Comparable<Process> {
    int idx;
    int time;

    public Process(int idx, int time) {
        this.idx = idx;
        this.time = time;
    }

    public int getIdx() {
        return idx;
    }

    public int getTime() {
        return time;
    }

    @Override
    public int compareTo(Process p) {
        return this.time - p.time;
    }
}

public class Folding {
    public static void main(String[] args) {
        int[][] jobs = { { 0, 3 }, { 0, 6 }, { 0, 7 } };
        System.out.println(solution(jobs));
    }

    public static int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] n1, int[] n2) {
                return Integer.compare(n1[0], n2[0]);
            }
        });

        Map<Integer, Integer> result = new HashMap<>();
        PriorityQueue<Process> pq = new PriorityQueue<>();
        int time = 0;
        int idx = 0;
        while (idx < jobs.length) {
            while (idx < jobs.length && jobs[idx][0] <= time) {
                pq.add(new Process(idx, jobs[idx][1]));
                idx++;
                System.out.println(idx);
                // if (idx >= jobs.length)
                // break;
            }

            if (!pq.isEmpty()) {
                Process p = pq.poll();
                time += p.getTime();
                result.put(p.getIdx(), time - jobs[p.getIdx()][0]);
            } else {
                time++;
            }

        }

        while (!pq.isEmpty()) {
            Process p = pq.poll();
            time += p.getTime();
            result.put(p.getIdx(), time - jobs[p.getIdx()][0]);
        }

        for (int key : result.keySet()) {
            answer += result.get(key);
        }
        answer /= jobs.length;
        return answer;
    }
}
