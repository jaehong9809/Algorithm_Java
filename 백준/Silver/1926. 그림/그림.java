import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j]==1) {
                    cnt++;
                    max = Math.max(max, bfs(i, j));
                }
            }
        }
        System.out.println(cnt);
        System.out.println(max);
    }

    static int bfs(int startx, int starty) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startx, starty});
        visited[startx][starty] = true;
        int cnt = 0;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            cnt++;
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + now[0];
                int ny = dy[i] + now[1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (visited[nx][ny]) continue;
                if(map[nx][ny]==0) continue;
                queue.offer(new int[]{nx, ny});
                visited[nx][ny] = true;

            }

        }
        return cnt;
    }

}