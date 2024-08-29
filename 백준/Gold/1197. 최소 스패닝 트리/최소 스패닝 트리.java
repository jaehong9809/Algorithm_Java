import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static int v;
    static int[] parents;
    static int n;
    static int m;
    static ArrayList<Edges> edges = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        makeSet(n);

        for (int i = 0; i <m ; i++) {
            edges.add(new Edges(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(edges, (a, b)->{
            return a.weight - b.weight;
        });
        int cnt=0;
        long sum=0;
        for (Edges edge : edges) {
            if (findParent(edge.start) != findParent(edge.end)) {
                union(edge.start, edge.end);
                cnt++;
                sum += edge.weight;
                if (cnt==n-1)break;
            }
        }
        System.out.println(sum);
    }
    static class Edges{
        int start;
        int end;
        int weight;

        public Edges(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    public static void makeSet(int n){
        parents = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }
    }

    public static int findParent(int x){
        if (parents[x] == x )return x;

        return parents[x] = findParent(parents[x]);
    }
    public static boolean union(int x, int y){
        int rootx = findParent(x);
        int rooty = findParent(y);
        if(rootx==rooty) return false;
        if(rootx<rooty){
            parents[rooty] = rootx;
        }else {
            parents[rootx] = rooty;
        }
        return true;
    }

}