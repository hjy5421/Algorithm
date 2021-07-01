package ETC;

/*
투에모스 문자열
*/
public class Lotte1 {
    public static void main(String[] args) {
        int n = 30;
        long x = (long) Integer.MAX_VALUE - 10000;
        long y = x + 1000;
        System.out.println(solution(n, x, y));
    }

    public static String solution(int n, long x, long y) {
        String answer = "";
        String preMos = "01";
        if (n == 1) {
            preMos = "0";
            answer = preMos.substring((int) x - 1, (int) y);
            return answer;
        }
        if (n == 2) {
            preMos = "01";
            answer = preMos.substring((int) x - 1, (int) y);
            return answer;
        }

        for (int i = 3; i <= n; i++) {
            System.out.println(i);
            StringBuilder sb = new StringBuilder();
            sb.append(preMos);
            sb.append(findOp(preMos));
            preMos = sb.toString();
            System.out.println(preMos);
        }
        answer = preMos.substring((int) x - 1, (int) y);
        return answer;

    }

    public static String findOp(String s) {
        int len = s.length();
        long n = Long.parseLong(s, 2);
        long op = (long) Math.pow(2, len) - 1 - n;
        return Long.toBinaryString(op);
    }
}
