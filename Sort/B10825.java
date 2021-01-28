package Sort;

import java.util.*;

public class B10825 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[][] scores = new String[N][4];
        for (int i = 0; i < N; i++) {
            scores[i][0] = sc.next();
            scores[i][1] = sc.next();
            scores[i][2] = sc.next();
            scores[i][3] = sc.next();
        }
        Arrays.sort(scores, new Comparator<String[]>() {
            @Override
            public int compare(String[] s1, String[] s2) {
                if (Integer.parseInt(s1[1]) == Integer.parseInt(s2[1])) {
                    if (Integer.parseInt(s1[2]) == Integer.parseInt(s2[2])) {
                        if (Integer.parseInt(s1[3]) == Integer.parseInt(s2[3])) {
                            return s1[0].compareTo(s2[0]);
                        }
                        return Integer.compare(Integer.parseInt(s2[3]), Integer.parseInt(s1[3]));
                    }
                    return Integer.compare(Integer.parseInt(s1[2]), Integer.parseInt(s2[2]));
                }
                return Integer.compare(Integer.parseInt(s2[1]), Integer.parseInt(s1[1]));
            }
        });
        for (int i = 0; i < scores.length; i++) {
            System.out.println(scores[i][0]);
        }
        sc.close();
    }
}
