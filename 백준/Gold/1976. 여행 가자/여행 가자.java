import java.util.Scanner;

class Main {
    static int n, m;
    static int[][] map;
    static int INF = (int) 1e9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 0) map[i][j] = INF;
            }
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        int start = sc.nextInt();

        for (int i = 0; i < m - 1; i++) {
            int next = sc.nextInt();
            if(start ==next) continue;
            if (map[start][next] == INF) {
                System.out.println("NO");
                return;
            }
            start = next;
        }
        System.out.println("YES");
    }
}