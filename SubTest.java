package Algorithm;

import java.util.*;

public class SubTest {
    public void test() {
        Set<Integer> set = new HashSet<>();
        set.add(9);
        set.add(8);
        Iterator it = set.iterator();
        while (it.hasNext()) {
            int n = (int) it.next();
        }
    }

    public static void main(String[] args) {
        int n1 = 9;
        int n2 = 11;
        System.out.println(n1 - n2);
    }
}
