import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {
    static int[] pay;
    static int[] plan;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            pay = new int[4];
            plan = new int[13];
            String[] str = br.readLine().split(" ");
            for (int i = 0; i < 4; i++) {
                pay[i] = Integer.parseInt(str[i]);
            }
            int[] cost = new int[13];
            Arrays.fill(cost, pay[3]);
            cost[0]=0;
            str = br.readLine().split(" ");
            for (int i = 1; i <= 12; i++) {
                plan[i]=Integer.parseInt(str[i-1]);
                if(i>=3){
                    cost[i] = Math.min(cost[i - 3] + pay[2], cost[i]);
                }
                cost[i] = Math.min(cost[i - 1] + plan[i] * pay[0], cost[i]);
                cost[i] = Math.min(cost[i - 1] + pay[1], cost[i]);
            }

            System.out.println("#"+test_case+" "+cost[12]);
        }
    }
}