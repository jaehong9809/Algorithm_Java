import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Main {
    static int start, end;

    static int n, m;
    static int[] d;
    static int INF = 1_000_000_000;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        start = sc.nextInt();
        end = sc.nextInt();
        n = sc.nextInt();
        m = sc.nextInt();
        d = new int[n + 1];
        Arrays.fill(d, INF);

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);

        }

        dijkstra();

        if (d[end] == INF) {
            System.out.println(-1);
            return;
        }
        
        System.out.println(d[end]);
    }

    static void dijkstra() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });
        pq.offer(new int[]{start, 0});
        d[start] = 0;

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int now = poll[0];
            int cost = poll[1];
            if (d[now]<cost)continue;


            for (int i = 0; i < graph.get(now).size(); i++) {
                int next = d[now] +1;

                if(next < d[graph.get(now).get(i)]){
                    d[graph.get(now).get(i)] = next;
                    pq.offer(new int[]{graph.get(now).get(i), next});
                }
            }
        }

    }


}