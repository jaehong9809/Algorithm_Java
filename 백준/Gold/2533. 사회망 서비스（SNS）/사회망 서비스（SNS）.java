import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    static int n;
    static ArrayList<Integer>[] tree;
    static int[] cnt;
    static int res1 = 0;
    static int res2 = 0;
    static int min = Integer.MAX_VALUE;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n + 1];
        cnt = new int[n + 1];
        dp = new int[n+1][2];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        cnt[0] = -1;
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }
        dfs(1, -1);

        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    static void dfs(int x, int prevNode) {
        dp[x][0] = 0;
        dp[x][1] = 1;

        for (int y : tree[x]){
            if (y==prevNode) continue;
            dfs(y, x);
            dp[x][0] +=dp[y][1];
            dp[x][1] += Math.min(dp[y][0], dp[y][1]);
        }
    }

}