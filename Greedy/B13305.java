package Greedy;

import java.io.*;
import java.util.*;

public class B13305 {
    static long[] price;
    static long[] distance;
    static long[] min; // price 오름차순 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] sd = br.readLine().split(" ");
        String[] sp = br.readLine().split(" ");
        distance = new long[N - 1];
        price = new long[N - 1];
        min = new long[N - 1];
        for (int i = 0; i < N - 1; i++) {
            distance[i] = Long.parseLong(sd[i]);
            price[i] = Long.parseLong(sp[i]);
            min[i] = price[i];
        }

        Arrays.sort(min);

        long cost = 0;
        for (int i = 0; i < distance.length; i++) {
            if (price[i] == min[0]) {
                for (int j = i; j < distance.length; j++) {
                    cost += (price[i] * distance[j]);
                }
                break;
            } else {
                int rank = find(price[i]);
                for (int j = i; j < distance.length; j++) {
                    if (price[j] < min[rank]) {
                        i = j - 1;
                        break;
                    } else {
                        cost += (price[i] * distance[j]);
                    }
                }
            }
        }

        System.out.println(cost);

        // 간단풀이
        long sum = 0;
        long lastOil = Long.MAX_VALUE;
        int index = 0;
        while (index < N - 1) {
            if (lastOil > price[index]) {
                lastOil = price[index];
            }
            sum += (lastOil * distance[index]);
            index++;
        }
        System.out.println(sum);
    }

    public static int find(long p) {
        int ret = 0;
        for (int i = 0; i < min.length; i++) {
            if (p == min[i]) {
                ret = i;
                break;
            }
        }
        return ret;
    }
}
