import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int[][] map;
    static int n, m;
    static int[][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new int[n][m][2];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }




        System.out.println(bfs(0, 0));

    
    }

    static int bfs(int startx, int starty) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startx, starty, 1});
        visited[startx][starty][1] = 1;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (now[0] == n - 1 && now[1] == m - 1) {
                return visited[now[0]][now[1]][now[2]];
            }
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + now[0];
                int ny = dy[i] + now[1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;


                if (map[nx][ny] == 0) {
                    if (visited[nx][ny][now[2]] == 0) {
                        visited[nx][ny][now[2]] = visited[now[0]][now[1]][now[2]] + 1;
                        queue.offer(new int[]{nx, ny, now[2]});
                    }
                } else {
                    if (now[2] == 1) {
                        if (visited[nx][ny][0] == 0) {
                            visited[nx][ny][0] = visited[now[0]][now[1]][1] + 1;
                            queue.offer(new int[]{nx, ny, 0});
                        }

                    }
                }
            }
        }

        return -1;
    }
}