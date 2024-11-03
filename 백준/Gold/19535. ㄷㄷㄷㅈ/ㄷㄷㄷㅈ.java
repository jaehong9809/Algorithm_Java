import java.util.ArrayList;
import java.util.Scanner;

class Main {
    static int n;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static Edge[] edges;

    static class Edge {
        int a, b;

        public Edge(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        edges = new Edge[n - 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
            edges[i] = new Edge(a, b);
        }
        long gggg = 0;
        long dddd = 0;

        for (int i = 1; i <= n; i++) {
            if (graph.get(i).size() >= 3) {
                int size = graph.get(i).size();
                gggg += (long) size * (size - 1) * (size - 2) / 6;
            }
        }

        for (Edge edge : edges) {
            dddd += (long) (graph.get(edge.a).size() - 1) * (graph.get(edge.b).size() - 1);
        }
        if (dddd > gggg * 3) {
            System.out.println("D");
        } else if (dddd < gggg * 3) {
            System.out.println("G");
        } else {
            System.out.println("DUDUDUNGA");
        }

    }


}

