import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] data = new int[n];
        int[] dp = new int[n];
        int[] prev = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
        }
        Arrays.fill(prev, -1);
        for (int i = 0; i < n; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (data[j] < data[i]  && dp[i] < dp[j]+1) {
                    dp[i] = dp[j]+1;
                    prev[i] = j;
                }
            }
        }

        int size = 0;
        int lastIndex = -1;

        for (int i = 0; i < n; i++) {
            if (dp[i] > size) {
                size = dp[i];
                lastIndex=i;
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        while (lastIndex != -1) {
            list.add(data[lastIndex]);
            lastIndex = prev[lastIndex];
        }
        Collections.reverse(list);

        System.out.println(size);
        for (Integer i : list) {
            System.out.print(i+" ");
        }
    }
}