import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static String[] mbti = new String[]{
            "ISTJ", "ISFJ", "INFJ", "INTJ",
            "ISTP", "ISFP", "INFP", "INTP",
            "ESTP", "ESFP", "ENFP", "ENTP",
            "ESTJ", "ESFJ", "ENFJ", "ENTJ"
    };

    static String[] arr = new String[3];

    static List<Node> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        func(0);

        Collections.sort(list, (a, b) -> {
            return a.cnt - b.cnt;
        });

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");
            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                map.put(s[i], map.getOrDefault(s[i], 0)+1);
            }
            for (Node node : list) {
                Map<String, Integer> tmp = node.map;
                boolean sign = true;
                for (String string : tmp.keySet()) {
                    if(!map.containsKey(string) ){
                        sign=false;
                        break;
                    }
                    if(map.get(string) <tmp.get(string)){
                        sign = false;
                        break;
                    }
                }
                if(sign){
                    System.out.println(node.cnt);
                    break;
                }
            }
        }

    }

    static void func(int depth) {
        if (depth == 3) {
            int cnt = 0;
            for (int i = 0; i < 4; i++) {
                if (arr[0].charAt(i) != arr[1].charAt(i)) {
                    cnt++;
                }
                if (arr[1].charAt(i) != arr[2].charAt(i)) {
                    cnt++;
                }
                if (arr[2].charAt(i) != arr[0].charAt(i)) {
                    cnt++;
                }
            }
            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 0; i < 3; i++) {
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }
            list.add(new Node(cnt, map));
            return;
        }

        for (int i = 0; i < 16; i++) {
            arr[depth] = mbti[i];
            func(depth + 1);
        }
    }


    static class Node {
        int cnt;
        Map<String, Integer> map;

        public Node(int cnt, Map<String, Integer> map) {
            this.cnt = cnt;
            this.map = map;
        }

    }
}