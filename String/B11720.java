package Algorithm.String;

import java.util.*;

public class B11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String num = sc.next();
        int sum = 0;
        for (int i = 0; i < num.length(); i++) {
            sum += (int) (num.charAt(i) - '0');
        }
        System.out.println(sum);
        sc.close();
    }
}