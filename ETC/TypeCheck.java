package ETC;

public class TypeCheck {
    public static void main(String[] args) {
        int na = 1_000_000;
        long a = na * na;
        System.out.println(a);
        System.out.println(Integer.toBinaryString(na));
        System.out.println(Long.toBinaryString(a));
        long lb = 1_000_000;
        long b = lb * lb;
        System.out.println(b);
        System.out.println(Long.toBinaryString(lb));
        System.out.println(Long.toBinaryString(b));
    }

}
