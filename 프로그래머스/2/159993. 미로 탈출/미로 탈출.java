import java.util.*;
class Solution {
    static int n, m;
    static char[][] map;
    static int[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        int answer = 0;
        int startx=0;
        int starty = 0;
        int exitx = 0;
        int exity = 0;
        int lx = 0;
        int ly = 0;
        map =new char[n][m];
        visited=new int[n][m];
        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[i].length(); j++){
                if(maps[i].charAt(j)=='S'){
                    startx = i;
                    starty = j;
                    
                }else if(maps[i].charAt(j)=='E'){
                    exitx = i;
                    exity=j;
                }else if(maps[i].charAt(j)=='L'){
                    lx = i;
                    ly = j;
                }
                map[i][j] = maps[i].charAt(j);
            }
            
        }
        int res =bfs(startx, starty, lx, ly );
        if(res ==-1){
            return -1;
        }
        answer=res;
        visited=new int[n][m];
        res =bfs(lx, ly, exitx, exity);
        if(res ==-1){
            return -1;
        }
        answer+=res;
        return answer;
    }
    
    static int bfs(int startx, int starty, int endx, int endy){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startx, starty});
        visited[startx][starty] = 1;
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(now[0]==endx && now[1] ==endy){
                return visited[endx][endy]-1;
            }
            
            for(int i=0; i<4; i++){
                int nx = dx[i]+ now[0];
                int ny = dy[i]+now[1];
                if(nx<0 || nx >=n ||ny<0 || ny>=m) continue;
                if(visited[nx][ny]==0 && map[nx][ny]!='X'){
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = visited[now[0]][now[1]]+1;
                }
            }
            
        }
        
        return -1;
    }
}