package Algorithm.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1991 {
    static ArrayList<Character>[] tree;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            tree[root - 'A'].add(left);
            tree[root - 'A'].add(right);
        }

        preorder('A');
        System.out.println();
        order('A');
        System.out.println();
        postorder('A');
        System.out.println();

    }

    public static void preorder(char node) {
        if (node == '.')
            return;
        System.out.print(node);
        preorder(tree[node - 'A'].get(0));
        preorder(tree[node - 'A'].get(1));
    }

    public static void order(char node) {
        if (node == '.')
            return;
        order(tree[node - 'A'].get(0));
        System.out.print(node);
        order(tree[node - 'A'].get(1));
    }

    public static void postorder(char node) {
        if (node == '.')
            return;
        postorder(tree[node - 'A'].get(0));
        postorder(tree[node - 'A'].get(1));
        System.out.print(node);
    }
}
