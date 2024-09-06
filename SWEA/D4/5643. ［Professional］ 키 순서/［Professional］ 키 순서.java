import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {
    static int n, m;
    static int[][] matrix;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int TESTCASE = 1; TESTCASE <= T; TESTCASE++) {
            n = Integer.parseInt(br.readLine());
            m = Integer.parseInt(br.readLine());
            matrix = new int[n + 1][n + 1];
            for (int i = 0; i < m; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                matrix[a][b] = 1;
            }
            int ans = 0;
            for (int i = 1; i <= n; i++) {
                cnt = 0;
                gtDFS(i, new boolean[n + 1]);
                ltDFS(i, new boolean[n + 1]);
                if(cnt==n-1)ans++;
            }
            System.out.println("#" + TESTCASE + " " + ans);

        }
    }

    static int gtDFS(int start, boolean[] visited) {
        visited[start] = true;
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && matrix[start][i] != 0) {
                gtDFS(i, visited);
                cnt++;
            }
        }

        return cnt;
    }

    static int ltDFS(int start, boolean[] visited) {
        visited[start] = true;
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && matrix[i][start] != 0) {
                ltDFS(i, visited);
                cnt++;
            }
        }

        return cnt;
    }
}