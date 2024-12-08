import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, 1, -1, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    if (bfs(i, j)) {
                        res++;
                    }
                }
            }
        }
        System.out.println(res);
    }

    static boolean bfs(int startx, int starty) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startx, starty});
        visited[startx][starty] = true;
        boolean isPeak = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                // 더 높은 지점이 있으면 봉우리가 아님
                if (map[nx][ny] > map[x][y]) {
                    isPeak = false;
                }

                // 같은 높이의 지점은 계속 탐색
                if (map[nx][ny] == map[x][y] && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        return isPeak;
    }
}