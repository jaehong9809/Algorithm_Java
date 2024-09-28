import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Main {
    static int n;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] dp;
    static class Node {
        int x, y;
        int val;
        public Node(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
    static ArrayList<Node> list = new ArrayList<>();
    static int result = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        map = new int[n][n];
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                list.add(new Node(i, j, map[i][j]));
            }
        }

        Collections.sort(list, (a, b) -> {
            return a.val - b.val;
        });

        for (Node node : list) {
            int x = node.x;
            int y = node.y;
            int max = 0;
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;

                if (map[nx][ny] < map[x][y]) {
                    max = Math.max(dp[nx][ny], max);
                }
            }
            dp[x][y] = max + 1;
            result = Math.max(result, dp[x][y]);
        }
        System.out.println(result);
    }
}