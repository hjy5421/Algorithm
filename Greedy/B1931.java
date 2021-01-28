package Greedy;

import java.io.*;
import java.util.*;

public class B1931 {
    static int N;
    static long[][] meeting;
    static int answer = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        meeting = new long[N][2];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            meeting[i][0] = Long.parseLong(st.nextToken());
            meeting[i][1] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(meeting, new Comparator<long[]>() {
            @Override
            public int compare(long[] l1, long[] l2) {
                if (l1[1] == l2[1]) {
                    return Long.compare(l1[0], l2[0]);
                } else {
                    return Long.compare(l1[1], l2[1]);
                }
            }
        });

        long time = 0;
        for (int i = 0; i < meeting.length; i++) {
            if (meeting[i][0] >= time) {
                time = meeting[i][1];
                answer++;
            }
        }
        System.out.println(answer);
    }
}
