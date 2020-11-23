package Algorithm;

import java.util.*;
import java.io.*;

public class B1717 {
    static int[] parent;
    static ArrayList<String> answer = new ArrayList<>();

    public static int find(int num) {
        if (parent[num] == num)
            return num;
        else {
            System.out.println("find : " + num + " " + parent[num]);
            return parent[num] = find(parent[num]);
        }
    }

    public static boolean isSame(int num1, int num2) {
        num1 = find(num1);
        num2 = find(num2);
        if (num1 == num2)
            return true;
        else
            return false;
    }

    public static void union(int num1, int num2) {
        num1 = find(num1);
        num2 = find(num2);
        if (num1 != num2) {
            if (num1 > num2)
                parent[num1] = num2;
            else
                parent[num2] = num1;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        // System.out.println(n);
        // System.out.println(m);

        parent = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int token = Integer.parseInt(st.nextToken());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            if (token == 0) {
                union(num1, num2);
            } else {
                if (isSame(num1, num2) == true)
                    answer.add("YES");
                else
                    answer.add("NO");
            }
        }

        for (int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i));
        }
    }

}
