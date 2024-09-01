import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    static int n;
    static int[] nums;
    static ArrayList<Integer>[] tree;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n + 1];
        nums = new int[n + 1];
        dp =new int[n+1][2];
        for (int i = 1; i <=n ; i++) {
            tree[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        dfs(1, -1);
        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }
    static void dfs(int x, int prevNode) {
        dp[x][0] = 0;
        dp[x][1] = nums[x];
        for (int y : tree[x]) {
            if (y == prevNode) continue;
            dfs(y, x);
            dp[x][0] += Math.max(dp[y][0], dp[y][1]);
            dp[x][1] +=dp[y][0];
        }
    }

}