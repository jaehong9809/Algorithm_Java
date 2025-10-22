import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {
    static char[][] map;
    static int n, m, k;
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, 1, -1, 1, -1};
    static int[] res;
    static Map<String, Integer> tmp = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new char[n + 1][m + 1];
        res = new int[k];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < k; i++) {
            String s = br.readLine();
            if (tmp.containsKey(s)) {
                res[i] = tmp.get(s);
                continue;
            }

            for (int j = 0; j < n; j++) {
                for (int l = 0; l < m; l++) {
                    if (s.charAt(0) == map[j][l]) {
                        dfs(j, l, 1, Character.toString(map[j][l]), s, i);
                    }
                }
            }
        }

        for (int re : res) {
            System.out.println(re);
        }

    }

    static void dfs(int x, int y, int depth, String s, String answer, int num) {
        if (!answer.startsWith(s)) {
            return;
        }

        if (depth == answer.length()) {
            tmp.put(answer, tmp.getOrDefault(answer, 0) + 1);
            res[num]++;
            return;
        }

        for (int i = 0; i < 8; i++) {
            int nx = (x + dx[i] + n) % n;  // 음수 처리를 위해 n을 더함
            int ny = (y + dy[i] + m) % m;  // 음수 처리를 위해 m을 더함
            dfs(nx, ny, depth + 1, s + map[nx][ny], answer, num);
        }

    }
}
















