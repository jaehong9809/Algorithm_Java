import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static int N;
    static int[] dp = new int[100_000 + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp[1] =1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 1;
        dp[5] = 2;

        for (int i = 6; i <=N ; i++) {
            int sqrt = (int)Math.sqrt(i);
            int min = Integer.MAX_VALUE;
            for (int j = sqrt; j >=1; j--) {
                min = Math.min(min, 1 + dp[i - j * j]);
            }

            dp[i] = min;
        }
        System.out.println(dp[N]);
    }
}