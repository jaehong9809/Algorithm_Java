import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Main {
    static int max=-1;
    static class Edges implements Comparable<Edges>{
        int w;
        int cost;

        public Edges(int w, int cost) {
            this.w = w;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edges o) {
            return this.cost - o.cost;
        }
    }
    static int INF = (int )1e9;
    static ArrayList<Edges>[] edges;
    static int n, m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        edges=new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a =sc.nextInt();
            int b =sc.nextInt();
            int c = sc.nextInt();

            edges[a].add(new Edges(b, c));
            edges[b].add(new Edges(a, c));
        }
        System.out.println(prim()-max);
    }
    public static int prim(){
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<Edges> pq = new PriorityQueue<>();
        pq.offer(new Edges(1, 0));
        int total = 0;
        while (!pq.isEmpty()) {
            Edges edge = pq.poll();
            int v = edge.w;
            int cost = edge.cost;
            if(visited[v]) continue;
            visited[v] = true;
            total+=cost;
            if(cost>max)max = cost;
            for (Edges e : edges[v]) {
                if(!visited[e.w]) pq.offer(e);
            }
        }

        return total;
    }


}