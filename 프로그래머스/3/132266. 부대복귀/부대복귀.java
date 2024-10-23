import java.util.*;
class Solution {
    static int INF = (int)1e9;
    static ArrayList<Node>[] graph;
    static class Node{
        int node;
        int cost;
        public Node(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
    }
    static int[] d;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        
        d= new int[n+1];
        graph = new ArrayList[n+1];
        
        for(int i=0; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        Arrays.fill(d, INF);
        for(int[] road: roads){
            graph[road[0]].add(new Node(road[1], 1));
            graph[road[1]].add(new Node(road[0], 1));
        }
        
        dijkstra(destination);
        
        int index =0;
        for(int source : sources){
            if(d[source]!=INF){
                answer[index++] = d[source];
            }else{
                answer[index++] = -1;
            }
        }
        return answer;
    }
    static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b)-> a.cost - b.cost);
        pq.offer(new Node(start, 0));
        d[start]=0;
        while(!pq.isEmpty()){
            Node now = pq.poll();
            int nowNode = now.node;
            int cost = now.cost;
            
            if(d[nowNode] < cost) continue;
            
            for(int i=0; i<graph[nowNode].size(); i++){
                int nextNode = graph[nowNode].get(i).node;
                int nextCost = graph[nowNode].get(i).cost + d[nowNode];
                if(d[nextNode] >nextCost){
                    d[nextNode] = nextCost;
                    pq.offer(new Node(nextNode, nextCost));
                }
            }
        }
    }
}