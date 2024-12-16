import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Main {
    static int n, m;
    static ArrayList<Node>[] graph;
    static int start, end;
    static int INF = (int) 1e9;
    static int[] d;
    static String[] results;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        d = new int[n + 1];
        graph = new ArrayList[n + 1];
        results = new String[n + 1];
        for (int i = 0; i <n+1; i++) {
            results[i] = "";
        }


        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        Arrays.fill(d, INF);
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph[a].add(new Node(b, c));
        }
        start = sc.nextInt();
        end = sc.nextInt();
        dijkstra();
        System.out.println(d[end]);
        System.out.println(results[end].split(" ").length);
        System.out.println(start+results[end]);
    }

    public static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        d[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int node = now.x;
            int cost = now.y;
            if (d[node] < cost) continue;

            for (int i = 0; i < graph[node].size(); i++) {
                int next = graph[node].get(i).x;
                int dist = graph[node].get(i).y + d[node];

                if (d[next] > dist) {
                    results[next] = results[node] +" "+next;
                    d[next] = dist;
                    pq.add(new Node(next, dist));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o) {
            return this.y - o.y;
        }
    }
}