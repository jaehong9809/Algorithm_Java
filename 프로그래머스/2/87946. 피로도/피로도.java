import java.util.*;
class Solution {
    static int length;
    static boolean[] visited;
    static int[] arr;
    static int max=-1;
    public int solution(int k, int[][] dungeons) {
        length = dungeons.length;
        visited=new boolean[length];
        arr=new int[length];
        dfs(0, dungeons, k);
        return max;
    }
    public void dfs(int depth, int[][] dungeons,int k){
        if(depth == length){
            int cnt=0;
            int K = k;
     
            for(int i=0; i<length; i++){
                if(dungeons[arr[i]][0]<=K){
                    cnt++;
                    K -= dungeons[arr[i]][1];
                }
            }
            max = Math.max(cnt, max);
            return;
        }
                
        
        for(int i=0; i<length; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i;
                dfs(depth+1, dungeons, k);
                visited[i]=false;
            }
        }
        
    }
    
    
    
}