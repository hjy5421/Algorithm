package Greedy;

import java.util.*;

public class B1541 {
    static List<String> math = new ArrayList<>();
    static List<Integer> result = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int last = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '+' || str.charAt(i) == '-') {
                math.add(str.substring(last, i));
                math.add(str.substring(i, i + 1));
                last = i + 1;
            }
            if (i == str.length() - 1) {
                math.add(str.substring(last, str.length()));
            }
        }

        calculate(0, math.size());
        int answer = result.get(0);
        for (int i = 1; i < result.size(); i++) {
            answer -= result.get(i);
        }
        System.out.println(answer);
    }

    public static void calculate(int start, int end) {
        int ret = 0;
        for (int i = start; i < end; i++) {
            if (math.get(i).equals("-")) {
                result.add(ret);
                calculate(i + 1, end);
                return;
            } else {
                if (!math.get(i).equals("+")) {
                    ret += Integer.parseInt(math.get(i));
                }
            }
        }
        result.add(ret);
    }

}
