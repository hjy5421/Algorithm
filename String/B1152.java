package Algorithm.String;

import java.util.*;

public class B1152 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str = str.trim();
        if (str.isEmpty()) {
            System.out.println(0);
        } else {
            String[] word = str.split(" ");
            System.out.println(word.length);
        }
        sc.close();
    }
}
