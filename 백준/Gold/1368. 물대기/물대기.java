import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {
    static int n;
    static int[][] matrix;
    static int[] cost;
    static int[] d;
    static int[] parent;
    static ArrayList<Edge> edges = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        d = new int[n + 1];
        visited =new boolean[n+1];
        cost = new int[n + 1];
        parent = new int[n + 1];
        Arrays.fill(parent, -1);

        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            cost[i] = Integer.parseInt(br.readLine());
            edges.add(new Edge(0, i, cost[i]));
            min = Math.min(cost[i], min);
        }

        matrix = new int[n + 1][n + 1];
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                edges.add(new Edge(i, j, Math.min(matrix[i][j], matrix[j][i])));
            }
        }
        Collections.sort(edges);
        int sum = 0;
        int cnt = 0;
        for (Edge edge : edges) {
            if (union(edge.start, edge.end)) {
                sum+=edge.cost;
                cnt++;
                if (cnt == n) break;
            }
        }
        System.out.println(sum);
    }

    static int findParent(int x) {
        if (parent[x] < 0) return x;

        return parent[x] = findParent(parent[x]);
    }

    static boolean union(int x, int y) {
        int rootx = findParent(x);
        int rooty = findParent(y);
        if (rootx == rooty) return false;
        if (rootx < rooty) {
            parent[rootx] += parent[rooty];
            parent[rooty] = rootx;
        } else {
            parent[rooty] += parent[rootx];
            parent[rootx] = rooty;
        }
        return true;
    }

    static class Edge implements Comparable<Edge> {
        int start, end, cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}