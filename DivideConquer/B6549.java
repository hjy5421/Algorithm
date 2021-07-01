package DivideConquer;

import java.io.*;

public class B6549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str;
        while (!(str = br.readLine()).equals("0")) {
            String[] arr = str.split(" ");
            long[] heights = new long[arr.length - 1];
            for (int i = 0; i < heights.length; i++) {
                heights[i] = Long.parseLong(arr[i + 1]);
            }
            bw.write(divide(0, heights.length - 1, heights) + "\n");
        }
        bw.flush();
    }

    public static long divide(int start, int end, long[] heights) {
        if (start > end)
            return 0;
        else if (start == end)
            return heights[start];
        else {
            int mid = (start + end) / 2;
            int l = mid, r = mid;
            long min = heights[mid];
            long ret = Math.max(divide(start, mid, heights), divide(mid + 1, end, heights));
            while (r - l < end - start) {
                long lValue = l > start ? heights[l - 1] : -1;
                long rValue = r < end ? heights[r + 1] : -1;

                if (lValue > rValue) {
                    l--;
                    min = Math.min(min, lValue);
                    ret = Math.max(ret, min * (r - l + 1));
                } else {
                    r++;
                    min = Math.min(min, rValue);
                    ret = Math.max(ret, min * (r - l + 1));
                }
            }
            return ret;
        }
    }
}
