import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Map<String, PriorityQueue<Integer>> map = new HashMap<>();

        long sum = 0;
        while (n-- > 0) {
            String s = br.readLine();
            String[] arr = s.split(" ");
            if (arr[0].equals("1")) {
                if (map.containsKey(arr[1])) {
                    PriorityQueue<Integer> pq = map.get(arr[1]);
                    for (int i = 3; i < arr.length; i++) {
                        pq.add(Integer.parseInt(arr[i]));
                    }
                } else {
                    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
                    for (int i = 3; i < arr.length; i++) {
                        pq.add(Integer.parseInt(arr[i]));
                    }
                    map.put(arr[1], pq);
                }
            } else {
                if (!map.containsKey(arr[1])) continue;
                for (int i = 0; i < Integer.parseInt(arr[2]); i++) {
                    if (map.get(arr[1]).isEmpty()) break;
                    sum += map.get(arr[1]).poll();
                }
            }
        }
        System.out.println(sum);
    }
}