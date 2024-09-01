import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
    static int[][] map = new int[1001][1001];
    static int x, y, n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        x = sc.nextInt()+500;
        y = sc.nextInt()+500;
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            map[a+500][b+500]=-1;
        }
        int res = bfs();
        System.out.println(res-1);

    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{500, 500});
        int[][] visited = new int[1001][1001];
        visited[500][500]=1;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if(now[0]==x && now[1] ==y) return visited[x][y];
            for (int i = 0; i < 4; i++) {
                int nx = dx[i]+now[0];
                int ny = dy[i]+now[1];
                if(nx<0|| nx>=1000|| ny<0||ny>=1000) continue;

                if(visited[nx][ny]==0 && map[nx][ny]!=-1){
                    visited[nx][ny] = visited[now[0]][now[1]]+1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        return visited[x][y];
    }
}