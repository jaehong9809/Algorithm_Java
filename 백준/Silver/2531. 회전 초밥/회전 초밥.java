import java.util.*;

class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, d, k, c;
        n = sc.nextInt();
        d = sc.nextInt();
        k = sc.nextInt();
        c = sc.nextInt();

        int[] foods = new int[n];

        for (int i = 0; i < n; i++) {
            foods[i] = sc.nextInt();
        }

        int max = -1;

        Map<Integer, Integer> map = new HashMap<>();


        int cnt = 0;
        for (Integer food : foods) {
            map.put(food, map.getOrDefault(food, 0) + 1);
            cnt++;
            if (cnt == k) break;
        }
        map.put(c, map.getOrDefault(c, 0) + 1);

        max = Math.max(max, map.size());

        map.put(c, map.getOrDefault(c, 0) - 1);

        if (map.get(c) == 0) map.remove(c);

        for (int i = 1; i < n; i++) {
            int last = foods[i - 1];
            int index = i + k - 1;

            if (index >= n) {
                index -= n * (index / n);
            }

            map.put(foods[index], map.getOrDefault(foods[index], 0) + 1);
            map.put(last, map.getOrDefault(last, 0) - 1);

            if (map.get(last) == 0) map.remove(last);

            map.put(c, map.getOrDefault(c, 0) + 1);

            max = Math.max(max, map.size());

            map.put(c, map.getOrDefault(c, 0) - 1);

            if (map.get(c) == 0) map.remove(c);
        }

        System.out.println(max);
    }
}