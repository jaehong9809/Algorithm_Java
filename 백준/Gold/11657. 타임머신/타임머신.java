import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Main {
    static int n, m;
    static int INF = Integer.MAX_VALUE;
    static ArrayList<Edge> edges = new ArrayList<>();
    static long[] d;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        d = new long[n + 1];

        Arrays.fill(d, INF);
        d[1] = 0;


        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            edges.add(new Edge(a, b, c));
        }


        for (int i = 0; i < n - 1; i++) {
            for (Edge edge : edges) {
                if (d[edge.v] != INF && d[edge.w] > d[edge.v] + edge.cost) {
                    d[edge.w] = d[edge.v] + edge.cost;
                }
            }
        }


        for (Edge edge : edges) {
            if (d[edge.v] != INF && d[edge.w] > d[edge.v] + edge.cost) {
                System.out.println(-1);
                return;
            }
        }


        for (int i = 2; i <= n; i++) {
            if (d[i] == INF) {
                System.out.println(-1);
            } else {
                System.out.println(d[i]);
            }
        }
    }

    static class Edge {
        int v, w;
        int cost;

        public Edge(int v, int w, int cost) {
            this.v = v;
            this.w = w;
            this.cost = cost;
        }
    }
}