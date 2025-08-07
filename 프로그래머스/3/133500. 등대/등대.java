import java.util.*;
class Solution {
    static ArrayList<Integer>[] graph;
    static int[][] dp;
    public int solution(int n, int[][] lighthouse) {
        int answer = 0;
        graph = new ArrayList[n+1];
        dp = new int[n+1][2];
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] lh : lighthouse){
            graph[lh[0]].add(lh[1]);
            graph[lh[1]].add(lh[0]);
            
        }
        
       
        
        dfs(1, -1);
        return Math.min(dp[1][0], dp[1][1]);
    }
    static void dfs(int now, int prev){
        dp[now][0] = 0;
        dp[now][1] = 1;
        
        for(Integer next: graph[now]){
            if(next == prev) continue;
            dfs(next, now);
            dp[now][0] +=dp[next][1];
            dp[now][1] += Math.min(dp[next][0], dp[next][1]);
            
        }
    }
}