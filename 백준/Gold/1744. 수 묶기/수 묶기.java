import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> minus = new PriorityQueue<>();
        PriorityQueue<Integer> plus = new PriorityQueue<>(Comparator.reverseOrder());

        int zero = 0;

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            if (a < 0) {
                minus.add(a);
            } else if (a > 0) {
                plus.add(a);
            } else {
                zero++;
            }
        }

        int sum = 0;

        while (!minus.isEmpty()) {
            if (minus.size() >= 2) {
                sum += minus.poll() * minus.poll();
            } else {
                if (zero == 0) sum += minus.poll();
                else minus.poll();
            }
        }

        while (!plus.isEmpty()) {
            if (plus.size() >= 2) {
                int a = plus.poll();
                int b = plus.poll();
                if (b == 1) {
                    sum += a + b;
                } else {
                    sum += a * b;
                }
            } else {
                sum += plus.poll();
            }
        }

        System.out.println(sum);
    }
}