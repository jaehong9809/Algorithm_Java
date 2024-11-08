import java.util.ArrayDeque;
import java.util.Queue;

class Solution {

    static int[][] map = new int[101][101];
    static int[][] visited=new int[101][101];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

        for (int[] ints : rectangle) {
            print(ints);
        }
        for (int[] ints : rectangle) {
            empty(ints);
        }

        int answer = bfs(characterX*2, characterY*2, itemX*2, itemY*2)/2;

        return answer;
    }

    static int bfs(int startx, int starty, int targetx, int targety) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startx, starty});
        visited[startx][starty]=1;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if(now[0] ==targetx && now[1] ==targety) return visited[now[0]][now[1]]-1;
            for (int i = 0; i < 4; i++) {
                int nx = dx[i]+now[0];
                int ny = dy[i]+now[1];
                if(nx<0 || nx>100 || ny<0 || ny>100) continue;

                if(map[nx][ny]!=1 || visited[nx][ny]!=0) continue;

                queue.offer(new int[]{nx, ny});
                visited[nx][ny] = visited[now[0]][now[1]]+1;
            }

        }

        return -1;
    }

    static void print(int[] rectangle) {
        int left_x = rectangle[0] * 2;
        int left_y = rectangle[1] * 2;
        int right_x = rectangle[2] * 2;
        int right_y = rectangle[3] * 2;
        for (int i = left_x; i <= right_x; i++) {
            for (int j = left_y; j <= right_y; j++) {
                map[i][j] = 1;
            }
        }
    }

    static void empty(int[] rectangle) {
        int left_x = rectangle[0] * 2 + 1;
        int left_y = rectangle[1] * 2 + 1;
        int right_x = rectangle[2] * 2 - 1;
        int right_y = rectangle[3] * 2 - 1;
        for (int i = left_x; i <= right_x; i++) {
            for (int j = left_y; j <= right_y; j++) {
                map[i][j] = 0;
            }
        }
    }
}