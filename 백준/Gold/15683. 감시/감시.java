import java.util.Scanner;

class Main {
    static int n, m;
    static int[][] map;
    static int[] arr;
    static int[] rolls;
    static int[][] location;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        arr = new int[8];
        rolls = new int[8];
        location = new int[8][2];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] >= 1 && map[i][j] <= 5) {
                    rolls[cnt] = map[i][j];
                    location[cnt][0] = i;
                    location[cnt][1] = j;
                    cnt++;
                }
            }
        }
        dfs(0);

        System.out.println(min);
    }

    static void dfs(int depth) {
        if (depth == arr.length) {
            int[][] tmp = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    tmp[i][j] = map[i][j];
                }
            }

            for (int i = 0; i < depth; i++) {
                print(rolls[i], arr[i], location[i][0], location[i][1], tmp);
            }
            min = Math.min(check(tmp), min);

            return;
        }

        for (int i = 0; i < 4; i++) {
            arr[depth] = i;
            dfs(depth + 1);
        }
    }


    static void print(int roll, int dir, int x, int y, int[][] tmp) {


        if (roll == 1) {
            int d = dir;
            int nx = x + dx[d];
            int ny = y + dy[d];
            while (nx >= 0 && ny >= 0 && nx < n && ny < m && tmp[nx][ny] != 6) {
                if (tmp[nx][ny] == 0) tmp[nx][ny] = -1;
                nx += dx[d];
                ny += dy[d];
            }
        }

        if (roll == 2) {
            for (int i = 0; i <= 2; i += 2) {
                int d = (dir + i) % 4;
                int nx = x + dx[d];
                int ny = y + dy[d];
                while (nx >= 0 && ny >= 0 && nx < n && ny < m && tmp[nx][ny] != 6) {
                    if (tmp[nx][ny] == 0) tmp[nx][ny] = -1;
                    nx += dx[d];
                    ny += dy[d];
                }
            }
        }

        if (roll == 3) {
            for (int i = 0; i < 2; i++) {
                int d = (dir + i) % 4;
                int nx = x + dx[d];
                int ny = y + dy[d];
                while (nx >= 0 && ny >= 0 && nx < n && ny < m && tmp[nx][ny] != 6) {
                    if (tmp[nx][ny] == 0) tmp[nx][ny] = -1;
                    nx += dx[d];
                    ny += dy[d];
                }
            }
        }

        if (roll == 4) {
            for (int i = 0; i < 3; i++) {
                int d = (dir + i) % 4;
                int nx = x + dx[d];
                int ny = y + dy[d];
                while (nx >= 0 && ny >= 0 && nx < n && ny < m && tmp[nx][ny] != 6) {
                    if (tmp[nx][ny] == 0) tmp[nx][ny] = -1;
                    nx += dx[d];
                    ny += dy[d];
                }
            }
        }

        if (roll == 5) {
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                while (nx >= 0 && ny >= 0 && nx < n && ny < m && tmp[nx][ny] != 6) {
                    if (tmp[nx][ny] == 0) tmp[nx][ny] = -1;
                    nx += dx[d];
                    ny += dy[d];
                }
            }
        }
    }

    static int check(int[][] tmp) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tmp[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }
}