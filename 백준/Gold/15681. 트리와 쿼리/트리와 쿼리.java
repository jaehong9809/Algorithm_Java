import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    static int n;
    static int r;
    static int q;
    static int[] dp;
    static ArrayList<Integer>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        dp = new int[n+1];
        tree = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }
        dfs(r, -1);

        for (int i = 0; i < q; i++) {
            int tmp = Integer.parseInt(br.readLine());
            System.out.println(dp[tmp]);
        }


    }

    static void dfs(int x, int prevNode){
        dp[x]=1;
        for (int y :tree[x]) {
            if(y ==prevNode)continue;
            dfs(y, x);
            dp[x]+=dp[y];
        }

    }

}