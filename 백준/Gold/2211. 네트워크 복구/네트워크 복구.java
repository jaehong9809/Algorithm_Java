import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    static int INF=1_000_000_000;
    static int n, m;
    static ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
    static int[] d;
    static Pair[] res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        d=new int[n+1];
        res=new Pair[n+1];
        Arrays.fill(d, INF);

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            int c= Integer.parseInt(st.nextToken());
            graph.get(a).add(new int[]{b, c});
            graph.get(b).add(new int[]{a, c});
        }

        dijkstra(1);

        System.out.println(n-1);
        for (int i = 2; i <=n; i++) {
            System.out.println(res[i].x+" "+res[i].y);
        }
    }
    public static void dijkstra(int start){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.offer(new Pair(0, start));
        d[start]=0;

        while (!pq.isEmpty()) {
            Pair now = pq.poll();
            int nowCost=now.x;
            int nowNode=now.y;

            if(d[nowNode]>nowCost)continue;

            for (int i = 0; i <graph.get(nowNode).size() ; i++) {
                int nextCost = d[nowNode] + graph.get(nowNode).get(i)[1];

                if(nextCost<d[graph.get(nowNode).get(i)[0]]){
                    res[graph.get(nowNode).get(i)[0]] = new Pair(nowNode, graph.get(nowNode).get(i)[0]);
                    pq.offer(new Pair(nextCost, graph.get(nowNode).get(i)[0]));
                    d[graph.get(nowNode).get(i)[0]] =nextCost;
                }
            }

        }


    }

    static class Pair implements Comparable<Pair> {
        public int x;
        public int y;
        public Pair(int x, int y){
            this.x=x;
            this.y=y;
        }

        @Override
        public int compareTo(Pair o) {
            return this.x - o.x;
        }
    }
}