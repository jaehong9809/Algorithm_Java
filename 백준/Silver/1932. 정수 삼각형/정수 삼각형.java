import java.util.ArrayList;
import java.util.Scanner;

class Main {
    static ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int dp[][] = new int[501][501];
        int trianle[][] = new int[501][501];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                trianle[i][j] = sc.nextInt();
            }
        }

        for (int i = n - 1; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                trianle[i][j] += Math.max(trianle[i + 1][j], trianle[i + 1][j + 1]);
            }
        }
        System.out.println(trianle[1][1]);
    }
}