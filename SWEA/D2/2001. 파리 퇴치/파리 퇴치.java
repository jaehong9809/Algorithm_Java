import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] map = new int[N][N];
            int[][] prefixSum = new int[N + 1][N + 1];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                    prefixSum[i+1][j+1] = prefixSum[i][j+1] + prefixSum[i+1][j] + map[i][j] - prefixSum[i][j];
                }
            }
//
//            for (int i = 1; i <= N; i++) {
//                for (int j = 1; j <= N; j++) {
//                    prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] + map[i - 1][j - 1] - prefixSum[i - 1][j - 1];
//                }
//            }
            int max = -1;


            for (int i = M; i <= N; i++) {
                for (int j = M; j <= N; j++) {
                    max = Math.max(prefixSum[i][j] - prefixSum[i - M][j] - prefixSum[i][j - M] + prefixSum[i - M][j - M], max);
                }
            }
            System.out.println("#" + test_case + " " + max);
        }
    }
}