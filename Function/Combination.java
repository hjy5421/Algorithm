package Function;

public class Combination { // 3개를 뽑을 경우
    static int n = 5; // input 배열 길이
    static int r = 3; // 선택하고자 하는 개수
    static int[] input = { 1, 2, 3, 4, 5 };
    static int[] result = new int[r]; // 정답을 담을 배열

    public static void main(String[] args) {
        System.out.println("조합");
        combination(n, r, 0, 0);
        System.out.println("중복조합");
        reCombination(n, r, 0, 0);
    }

    // 조합 (순서관심없고 뽑은 유무만 생각)
    private static void combination(int n, int r, int index, int depth) {
        if (depth == r) {
            print(); // 결과값 출력
            return;
        }
        if (index == n)
            return;

        // 1. 정답 입력
        result[depth] = input[index];
        // 2. 다음 단계로 이동
        combination(n, r, index + 1, depth + 1);// 뽑는경우
        combination(n, r, index + 1, depth);// 안뽑는경우
    }

    // 중복 조합 (순서관심없고 뽑은 유무만 생각 + 자기자신도 포함)
    private static void reCombination(int n, int r, int index, int depth) {
        // 3. 유망성 체크
        if (depth == r) {
            print();
            return;
        }
        if (index == n) {
            return;
        }
        // 1. 정답을 입력
        result[depth] = input[index];
        // 2. 다음 단계
        reCombination(n, r, index, depth + 1);
        reCombination(n, r, index + 1, depth);

    }

    private static void print() {
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }
}
