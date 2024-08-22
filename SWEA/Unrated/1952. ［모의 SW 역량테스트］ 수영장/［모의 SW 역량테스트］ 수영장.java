import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {
    static int min;
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

            min = pay[3];
            str = br.readLine().split(" ");
            for (int i = 1; i <= 12; i++) {
                plan[i]=Integer.parseInt(str[i-1]);
            }

            func(0, 1);

            System.out.println("#"+test_case+" "+min);
        }
    }
    static void func(int cost, int month){
        if(month>12){
            min = Math.min(cost, min);
            return;
        }

        int nextMonth=-1;
        for (int i = month; i <=12 ; i++) {
            if(plan[i]>0){
                nextMonth=i;
                break;
            }
        }

        if (nextMonth != -1) {
            func(cost+plan[nextMonth]*pay[0], nextMonth+1);

            func(cost + pay[1], nextMonth + 1);
            func(cost+pay[2], nextMonth+3);

        }else{
            min = Math.min(cost, min);
        }


    }
}