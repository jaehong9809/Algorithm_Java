import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] data = new int[n+1];
            for (int i = 1; i <= n; i++) {
                data[i] = sc.nextInt();
            }

            PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());
            PriorityQueue<Integer> right = new PriorityQueue<>();
            ArrayList<Integer> result = new ArrayList<>();

            if(n<=2){
                sb.append(1).append("\n").append(data[1]).append("\n");
                continue;
            }

            for (int i =1; i <= n; i++) {
                int num = data[i];

                if (left.isEmpty()|| num <= left.peek()) {
                    left.offer(num);
                } else {
                    right.offer(num);
                }

                if (left.size() > right.size() + 1) {
                    right.offer(left.poll());
                }
                else if (right.size() > left.size()) {
                    left.offer(right.poll());
                }

                if (i % 2 == 1) {
                    result.add(left.peek());
                }
            }

            sb.append(result.size()).append("\n");
            for (int i = 0; i < result.size(); i++) {
                sb.append(result.get(i)).append(" ");
                if ((i + 1) % 10 == 0) {
                    sb.append("\n");
                }
            }
            if (result.size() % 10 != 0) {
                sb.append("\n");
            }
        }

        System.out.print(sb.toString());
    }
}