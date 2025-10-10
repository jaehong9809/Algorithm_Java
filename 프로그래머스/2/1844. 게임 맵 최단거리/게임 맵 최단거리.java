import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        if(n==1 && m==1){
            return 1;
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0]+dx[i];
                int ny = now[1]+dy[i];
                if(nx>=0&&nx<n&&ny>=0&&ny<m &&maps[nx][ny]==1){
                    maps[nx][ny] = maps[now[0]][now[1]]+1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        if(maps[n-1][m-1]==1){
            return -1;
        }
        int answer = maps[n-1][m-1];
        return answer;
    }
}