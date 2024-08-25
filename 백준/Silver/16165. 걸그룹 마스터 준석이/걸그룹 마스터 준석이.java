import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int n, m;
    static Map<String, Set<String>> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String groupName = br.readLine();
            // TreeSet 탐색 O(log n), HashSet 탐색 O(1)
            map.put(groupName, new TreeSet<>());

            int memberNum = Integer.parseInt(br.readLine());
            for (int j = 0; j < memberNum; j++) {
                map.get(groupName).add(br.readLine());
            }
        }

        for (int i = 0; i < m; i++) {
            String name = br.readLine();
            int num = Integer.parseInt(br.readLine());

            if (num == 1) {
                for (String groupName : map.keySet()) {
                    if (map.get(groupName).contains(name)) {
                        System.out.println(groupName);
                        break;
                    }
                }
            } else {

                for (String member : map.get(name)) {
                    System.out.println(member);
                }
            }
        }

    }
}