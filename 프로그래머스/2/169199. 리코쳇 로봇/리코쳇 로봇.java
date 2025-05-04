import java.util.*;

class Solution {
    static int n, m;
    static int[][] visited;
    static char[][] map;
    static int startx, starty;
    static int endx, endy;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int solution(String[] board) {
        n = board.length;
        m = board[0].length();
        
        visited = new int[n][m];
        map = new char[n][m];
        for(int i=0;i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i].charAt(j) =='R'){
                    startx = i;
                    starty = j;
                }
                if(board[i].charAt(j) =='G'){
                    endx = i;
                    endy = j;
                }
                
                map[i][j] = board[i].charAt(j);
            }
        }
        
        int answer = bfs();
        return answer;
    }
    
    public int bfs(){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(startx, starty));
        visited[startx][starty] = 1;
        
        while(!q.isEmpty()){
            Node now = q.poll();
            
            if(map[now.x][now.y] =='G') return visited[now.x][now.y]-1;    
            for(int i = 0; i<4; i++){
                int[] next = find(i, now.x, now.y);
                
                if(visited[next[0]][next[1]] != 0 ) continue;
                visited[next[0]][next[1]] = visited[now.x][now.y] +1;
                
                q.offer(new Node(next[0], next[1]));    
            }
        }
        
        return -1;
    }
    
    public int[] find(int dir, int x, int y){
        int[] next = new int[2];
        
        while(true){
            x +=dx[dir];
            y +=dy[dir];
            if(x <0 || x>=n || y<0 ||y>=m) break;
            if(map[x][y] =='D') break;
            
        }
        next[0] = x - dx[dir];
        next[1] = y - dy[dir];
        return next;
    }
    
    class Node{
        int x, y;
        
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}