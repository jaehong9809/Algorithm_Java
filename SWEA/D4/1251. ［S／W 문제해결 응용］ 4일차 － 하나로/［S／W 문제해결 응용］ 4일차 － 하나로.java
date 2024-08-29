import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Solution {
    static int v;
    static double e;
    static int[] parents;
    static ArrayList<Edge> edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int TESTCASE = 1; TESTCASE <= T; TESTCASE++) {
            v = Integer.parseInt(br.readLine());
            edges = new ArrayList<>();
            ArrayList<int[]> nodes = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < v; i++) {
                nodes.add(new int[]{Integer.parseInt(st.nextToken()), 0});
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < v; i++) {
                nodes.get(i)[1] = Integer.parseInt(st.nextToken());
            }

            e = Double.parseDouble(br.readLine());

            make();

            for (int i = 0; i < v - 1; i++) {

                for (int j = i + 1; j < v; j++) {
                    edges.add(new Edge(i, j, Math.pow(nodes.get(i)[0] - nodes.get(j)[0], 2) + Math.pow(nodes.get(i)[1] - nodes.get(j)[1], 2)));
                }
                

            }

            double sum = 0;
            int cnt = 0;
            Collections.sort(edges, (a, b) -> Double.compare(a.weight, b.weight));

            for (Edge edge : edges) {
                if (union(edge.start, edge.end)) {
                    cnt++;
                    sum += edge.weight * e;
                    if (cnt == v - 1) break;

                }
            }
            System.out.println("#" + TESTCASE + " " + Math.round(sum));
        }

    }

    static void make() {
        parents = new int[v + 1];

        Arrays.fill(parents, -1);
    }

    static int findParents(int x) {
        if (parents[x] < 0) return x;

        return parents[x] = findParents(parents[x]);
    }

    static boolean union(int x, int y) {
        int xRoot = findParents(x);
        int yRoot = findParents(y);

        if (xRoot == yRoot) return false;

        if (xRoot < yRoot) {
            parents[xRoot] += parents[yRoot];
            parents[yRoot] = xRoot;
        } else {
            parents[yRoot] += parents[xRoot];
            parents[xRoot] = yRoot;
        }
        return true;
    }

    static class Edge {
        int start;
        int end;
        double weight;

        public Edge(int start, int end, double weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "start=" + start +
                    ", end=" + end +
                    ", weight=" + weight +
                    '}';
        }
    }
}