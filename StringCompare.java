package Algorithm;

import java.util.*;

public class StringCompare {
    public static void main(String[] args) {
        String[] arr = new String[3];
        arr[0] = "2020-07-22";
        arr[1] = "2019-11-23";
        arr[2] = "2019-09-01";

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        Map<String, String> hm = new HashMap<>();
        hm.put("key1", "value1");
        hm.put("key2", "value2");
        hm.put("key3", "value3");

        Set<String> set = hm.keySet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            String s = (String) it.next();
            System.out.println(hm.get(s));
        }
    }
}
