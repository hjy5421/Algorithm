package ETC;

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

        List<String> route = new ArrayList<>();
        route.add("ICN STO ATL SFO ");
        route.add("ICN ATL STO SFO ");
        Collections.sort(route);
        for (int i = 0; i < route.size(); i++) {
            System.out.println(route.get(i));
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

        int n = 0;
        String s = "ddd" + n;
        System.out.println(s);

        String sss = "[403]";
        System.out.println(sss.substring(1, sss.length() - 1));
    }
}
