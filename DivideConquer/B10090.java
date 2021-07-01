package DivideConquer;

import java.util.*;

public class B10090 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] arr = sc.nextLine().split(" ");
        int[] num = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            num[i] = Integer.parseInt(arr[i]);
        }
        System.out.println(divide(0, n - 1, num, 0));
    }

    public static int divide(int start, int end, int[] num, int inv) {
        System.out.println(start + " " + end + " " + inv);
        if (start > end)
            return 0;
        if (start == end)
            return 0;
        int mid = (start + end) / 2;
        int left = start, right = end;
        int ret = 0;
        ret += divide(start, mid, num, inv);
        System.out.println("ret 1: " + ret);
        ret += divide(mid + 1, end, num, inv);
        System.out.println("ret 2: " + ret);
        while (left < right) {
            if (num[left] > num[right]) {
                left++;
                ret++;
            } else {
                right--;
            }
        }
        inv += ret;
        System.out.println("ret final: " + ret);
        System.out.println("inv: " + inv);
        return inv;
    }
}
