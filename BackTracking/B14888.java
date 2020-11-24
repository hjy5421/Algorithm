package Algorithm.BackTracking;

import java.util.*;

public class B14888 {
    static int N;
    static int[] number;
    static int[] op;
    static ArrayList<Integer> answer = new ArrayList<>();
    static ArrayList<Integer> opList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        number = new int[N];
        op = new int[N - 1];
        for (int i = 0; i < N; i++) {
            number[i] = sc.nextInt();
        }

        int idx = 0;
        for (int i = 0; i < 4; i++) {
            // 0:+,1:-,2:x,3:/
            int opCnt = sc.nextInt();
            for (int j = idx; j < idx + opCnt; j++) {
                op[j] = i;
            }
            idx += opCnt;
        }

        for (int i = 0; i < op.length; i++) {
            boolean[] visit = new boolean[op.length];
            dfs(visit, i, 1);
            opList.clear();
        }

        Collections.sort(answer);
        System.out.println(answer.get(answer.size() - 1));
        System.out.println(answer.get(0));
        sc.close();
    }

    public static void dfs(boolean[] visit, int cur, int count) {
        visit[cur] = true;
        opList.add(op[cur]);
        if (count == N - 1) {
            calculate();
            return;
        }

        for (int i = 0; i < visit.length; i++) {
            if (visit[i] == false) {
                dfs(visit, i, count + 1);
                visit[i] = false;
                opList.remove(opList.size() - 1);
            }
        }

    }

    public static void calculate() {
        int sum = number[0];
        for (int i = 0; i < opList.size(); i++) {
            if (opList.get(i) == 0)
                sum += number[i + 1];
            else if (opList.get(i) == 1)
                sum -= number[i + 1];
            else if (opList.get(i) == 2)
                sum *= number[i + 1];
            else
                sum /= number[i + 1];
        }
        answer.add(sum);
    }
}
