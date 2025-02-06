import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int n, m, k;

    static class Edge implements Comparable<Edge> {
        int u, v;
        int w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }

    static int[] parent;
    static ArrayList<Edge> edges = new ArrayList<>();
    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        for (int i = 0; i <=n; i++) {
            parent[i]=i;
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            parent[Integer.parseInt(st.nextToken())] = -1;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a, b, c));
        }



        Collections.sort(edges);
        int sum=0;
        for(Edge edge : edges){
            if(union(edge.v, edge.u)){
                sum+= edge.w;
            }
        }
        System.out.println(sum);
    }

    static int find(int x){
        if(parent[x] == -1) return -1;

        if(x==parent[x] )return x;

        return parent[x] = find(parent[x]);
    }

    static boolean union(int x, int y){
        x = find(x);
        y = find(y);

        if (x != y) {
            if (x == -1) {
                parent[y] = x;
            } else if (y == -1) {
                parent[x] = y;
            } else {
                parent[y] = x;
            }
            return true;
        }
        return false;
    }


}