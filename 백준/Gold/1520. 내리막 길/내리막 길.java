import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    static int n;
    static int m;
    static int[][] matrix;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        matrix=new int[n][m];
        dp=new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] s1 = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(s1[j]);
            }
       }
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int cnt=dfs(0, 0);
        System.out.println(cnt);
    }

    public static int dfs(int startx, int starty){
        if(startx==n-1 && starty==m-1){
            return 1;
        }
        if(dp[startx][starty]!=-1){
            return dp[startx][starty];
        }else{
            dp[startx][starty]=0;
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + startx;
                int ny = dy[i] + starty;
                if(nx>=0&&nx<n&&ny>=0&&ny<m){
                    if (matrix[startx][starty] > matrix[nx][ny] ) {
                        dp[startx][starty]+=dfs(nx, ny);
                    }
                }
            }
        }


        return dp[startx][starty];
    }
}