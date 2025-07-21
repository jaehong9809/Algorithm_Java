import java.util.*;
class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int[][] map;
    int n;
    int m;
    boolean[][] visited;
    public int[] solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        map = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(maps[i].charAt(j) =='X') map[i][j] = -1;
                else map[i][j] = maps[i].charAt(j) - '0';
            }
        }
        ArrayList<Integer> results = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j] && map[i][j]>0){
                    results.add(bfs(i, j));
                }
            }
        }
        Collections.sort(results);
        int[] answer = new int[results.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = results.get(i);
        }
        
        return answer.length > 0? answer : new int[]{-1};
    }
    
    public int bfs(int startx, int starty){
        int sum=0;
        
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startx, starty});
        visited[startx][starty] = true;
        
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            sum+=map[now[0]][now[1]];
            for(int i=0; i<4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
                if(visited[nx][ny]) continue;
                
                if(map[nx][ny] <0 )continue;
                
                queue.offer(new int[]{nx, ny});
                visited[nx][ny]=true;
            }
        }
        return sum;        
    }
}