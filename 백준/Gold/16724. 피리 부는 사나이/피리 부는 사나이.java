import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int n, m;
    static char[][] map;
    static int[][] visited;
    static int cnt = 0;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        parents = new int[n * m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        for (int i = 0; i < n * m; i++) {
            parents[i] = -1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int now = i * m + j;
                int next = 0;
                if (map[i][j] == 'D') {
                    next = (i + 1) * m + j;
                } else if (map[i][j] == 'U') {
                    next = (i - 1) * m + j;
                } else if (map[i][j] == 'L') {
                    next = i * m + (j - 1);
                } else if (map[i][j] == 'R') {
                    next = i * m + (j + 1);
                }
                union(now, next);
            }
        }
        int cnt=0;
        for (int i = 0; i < n*m; i++) {
            if(parents[i]<0) cnt++;
        }
        System.out.println(cnt);
    }

    static int find(int x) {
        if (parents[x] < 0) return x;

        return parents[x] = find(parents[x]);
    }

    static boolean union(int x, int y) {
        int rootx = find(x);
        int rooty = find(y);
        if (rooty == rootx) return false;
        if (rooty > rootx) {
            parents[rootx] += parents[rooty];
            parents[rooty] = rootx;
        } else {
            parents[rooty] += parents[rootx];
            parents[rootx] = rooty;
        }
        return true;
    }

}