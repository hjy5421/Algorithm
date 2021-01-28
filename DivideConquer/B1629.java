package DivideConquer;

import java.io.*;

public class B1629 {
    static long A;
    static long B;
    static long C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        A = Long.parseLong(arr[0]);
        B = Long.parseLong(arr[1]);
        C = Long.parseLong(arr[2]);

        long answer = divide(B);
        System.out.println(answer);
    }

    public static long divide(long num) {
        if (num == 1) {
            return A % C;
        }

        long mul = divide(num / 2) % C;
        if (num % 2 > 0) {
            return (((mul * mul) % C) * A) % C;
        } else {
            return (mul * mul) % C;
        }
    }
}
