import java.util.*;

class Main {
    static int[] road = new int[100000 + 1];
    static int[] prev = new int[100000 + 1];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();


        Queue<Integer> q = new ArrayDeque<>();
        q.offer(n);

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == k) {
                System.out.println(road[now]);
                List<Integer> path = new ArrayList<>();
                for (int i = k; i != n; i = prev[i]) {
                    path.add(i);
                }
                path.add(n);
                Collections.reverse(path);
                for (int p : path) {
                    System.out.print(p + " ");
                }
                break;
            }

            if (now + 1 <= 100000 && (road[now + 1] == 0 || road[now] + 1 < road[now + 1])) {
                road[now + 1] = road[now] + 1;
                prev[now+1] = now;
                q.offer(now + 1);
            }

            if (now - 1 >= 0 && (road[now - 1] == 0 || road[now] + 1 < road[now - 1])) {
                road[now - 1] = road[now] + 1;
                prev[now-1] = now;
                q.offer(now - 1);
            }

            if (now * 2 <= 100000 && (road[now * 2] == 0 || road[now] + 1 < road[now * 2])) {
                road[now * 2] = road[now] + 1;
                prev[now*2] = now;
                q.offer(now * 2);
            }
        }
    }
}
