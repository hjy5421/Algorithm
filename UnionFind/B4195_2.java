package Algorithm.UnionFind;

import java.util.*;

public class B4195_2 {
    static int[] parent;
    static int[] count;
    static ArrayList<Integer> answer = new ArrayList<>();

    public static void print() {
        System.out.print("parent : ");
        for (int i = 1; i < parent.length; i++) {
            System.out.print(parent[i] + " ");
        }
        System.out.println();
        System.out.print("count : ");
        for (int i = 1; i < count.length; i++) {
            System.out.print(count[i] + " ");
        }
        System.out.println();
    }

    public static void set() {
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            count[i] = 1;
        }
    }

    public static int find(int n) {
        if (parent[n] == n)
            return n;
        else
            return parent[n] = find(parent[n]);
    }

    public static void union(int n1, int n2) {
        n1 = find(n1);
        print();
        n2 = find(n2);
        print();
        if (n1 == n2)
            return;
        else {
            if (n1 > n2) {
                parent[n1] = n2;
                count[n2] += count[n1];
            } else {
                parent[n2] = n1;
                count[n1] += count[n2];
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int F = sc.nextInt();
            Map<String, Integer> hm = new HashMap<>();
            parent = new int[F * 2 + 1];
            count = new int[F * 2 + 1];
            set();

            for (int j = 0; j < F; j++) {
                String s1 = sc.next();
                hm.put(s1, hm.getOrDefault(s1, hm.size() + 1));
                String s2 = sc.next();
                hm.put(s2, hm.getOrDefault(s2, hm.size() + 1));
                union(hm.get(s1), hm.get(s2));
                int p1 = parent[hm.get(s1)];
                int p2 = parent[hm.get(s2)];
                if (p1 < p2)
                    answer.add(count[p1]);
                else
                    answer.add(count[p2]);
            }
        }

        for (int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i));
        }
        sc.close();

    }
}
