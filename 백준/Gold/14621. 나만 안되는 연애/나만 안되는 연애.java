import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Main {
    static int n, m;
    static char[] gender;
    static ArrayList<Edge>[] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        gender = new char[n + 1];
        sc.nextLine();
        String[] s = sc.nextLine().split(" ");
        for (int i = 1; i <= n; i++) {
            gender[i] = s[i - 1].charAt(0);
        }

        graph = new ArrayList[n + 1];


        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph[a].add(new Edge(b, c, gender[b]));
            graph[b].add(new Edge(a, c, gender[a]));
        }

        boolean[] visited = new boolean[n + 1];

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(1, 0, gender[1]));
        int total = 0;
        int cnt=0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            int v = edge.w;
            int cost = edge.cost;
            char gen = edge.gender;
            if (visited[v]) continue;
            visited[v] = true;
            total += cost;
            cnt++;

            for (Edge e : graph[v]) {
                if (!visited[e.w] && gen != e.gender) {
                    pq.add(e);
                }
            }
        }
        if (cnt == n) {
            System.out.println(total);
        }else{
            System.out.println(-1);
        }

    }

    static class Edge implements Comparable<Edge> {
        int w;
        int cost;
        char gender;

        public Edge(int w, int cost, char gender) {
            this.w = w;
            this.cost = cost;
            this.gender = gender;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

}