package Algorithm.Tree;

import java.util.*;
import java.io.*;

public class B2263 {
    static int[] in;
    static int[] post;
    static int[] position;
    static int n;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        in = new int[n + 1];
        post = new int[n + 1];

        String s1 = br.readLine();
        StringTokenizer st = new StringTokenizer(s1);
        for (int i = 1; i < n + 1; i++) {
            in[i] = Integer.parseInt(st.nextToken());
        }
        String s2 = br.readLine();
        st = new StringTokenizer(s2);
        for (int i = 1; i < n + 1; i++) {
            post[i] = Integer.parseInt(st.nextToken());
        }

        position = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            int tmp = in[i];
            position[tmp] = i;
        }
        search(1, n, 1, n);
        System.out.println();
    }

    public static void search(int is, int ie, int ps, int pe) {
        if (is > ie || ps > pe)
            return;
        int root = post[pe];
        System.out.print(root + " ");
        int rootPt = position[root];
        int leftCnt = rootPt - is;
        search(is, rootPt - 1, ps, ps + leftCnt - 1);
        search(rootPt + 1, ie, ps + leftCnt, pe - 1);
    }
}
