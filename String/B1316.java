package Algorithm.String;

import java.util.*;

public class B1316 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = sc.next();
        }
        sc.close();

        int answer = 0;
        for (int i = 0; i < words.length; i++) {
            int[] alph = new int[26];
            int idx = -1;
            int pidx = -1;
            boolean isgroup = true;
            for (int j = 0; j < words[i].length(); j++) {
                idx = words[i].charAt(j) - 'a';
                if (pidx == -1 || idx == pidx || alph[idx] == 0)
                    alph[idx]++;
                else {
                    isgroup = false;
                    break;
                }
                pidx = idx;
            }

            if (isgroup == true)
                answer++;
        }
        System.out.println(answer);
    }
}
