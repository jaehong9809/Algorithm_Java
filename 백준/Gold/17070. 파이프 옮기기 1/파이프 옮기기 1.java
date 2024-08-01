import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N + 1][N + 1];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp1 = new int[N][N]; //가로
        int[][] dp2 = new int[N][N]; //세로
        int[][] dp3 = new int[N][N]; //대각

        dp1[0][1]=1;
        for (int i = 0; i < N; i++) {
            for (int j = 2; j < N; j++) {
                if(map[i][j]==0){
                    dp1[i][j] = dp1[i][j-1]+dp3[i][j-1];
                }
                if(i-1>=0 &&map[i][j]==0){
                    dp2[i][j] = dp2[i-1][j]+dp3[i-1][j];
                }
                if(i-1>=0 &&map[i][j]==0 &&map[i-1][j]==0 && map[i][j-1]==0){
                    dp3[i][j] = dp1[i - 1][j - 1] + dp2[i - 1][j - 1] + dp3[i - 1][j - 1];
                }
            }
        }
        System.out.println((dp1[N-1][N-1]+dp2[N-1][N-1]+dp3[N-1][N-1]));
    }
}