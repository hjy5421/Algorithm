package DfsBfs;

import java.util.*;

class B13023 {
    static int[][] friends;
    static int answer = 0;

    public static void solution(int[][] relation, int n, int m) {
        // int answer=0;
        friends = new int[2001][2001];
        for (int i = 0; i < m; i++) {
            int n1 = relation[i][0];
            int n2 = relation[i][1];
            friends[n1][n2] = friends[n2][n1] = 1;
        }

        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            if (friends[i][i + 1] == 1)
                count++;
        }

        if (count == n - 1)
            answer = 1;
        // return answer;
    }

    public static void main(String[] args) {
        // System.out.println("start");
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] relation = new int[M][2];
        for (int i = 0; i < M; i++) {
            relation[i][0] = sc.nextInt();
            relation[i][1] = sc.nextInt();
        }

        solution(relation, N, M);
        // System.out.println("ans : ");
        System.out.println(answer);
        sc.close();
    }
}
