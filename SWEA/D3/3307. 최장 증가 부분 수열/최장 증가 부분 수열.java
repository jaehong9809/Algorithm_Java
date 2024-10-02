import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int TESTCASE = 1; TESTCASE <= t; TESTCASE++) {
            int n = Integer.parseInt(br.readLine());
            int[] data = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                data[i] = Integer.parseInt(st.nextToken());
            }
            int[] dp = new int[n];
            for (int i = 0; i < n; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {

                    if (data[j] < data[i] && dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                    }
                }
            }
            Arrays.sort(dp);
            System.out.println("#"+TESTCASE+" "+dp[n-1]);
        }
    }
}