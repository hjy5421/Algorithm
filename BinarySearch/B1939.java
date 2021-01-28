package BinarySearch;

import java.util.*;

public class B1939 {
    static int N = 0, M = 0;
    static int[][] route;
    static int pStart = 0, pEnd = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        route = new int[M][3];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 3; j++) {
                route[i][j] = sc.nextInt();
            }
        }
        pStart = sc.nextInt();
        pEnd = sc.nextInt();

        long left = 1;
        long right = 1000000000;
        long mid = 0;
        long answer = 0;
        while (right >= left) {
            mid = (left + right) / 2;
            boolean[] visit = new boolean[N + 1];
            System.out.println(left + " " + right + " " + mid);
            boolean b1 = dfs(pStart, pEnd, mid, visit);
            boolean b2 = dfs(pEnd, pStart, mid, visit);
            System.out.println(b1 + " " + b2);
            // 경로 존재하는지 확인 -> 존재하면 left=mid+1, 아니면 right=mid-1;
            if (dfs(pStart, pEnd, mid, visit) || dfs(pEnd, pStart, mid, visit)) {
                left = mid + 1;
                // answer =
            } else {
                right = mid - 1;
            }
        }
        System.out.println(answer);
        sc.close();
    }

    public static boolean dfs(int start, int end, long val, boolean[] visit) {
        if (visit[start] == true)
            return false;
        if (start == end)
            return true;
        visit[start] = true;
        for (int i = 0; i < M; i++) {
            if (route[i][2] >= val) {
                if (dfs(route[i][1], end, val, visit))
                    return true;
            }
        }
        return false;
    }
}
