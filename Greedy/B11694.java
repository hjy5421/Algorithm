package Greedy;

import java.util.*;

public class B11694 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int[] stone = new int[N];
        String[] arr = sc.nextLine().split(" ");
        for (int i = 0; i < arr.length; i++) {
            stone[i] = Integer.parseInt(arr[i]);
        }

        Arrays.sort(stone);
        int now = stone.length - 1;
        int turn = 0;
        while (isLeft(stone)) {
            if (now == 0) {
                if (stone[now] > 1) {
                    stone[now] = 1;
                } else {
                    stone[now]--;
                }
            } else {
                stone[now] = 0;
                now--;
            }
            turn++;
        }

        if (turn % 2 == 0) {
            System.out.println("koosaga");
        } else {
            System.out.println("cubelover");
        }
    }

    public static boolean isLeft(int[] stone) {
        boolean left = false;
        for (int i = 0; i < stone.length; i++) {
            if (stone[i] > 0) {
                left = true;
                break;
            }
        }
        return left;
    }
}
