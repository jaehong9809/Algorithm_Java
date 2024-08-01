import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            if (L == 0 && R == 0 && C == 0) break;
            char[][][] map = new char[L][R][C];
            int x = 0;
            int y = 0;
            int z = 0;

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String str = br.readLine();
                    for (int k = 0; k < C; k++) {
                        map[i][j][k] = str.charAt(k);
                        if (map[i][j][k] == 'S') {
                            z = i;
                            y = j;
                            x = k;
                        }
                    }
                }
                br.readLine();
            }
            int result = bfs(map, x, y, z, L, R, C);
            if (result == 0) {
                System.out.println("Trapped!");
            } else {
                System.out.printf("Escaped in %d minute(s).\n", result);
            }

        }
    }

    static int bfs(char[][][] map, int x, int y, int z, int L, int R, int C) {
        int[][][] visited = new int[L][R][C];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y, z));
        visited[z][y][x] = 1;
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (map[now.z][now.y][now.x] == 'E') {
                return visited[now.z][now.y][now.x] - 1;
            }
            for (int i = 0; i < 6; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                int nz = now.z + dz[i];

                if (nx < 0 || nx >= C || ny < 0 || ny >= R || nz < 0 || nz >= L) continue;

                if (visited[nz][ny][nx] != 0) continue;

                if (map[nz][ny][nx] == '.' || map[nz][ny][nx] == 'E') {
                    queue.offer(new Node(nx, ny, nz));
                    visited[nz][ny][nx] = visited[now.z][now.y][now.x] + 1;
                }
            }
        }

        return 0;
    }

    static class Node {
        int x;
        int y;
        int z;

        public Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}