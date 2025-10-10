import java.util.*;
class Solution {
    static int INF = (int)1e9;
    static int[] d;
    static ArrayList<Integer>[] graph;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        d = new int[n+1];
        graph=new ArrayList[n+1];
        
        for(int i=0; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        Arrays.fill(d, INF);
        
        for(int[] e :  edge){
            int a = e[0];
            int b = e[1];
            graph[a].add(b);
            graph[b].add(a);
        }
        
        dijkstra(1);
        int max = -1;
        for(int i=1; i<=n; i++){
            if(d[i]==INF)continue;
            
            max = Math.max(max, d[i]);
        }
        for(int i=1; i<=n; i++){
            if(max ==d[i])answer++;
        }
        
        return answer;
        
    }
    static void dijkstra(int start){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->{
            return a[1] - b[1];
        });
        pq.offer(new int[]{start, 0});
        d[start]=0;
        
        while(!pq.isEmpty()){
            int[] poll = pq.poll();
            int now = poll[0];
            int dist = poll[1];
            if(d[now]<dist) continue;
            
            for(int i=0; i<graph[now].size(); i++){
                int next = graph[now].get(i);
                
                if(d[next] > d[now]+1){
                    d[next] = d[now]+1;
                    pq.offer(new int[]{next, d[now]+1});
                }
            }
        }
        
    }
    
}