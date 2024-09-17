import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] dp= new long[1000001];

        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 9;
        dp[5] = 44;
        for (int i = 6; i <=n; i++) {
            dp[i] = ((i-1)*(dp[i-1]+dp[i-2]))%1_000_000_000;
        }
        System.out.println(dp[n]);
    }


}