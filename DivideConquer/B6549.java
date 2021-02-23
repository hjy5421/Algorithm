package DivideConquer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B6549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;
        while (!(str = br.readLine()).equals("0")) {
            String[] arr = str.split(" ");
            long[] heights = new long[arr.length - 1];
            for (int i = 0; i < arr.length; i++) {
                heights[i] = Long.parseLong(arr[i + 1]);
            }
            // divide
        }
    }

    public static void solve(long[] heights) {

    }
}
