package PriorQueue;

import java.util.*;

public class B1927 {
    static ArrayList<Integer> answer = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int input = sc.nextInt();
            if (input > 0)
                pq.offer(input);
            else if (input == 0) {
                if (pq.isEmpty())
                    answer.add(0);
                else
                    answer.add(pq.poll());
            }
        }

        for (int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i));
        }
    }
}
