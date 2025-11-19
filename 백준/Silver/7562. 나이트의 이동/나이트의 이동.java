import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int[][] map;

    static int[] dx = {-2, -1, 1, 2, -2, -1, 1, 2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TESTCASE = Integer.parseInt(br.readLine());

        while (TESTCASE-- > 0) {
            int n = Integer.parseInt(br.readLine());

            map = new int[n][n];
            visited = new boolean[n][n];

            StringTokenizer st = new StringTokenizer(br.readLine());

            int startx = Integer.parseInt(st.nextToken());
            int starty = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int endx = Integer.parseInt(st.nextToken());
            int endy = Integer.parseInt(st.nextToken());

            sb.append(bfs(n, startx, starty, endx, endy));
            sb.append("\n");
        }
        System.out.println(sb);

    }

    static int bfs(int n, int startx, int starty, int endx, int endy) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startx, starty, 0});
        visited[startx][starty] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (now[0] == endx && now[1] == endy) {
                return now[2];
            }

            for (int i = 0; i < 8; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;

                if (visited[nx][ny]) continue;

                queue.offer(new int[]{nx, ny, now[2] + 1});
                visited[nx][ny] = true;
            }
        }

        return -1;
    }
}