import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Main {
    static int n, m, t;
    static ArrayList<Edge> edges = new ArrayList<>();
    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        t = sc.nextInt();
        parent = new int[n + 1];
        Arrays.fill(parent, -1);
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            edges.add(new Edge(a, b, c));
        }
        Collections.sort(edges, (a, b) -> a.w - b.w);
        int cnt = 0;
        int sum = 0;
        for (Edge edge : edges) {
            if (union(edge.x, edge.y)) {
                sum += edge.w + (cnt * t);
                cnt++;
            }
            if (cnt == n - 1) break;
        }
        System.out.println(sum);
    }

    static int find(int x) {
        if (parent[x] < 0) return x;

        return parent[x] = find(parent[x]);
    }

    static boolean union(int a, int b) {
        int roota = find(a);
        int rootb = find(b);

        if (roota == rootb) return false;
        parent[roota] += parent[rootb];
        parent[rootb] = roota;
        return true;
    }


    static class Edge {
        int x, y;
        int w;

        public Edge(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }
}