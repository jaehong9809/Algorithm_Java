import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static String[] arr;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static boolean[][] visit;
    static char c;

    static boolean check(int x, int y) {
        return 0 <= x && x < m && 0 <= y && y < n;
    }

    static void dfs(int x, int y, int prvX, int prvY) {
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (check(nx, ny) && arr[ny].charAt(nx) == c && !(prvX == nx && prvY == ny)) {
                if (visit[ny][nx]) {
                    System.out.println("Yes");
                    System.exit(0); // 조기 종료
                } else {
                    visit[ny][nx] = true;
                    dfs(nx, ny, x, y);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new String[n];
        for (int i = 0; i < n; i++) arr[i] = br.readLine();

        visit = new boolean[n][m];

        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (!visit[y][x]) {
                    c = arr[y].charAt(x);
                    visit[y][x] = true;
                    dfs(x, y, -1, -1);
                }
            }
        }
        System.out.println("No");
    }
}
