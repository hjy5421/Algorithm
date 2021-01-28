package TwoPointer;

import java.util.*;

public class B2003 {
    public static int solution(int[] num, int M) {
        int answer = 0;
        int start = 0;
        int end = 0;
        int sum = 0;
        while (start <= end) {
            if (sum >= M) {
                sum -= num[start];
                start++;
            } else if (end == num.length) {
                break;
            } else {
                sum += num[end];
                end++;
            }
            if (sum == M)
                answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = sc.nextInt();
        }
        sc.close();
        int answer = solution(num, M);
        System.out.println(answer);
    }
}
