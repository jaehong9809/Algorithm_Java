import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Main {
    static int n;
    static int[] parents;
    static class Edge{
        int start;
        int end;
        double weight;

        public Edge(int start, int end, double weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        parents=new int[n];
        make();
        double[] star_x  = new double[n];
        double[] star_y = new double[n];

        for (int i = 0; i < n; i++) {
            star_x[i] = sc.nextDouble();
            star_y[i] = sc.nextDouble();
        }
        ArrayList<Edge> edges = new ArrayList<>();

        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                edges.add(new Edge(i, j, Math.sqrt(Math.pow(star_x[i]-star_x[j], 2)+Math.pow(star_y[i]-star_y[j], 2))));
            }
        }

        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return Double.compare(o1.weight, o2.weight);
            }
        });

        int cnt =0;
        double sum=0.0;

        for (Edge edge : edges) {
            if (union(edge.start, edge.end)) {
                sum+=edge.weight;
                cnt++;
                if(cnt==n-1)break;
            }
        }
        System.out.printf("%.2f\n", sum);
    }
    public static void make(){
        parents=new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = -1;
        }
    }

    public static int findParent(int x){
        if(parents[x]<0) return x;

        return parents[x] = findParent(parents[x]);
    }

    public static boolean union(int x, int y){
        int rootx = findParent(x);
        int rooty = findParent(y);

        if (rootx==rooty) return false;
        if (rootx < rooty) {
            parents[rootx]+=parents[rooty];
            parents[rooty]= rootx;
        }else{
            parents[rooty]+=parents[rootx];
            parents[rootx]= rooty;
        }
        return true;
    }
}