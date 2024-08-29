import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class Solution {
    static int N;
    static double E;
    static int[] x;
    static int[] y;
    static int[] parent;
 
    static class Edge implements Comparable<Edge> {
        int s, e;
        double dist;
        Edge(int s, int e, double dist) {
            this.s = s;
            this.e = e;
            this.dist = dist;
        }
 
        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.dist, o.dist); // 비교 방식을 수정
        }
    }
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        int T = Integer.parseInt(br.readLine());
         
        for(int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            x = new int[N];
            y = new int[N];
             
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                x[i] = Integer.parseInt(st.nextToken());
            }
             
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                y[i] = Integer.parseInt(st.nextToken());
            }
             
            E = Double.parseDouble(br.readLine());
             
            PriorityQueue<Edge> pq = new PriorityQueue<>();
            parent = new int[N];
             
            for(int i = 0; i < N; i++) {
                parent[i] = i;
            }
             
            // 간선 생성 및 우선순위 큐에 삽입
            for(int i = 0; i < N; i++) {
                for(int j = i + 1; j < N; j++) {
                    double dist = distanceSquared(x[i], y[i], x[j], y[j]);
                    pq.offer(new Edge(i, j, dist));
                }
            }
             
            int edgeCount = 0;
            double answer = 0;
             
            while(edgeCount < N - 1) {
                Edge now = pq.poll();
                 
                if(find(now.s) != find(now.e)) {
                    union(now.s, now.e);
                    answer += now.dist * E;
                    edgeCount++;
                }
            }
             
            System.out.println("#" + tc + " " + (long)Math.round(answer));
        }
         
        br.close();
    }
     
    // 두 점 간의 거리의 제곱을 계산하는 함수
    static double distanceSquared(int x1, int y1, int x2, int y2) {
        return Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2);
    }
     
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) {
            parent[b] = a;
        }
    }
     
    static int find(int x) {
        if(x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
}