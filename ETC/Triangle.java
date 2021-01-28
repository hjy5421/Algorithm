
import java.util.*;

class Solution {
    static ArrayList<int[]> route = new ArrayList<>();

    public static int solution(int[][] triangle) {
        int answer = 0;
        for (int i = 0; i < triangle.length; i++) {
            int[] arr = new int[triangle[i].length];
            route.add(arr);
        }
        for (int i = 0; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                int left = 0, right = 0;
                if (i - 1 >= 0 && j - 1 >= 0)
                    left = triangle[i - 1][j - 1];
                if (i - 1 >= 0)
                    right = triangle[i - 1][j];

                int retL = triangle[i][j] + left;
                int retR = triangle[i][j] + right;
                if (retL >= retR)
                    route.get(i)[j] = retL;
                else
                    route.get(i)[j] = retR;
            }
        }
        int size = route.size();
        // int max=0;
        for (int i = 0; i < route.get(size - 1).length; i++) {
            if (answer < route.get(size - 1)[i])
                answer = route.get(size - 1)[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] triangle = { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };
        int ret = solution(triangle);
        System.out.println(ret);
    }
}