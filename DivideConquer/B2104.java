package DivideConquer;

import java.util.*;

public class B2104 {
    static long[] num;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        String[] str = sc.nextLine().split(" ");
        num = new long[N + 1];
        for (int i = 1; i < num.length; i++) {
            num[i] = Long.parseLong(str[i - 1]);
        }

        System.out.println(divide(1, N, num));
        sc.close();
    }

    public static long divide(int start, int end, long[] num) {
        if (start > end)
            return 0;
        else if (start == end)
            return num[start] * num[start];
        else {
            int mid = (start + end) / 2;
            long ret = Math.max(divide(mid + 1, end, num), divide(start, mid - 1, num));

            long sum = num[mid];
            long min = num[mid];
            int l = mid, r = mid;

            while (r - l < end - start) {
                long lValue = l > start ? num[l - 1] : -1;
                long rValue = r < end ? num[r + 1] : -1;

                if (lValue > rValue) {
                    sum += lValue;
                    min = Math.min(min, lValue);
                    l--;
                } else {
                    sum += rValue;
                    min = Math.min(min, rValue);
                    r++;
                }

                ret = Math.max(ret, sum * min);
            }

            return ret;
        }
    }
}
