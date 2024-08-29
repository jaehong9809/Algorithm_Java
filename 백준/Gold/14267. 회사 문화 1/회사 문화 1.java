import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    static int n, m;
    static int[] dp;
    static ArrayList<Integer>[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dp = new int[n+1];
        tree=new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        st.nextToken();

        for (int i = 2; i <= n; i++) {
            tree[Integer.parseInt(st.nextToken())].add(i);
        }
        int[][] q = new int[m][2];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            dp[node]+=weight;
        }
        DFS(1, -1);

        for (int i = 1; i <=n ; i++) {
            System.out.print(dp[i]+" ");
        }
        System.out.println();

    }
    static void DFS(int x, int prevNode){
        for (int y : tree[x]) {
            if(y==prevNode) continue;
            dp[y] +=dp[x];
            DFS(y, x);
        }
    }
}