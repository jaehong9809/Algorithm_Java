import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Item[] items = new Item[n];
        int last_day = 0;
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            items[i] = new Item(a, b);
            last_day = Math.max(last_day, a);
        }
        Arrays.sort(items, (a, b) -> b.day - a.day);

        PriorityQueue<Item> pq = new PriorityQueue<>();

        int sum = 0;
        int idx = 0;
        for (int i = last_day; i > 0; i--) {
            while (idx < n && items[idx].day >= i) {
                pq.offer(items[idx++]);
            }
            if (!pq.isEmpty()) sum += pq.poll().weight;

        }
        System.out.println(sum);

    }

    static class Item implements Comparable<Item> {
        int day;
        int weight;

        public Item(int day, int weight) {
            this.day = day;
            this.weight = weight;
        }

        @Override
        public int compareTo(Item o) {
            return o.weight - this.weight;
        }
    }
}