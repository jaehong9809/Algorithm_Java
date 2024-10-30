import java.util.*;
class Solution {
    static int n, m;
    Map<Integer, Integer> map = new HashMap<>();
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] visited;
    
    public int solution(int[][] land) {
        n = land.length;
        m = land[0].length;
        visited = new int[n][m];
        
        int index = 1;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(visited[i][j]==0 && land[i][j]==1){
                    bfs(i, j, index++, land);
                }
            }
        }
        int answer = 0;
      
        for(int i=0; i<m; i++){
            Set<Integer> set = new HashSet<>();
            for(int j=0; j<n; j++){
                if(visited[j][i] > 0) set.add(visited[j][i]);
            }
            int sum=0;
            for(Integer integer : set){
                sum+=map.get(integer);
            }
            answer = Math.max(sum, answer);
        }
        
        
        
        
        return answer;
    }
    
    public void bfs(int x, int y, int index, int[][] land){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y});
        
        visited[x][y] = index;
        int cnt =0;
        while(!q.isEmpty()){
            int[] now = q.poll();
            cnt++;
            for(int i=0; i<4; i++){
                int nx = dx[i] + now[0];
                int ny = dy[i] + now[1];
                if(nx< 0 || nx>=n || ny <0 || ny>=m) continue;
                
                if(visited[nx][ny] != 0 )continue;
                
                if(land[nx][ny]==1){
                    q.offer(new int[] {nx, ny});
                    visited[nx][ny] = index;
                }
            }
            
        }
        
        map.put(index, cnt);
    }
    
}