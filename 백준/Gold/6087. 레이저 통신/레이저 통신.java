import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int n, m;
    static char[][] map;
    static int startx = -1, starty = -1;
    static int endx = -1, endy = -1;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'C') {
                    if (startx == -1) {
                        startx = i;
                        starty = j;
                    } else {
                        endx = i;
                        endy = j;
                    }
                }
            }
        }

        visited = new int[n][m][4];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                for (int d = 0; d < 4; d++)
                    visited[i][j][d] = Integer.MAX_VALUE;

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Node> queue = new ArrayDeque<>();
        for (int d = 0; d < 4; d++) {
            visited[startx][starty][d] = 0;
            queue.offer(new Node(startx, starty, d, 0));
        }

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            int nx = cur.x + dx[cur.dir];
            int ny = cur.y + dy[cur.dir];

            while (0 <= nx && nx < n && 0 <= ny && ny < m && map[nx][ny] != '*') {
                for (int d = 0; d < 4; d++) {
                    int nextMirror = cur.mirror + (cur.dir == d ? 0 : 1);
                    if (visited[nx][ny][d] > nextMirror) {
                        visited[nx][ny][d] = nextMirror;
                        queue.offer(new Node(nx, ny, d, nextMirror));
                    }
                }
                nx += dx[cur.dir];
                ny += dy[cur.dir];
            }
        }

        int min = Integer.MAX_VALUE;
        for (int d = 0; d < 4; d++) {
            min = Math.min(min, visited[endx][endy][d]);
        }

        return min;
    }

    static class Node {
        int x, y, dir, mirror;

        public Node(int x, int y, int dir, int mirror) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.mirror = mirror;
        }
    }
}
