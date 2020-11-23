package Algorithm;

import java.io.*;
import java.util.*;

public class B4195 {
    static Map<String, Integer> hm = new HashMap<>();
    static int[] parent;
    static int[] count;
    static ArrayList<Integer> answer = new ArrayList<>();

    public static void make() {
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    public static int find(int n) {
        if (parent[n] == n)
            return n;
        else
            return parent[n] = find(parent[n]);
    }

    public static void union(String s1, String s2) {
        int n1 = hm.get(s1);
        int n2 = hm.get(s2);
        n1 = find(n1);
        n2 = find(n2);

        if (n1 != n2) {
            if (n1 > n2) {
                parent[n1] = n2;
                count[n2] += count[n1];
            } else {
                parent[n2] = n1;
                count[n1] += count[n2];
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int F = sc.nextInt();
            count = new int[F * 2 + 1];
            parent = new int[F * 2 + 1];
            make();
            Arrays.fill(count, 1);
            for (int j = 0; j < F; j++) {
                String s1 = sc.next();
                hm.put(s1, hm.getOrDefault(s1, hm.size() + 1));

                String s2 = sc.next();
                hm.put(s2, hm.getOrDefault(s2, hm.size() + 1));

                union(s1, s2);
                answer.add(count[find(hm.get(s1))]);
            }
            hm.clear();
        }

        for (int k = 0; k < answer.size(); k++) {
            System.out.println(answer.get(k));
        }

    }
}
