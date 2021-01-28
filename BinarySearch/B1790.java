package BinarySearch;

import java.util.*;

public class B1790 {
    static int N = 0, k = 0;
    static ArrayList<Character> number = new ArrayList<>();
    int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        k = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(String.valueOf(i));
        }
        // System.out.println(sb.toString());

        if (sb.length() < k) {
            System.out.println(-1);
        } else {
            int left = 0;
            int right = sb.length();
            int mid = (left + right) / 2;

            while (left <= k - 1 && right >= k - 1) {
                if (mid > k - 1)
                    right = mid - 1;
                else if (mid < k - 1)
                    left = mid + 1;
                else
                    right = left = mid;
            }
            System.out.println(left + " " + mid + " " + right);

            for (int i = left; i <= right; i++) {
                number.add(sb.charAt(i));
            }

            System.out.println(number.get(k - 1 - left));
        }
        sc.close();
    }
}
