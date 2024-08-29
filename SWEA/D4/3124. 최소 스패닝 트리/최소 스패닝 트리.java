import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Solution {
    static int v;
    static int e;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int TESTCASE = 1; TESTCASE <= T; TESTCASE++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            parents = new int[v + 1];
            for (int i = 1; i <=v ; i++) {
                parents[i]=-1;
            }
            ArrayList<Edge> edges = new ArrayList<>();
            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                edges.add(new Edge(a, b, c));
            }
            Collections.sort(edges, (a, b)->a.weight - b.weight);
            long sum=0;
            int cnt=0;
            for (Edge edge : edges) {
                if (union(edge.start, edge.end)) {
                    sum+=edge.weight;
                    if (cnt==v-1)break;
                }
            }
            System.out.println("#"+TESTCASE+" "+sum);
        }

    }

    static int findParents(int x) {
        if (parents[x]<0)return x;
        return parents[x] = findParents(parents[x]);
    }

    static boolean union(int x, int y) {
        int xRoot = findParents(x);
        int yRoot = findParents(y);
        if (yRoot==xRoot)return false;
        if(xRoot<yRoot){
            parents[xRoot] += parents[yRoot];
            parents[yRoot] = xRoot;
        }else {
            parents[yRoot] += parents[xRoot];
            parents[xRoot] = yRoot;
        }
        return true;
    }


    static class Edge{
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
}