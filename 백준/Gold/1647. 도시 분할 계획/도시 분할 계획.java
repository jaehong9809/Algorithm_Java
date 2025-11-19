import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {
    static int n, m;
    static ArrayList<Node> graph = new ArrayList<>();
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = -1;
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.add(new Node(a, b, c));
        }

        Collections.sort(graph);
        int cnt=0;
        int sum=0;
        int max = 0;
        for (Node node : graph) {

            int x = node.x;
            int y = node.y;
            int w = node.w;
            if (find(x) != find(y)) {
                cnt++;
                union(x, y);
                sum+=w;
                max = Math.max(max, w);
            }
            if (cnt == n - 1) {
                break;
            }
        }

        System.out.println(sum-max);
    }

    static int find(int x) {
        if (parent[x] < 0) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        int rootx = find(x);
        int rooty = find(y);

        if(rootx == rooty) return;

        parent[rootx] += parent[rooty];
        parent[rooty] = rootx;
    }

    static class Node implements Comparable<Node> {
        int x, y;
        int w;

        public Node(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
}