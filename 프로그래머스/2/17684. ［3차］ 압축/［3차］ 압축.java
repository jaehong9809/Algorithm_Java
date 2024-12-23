import java.util.*;

class Solution {


    public int[] solution(String msg) {
        Map<Character, Map<String, Integer>> map = new HashMap<>();

        for (int i = 0; i < 26; i++) {
            map.put((char) ('A' + i), new TreeMap<>((a, b) -> {
                if (a.length() == b.length()) return a.compareTo(b);
                return b.length() - a.length();
            }));
        }

        List<Integer> results = new ArrayList<>();
        int index = 27;

        while (msg.length() >= 1) {
            Map<String, Integer> tmpMap = map.get(msg.charAt(0));
            boolean sign = false;
            String str = "";

            for (String key : tmpMap.keySet()) {
                if (msg.startsWith(key)) {
                    sign = true;
                    str = key;
                    break;
                }
            }

            if (!sign) {
                results.add((int) msg.charAt(0) - 'A' + 1);
                if (msg.length() >= 2) {
                    map.get(msg.charAt(0)).put(msg.substring(0, 2), index++);
                }
                msg = msg.substring(1);
            } else {
                results.add(tmpMap.get(str));
                if (msg.length() > str.length()) {
                    map.get(msg.charAt(0)).put(msg.substring(0, str.length() + 1), index++);
                }
                msg = msg.substring(str.length());
            }


        }
        int[] answer = new int[results.size()];

        for (int i = 0; i < results.size(); i++) {
            answer[i] = results.get(i);
        }
        return answer;
    }
}
