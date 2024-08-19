import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        // 자바 입력 시작@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n+1];
        int[] dp = new int[k + 1];
        for (int i = 0; i < n; i++) {
            coins[i+1] = Integer.parseInt(br.readLine());
        }
        //자바 입력 종료@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        //50,000,000 >= 100 * 10,000

        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = coins[i]; j <=k ; j++) {
                if(j<coins[i]) continue;
                dp[j] += dp[j - coins[i]];
            }
        }
        System.out.println(dp[k]);

    }
}