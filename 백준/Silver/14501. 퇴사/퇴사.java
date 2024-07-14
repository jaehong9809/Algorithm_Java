import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[][] schedule=new int[n+1][2];
        int[] dp = new int[n+1];
        for (int i = 0; i < n; i++) {
            schedule[i][0]=sc.nextInt();
            schedule[i][1]=sc.nextInt();
        }

        for (int i = 0; i <n ; i++) {
            if(schedule[i][0]+i<=n){
                dp[schedule[i][0] + i] = Math.max(dp[schedule[i][0] + i], dp[i] + schedule[i][1]);
            }
            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }

        System.out.println(dp[n]);

    }



}