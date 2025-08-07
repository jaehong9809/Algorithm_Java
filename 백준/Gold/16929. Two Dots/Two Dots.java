import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int n, m;
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static boolean answer = false;
    static boolean[][] realVisited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n + 2][m + 2];

        visited = new boolean[n + 2][m + 2];
        realVisited = new boolean[n + 2][m + 2];
        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            for (int j = 1; j <= m; j++) {
                map[i][j] = str.charAt(j - 1);
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dfs(i, j, i, j, 1);
                if(answer){
                    System.out.println(answer ? "Yes" : "No");
                    return;
                }
            }
        }
        System.out.println(answer ? "Yes" : "No");
    }

    static void bfs(int startx, int starty) {
        Queue<int[]> queue = new ArrayDeque<>();
        realVisited[startx][starty] = true;
        queue.offer(new int[]{startx, starty});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx < 1 || nx > n || ny < 1 || ny > m) continue;
                if (map[nx][ny] != map[startx][starty]) continue;
                if (realVisited[nx][ny]) continue;

                realVisited[nx][ny] = true;
                queue.offer(new int[]{nx, ny});
            }
        }
    }

    static void dfs(int startx, int starty, int nowx, int nowy, int cnt) {
        visited[nowx][nowy] = true;

        for (int i = 0; i < 4; i++) {
            int nx = nowx + dx[i];
            int ny = nowy + dy[i];
            if (nx < 1 || nx > n || ny < 1 || ny > m) continue;

            if (map[nx][ny] != map[startx][starty]) continue;
            if (nx == startx && ny == starty && cnt > 2) {
                answer = true;
            }
            if (visited[nx][ny]) continue;

            dfs(startx, starty, nx, ny, cnt + 1);
        }
        visited[nowx][nowy] = false;
    }


}