package Implementation;

import java.io.*;
import java.util.*;

public class B1417 {
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int elect = Integer.parseInt(br.readLine());
        int[] vote = new int[N - 1];
        for (int i = 0; i < vote.length; i++) {
            vote[i] = Integer.parseInt(br.readLine());
        }

        if (N == 1) {
            System.out.println(answer);
            return;
        }

        while (true) {
            Arrays.sort(vote);
            if (elect > vote[vote.length - 1])
                break;
            elect++;
            answer++;
            vote[vote.length - 1]--;
        }
        System.out.println(answer);
    }
}
