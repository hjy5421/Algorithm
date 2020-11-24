package Algorithm.String;

import java.util.*;

public class B1157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] alpa = new int[26];
        String word = sc.next();
        sc.close();
        for (int i = 0; i < word.length(); i++) {
            int idx = -1;
            if (word.charAt(i) >= 97)
                idx = word.charAt(i) - 'a';
            else if (word.charAt(i) >= 65)
                idx = word.charAt(i) - 'A';
            alpa[idx]++;
        }
        int max = 0;
        int maxCnt = 0;
        int maxIdx = 0;

        for (int j = 0; j < alpa.length; j++) {
            if (max < alpa[j])
                max = alpa[j];
        }

        for (int j = 0; j < alpa.length; j++) {
            if (alpa[j] == max) {
                maxIdx = j;
                maxCnt++;
            }
        }

        if (maxCnt > 1) {
            System.out.println("?");
        } else {
            System.out.println((char) (maxIdx + 'A'));
        }

    }
}
