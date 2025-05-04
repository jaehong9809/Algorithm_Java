import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        long[][] dp = new long[n+1][10];
        for(int i=0; i<10; i++){
            dp[1][i] = 1;
        }

        for(int i=2; i<=n; i++){
            for(int j=0; j<10; j++){
                if(j == 0) {
                    dp[i][0] = dp[i-1][0];  // 수정된 부분
                } else {
                    dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 10007;
                }
            }
        }
        long sum = 0;
        for(int i=0; i<10; i++){
            sum+=dp[n][i];
        }
        System.out.println(sum%10007);
    }
}