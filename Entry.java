import java.util.*;

public class Entry {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long answer = Long.MAX_VALUE;
        long left = 1;
        long right = n * (long) times[times.length - 1];
        long mid = 0;
        while (right >= left) {
            mid = (left + right) / 2;
            if (isPossible(mid, n, times)) {
                answer = answer > mid ? mid : answer;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }

    public boolean isPossible(long mid, int n, int[] times) {
        long ret = 0;
        for (int i = 0; i < times.length; i++) {
            ret += mid / times[i];
        }
        if (ret >= n)
            return true;
        else
            return false;
    }
}
