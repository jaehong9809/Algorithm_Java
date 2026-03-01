import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        sc.nextLine();

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String tmp = sc.nextLine();

            for (int j = 0; j < m; j++) {
                map[i][j] = tmp.charAt(j) - '0';
            }
        }
        bfs();
        System.out.println(map[n-1][m-1]);

    }

    static void bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + now[0];
                int ny = dy[i] + now[1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(map[nx][ny]==0)continue;
                if(visited[nx][ny])continue;
                queue.offer(new int[]{nx, ny});
                visited[nx][ny]= true;
                map[nx][ny] += map[now[0]][now[1]];
            }
        }

    }
}