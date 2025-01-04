import java.util.*;

public class Main {
    static int n;
  
    static class Edge {
        int a, b;
        int cost;
        public Edge(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
    }
  
    static int[] parent;
    static ArrayList<Edge> edges = new ArrayList<>();
  
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int a = sc.nextInt();
                if (i != j) { 
                    edges.add(new Edge(i, j, a));
                }
            }
        }
        Arrays.fill(parent, -1); 
        Collections.sort(edges, (a, b) -> a.cost - b.cost);
    
        int cnt = 0;
        long sum = 0;
        for (Edge edge : edges) {
            if (union(edge.a, edge.b)) {
                sum += edge.cost;
                cnt++;
                if (cnt == n - 1) break;
            }
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
        parent[roota] +=parent[rootb];
        parent[rootb] = roota;

        return true;
    }
}
