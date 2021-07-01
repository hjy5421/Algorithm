package Function;

import java.util.*;

class OrderSorting {
    public String[] solution(String[] orders) {
        Map<String, Integer> user = new HashMap<>();
        Set<String> food = new HashSet<>();
        for (int i = 0; i < orders.length; i++) {
            String[] order = orders[i].split(" ");
            for (int j = 1; j < order.length; j++) {
                food.add(order[0] + " " + order[j]);
            }
        }

        Iterator<String> it = food.iterator();
        while (it.hasNext()) {
            String str = it.next();
            String[] order = str.split(" ");
            user.put(order[0], user.getOrDefault(order[0], 0) + 1);
        }

        String[][] result = new String[user.size()][2];
        int idx = 0;
        for (String s : user.keySet()) {
            result[idx][0] = s;
            result[idx][1] = String.valueOf(user.get(s));
            idx++;
        }

        Arrays.sort(result, new Comparator<String[]>() {
            @Override
            public int compare(String[] s1, String[] s2) {
                if (Integer.parseInt(s1[1]) == Integer.parseInt(s2[1])) {
                    return s1[0].compareTo(s2[0]);
                } else {
                    return Integer.compare(Integer.parseInt(s2[1]), Integer.parseInt(s1[1]));
                }
            }
        });

        ArrayList<String> maxUser = new ArrayList<>();
        int max = Integer.parseInt(result[0][1]);
        for (int i = 0; i < result.length; i++) {
            if (Integer.parseInt(result[i][1]) == max)
                maxUser.add(result[i][0]);
            else
                break;
        }

        String[] answer = new String[maxUser.size()];
        for (int i = 0; i < maxUser.size(); i++) {
            answer[i] = maxUser.get(i);
        }
        return answer;
    }
}