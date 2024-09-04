import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static int n, k;
    static ArrayList<Node> tops;
    static int max = -1;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int TEST_CASE = 1; TEST_CASE <= T; TEST_CASE++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            map = new int[n][n];
            tops = new ArrayList<>();
            max = -1;
            int tmpTop = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (tmpTop < map[i][j]) tmpTop = map[i][j];
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == tmpTop) {
                        tops.add(new Node(i, j));
                    }
                }
            }
            for (Node top : tops) {
                visited = new boolean[n][n];
                visited[top.x][top.y]=true;
                dfs(top.x, top.y, 1, 1);
                visited[top.x][top.y]=false;
            }
            System.out.println("#" + TEST_CASE + " " + max);
        }
    }

    public static void dfs(int x, int y, int cnt, int tmpk) {
        if (cnt > max) {
            max =cnt;
        }

        for (int i = 0; i < 4; i++) {

            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;


            if (visited[nx][ny]) continue;
            if (map[nx][ny] < map[x][y]) {
                visited[nx][ny] = true;
                dfs(nx, ny, cnt + 1, tmpk);
                visited[nx][ny] = false;
            } else if (tmpk==1 && map[nx][ny] - k < map[x][y]) {
                visited[nx][ny] = true;
                int originalHeight = map[nx][ny];
                map[nx][ny] = map[x][y] - 1;  // 깎아서 이동
                dfs(nx, ny, cnt + 1, 0);
                map[nx][ny] = originalHeight;  // 원상복귀
                visited[nx][ny] = false;
            }
        }
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}