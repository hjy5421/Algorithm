package DfsBfs;

import java.io.*;
import java.util.StringTokenizer;

public class B1012 {
    static int N;
    static int M;
    static int[][] cab;
    static boolean[][] visit;
    static int[][] move = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] arr = br.readLine().split(" ");
            M = Integer.parseInt(arr[0]);
            N = Integer.parseInt(arr[1]);
            int K = Integer.parseInt(arr[2]);
            cab = new int[N][M];
            visit = new boolean[N][M];
            for (int j = 0; j < K; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                cab[y][x] = 1;
            }

            int answer = 0;
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (cab[r][c] == 1 && !visit[r][c]) {
                        dfs(r, c);
                        answer++;
                    }
                }
            }

            System.out.println(answer);
        }
    }

    public static void dfs(int r, int c) {
        visit[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int nr = r + move[i][0];
            int nc = c + move[i][1];
            if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                if (!visit[nr][nc] && cab[nr][nc] == 1)
                    dfs(nr, nc);
            }

        }

    }

}
