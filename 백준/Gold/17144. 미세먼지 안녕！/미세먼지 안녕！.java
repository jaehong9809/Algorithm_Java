import java.util.Scanner;

class Main {
    static int r, c, t;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int up = 0;
    static int down = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        r = sc.nextInt();
        c = sc.nextInt();
        t = sc.nextInt();

        map = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == -1) {
                    if (up == 0) {
                        up = i;
                    } else {
                        down = i;
                    }
                }
            }
        }
        for (int time = 0; time < t; time++) {
            spread();
            windstorm();
        }
        int sum = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == -1) continue;
                sum += map[i][j];
            }
        }
        System.out.println(sum);
    }

    static void print() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void spread() {
        int[][] copy = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] / 5 >= 1) {
                    int sum = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = dx[k] + i;
                        int ny = dy[k] + j;
                        if (nx < 0 || nx >= r || ny < 0 || ny >= c || map[nx][ny] == -1) continue;

                        copy[nx][ny] += map[i][j] / 5;
                        sum += map[i][j] / 5;
                    }
                    copy[i][j] += map[i][j] - sum;
                } else {
                    copy[i][j] += map[i][j];
                }
            }
        }
        copy[up][0] = -1;
        copy[down][0] = -1;
        map = copy;
    }

    static void windstorm() {
        int x = up - 2;
        int y = 0;
        while (true) {
            if (x == 0 && y == 0) {
                map[x + 1][y] = map[x][y];
                y = 1;
                continue;
            }
            if (x == 0 && y == c - 1) {
                map[x][y - 1] = map[x][y];
                x = 1;
                continue;
            }
            if (x == up && y == c - 1) {
                map[x - 1][y] = map[x][y];
                y = c - 2;
            }
            if (x == up && y == 0) {
                map[x][y + 1] = 0;
                break;
            }


            if (y == 0) {
                map[x + 1][y] = map[x][y];
                x--;
                continue;
            }
            if (x == 0) {
                map[x][y - 1] = map[x][y];
                y++;
                continue;
            }
            if (x == up) {
                map[x][y + 1] = map[x][y];
                y--;
                continue;
            }
            if (y == c - 1) {
                map[x - 1][y] = map[x][y];
                x++;
                continue;
            }

        }
        x = down + 2;
        y = 0;
        while (true) {
            if (x == r - 1 && y == 0) {
                map[x - 1][y] = map[x][y];
                y = 1;
                continue;
            }
            if (x == r - 1 && y == c - 1) {
                map[x][y - 1] = map[x][y];
                x = r - 2;
                continue;
            }
            if (x == down && y == c - 1) {
                map[x + 1][y] = map[x][y];
                y = c - 2;
            }
            if (x == down && y == 0) {
                map[x][y + 1] = 0;
                break;
            }

            if (y == 0) {
                map[x - 1][y] = map[x][y];
                x++;
                continue;
            }
            if (x == r - 1) {
                map[x][y - 1] = map[x][y];
                y++;
                continue;
            }
            if (x == down) {
                map[x][y + 1] = map[x][y];
                y--;
                continue;
            }
            if (y == c - 1) {
                map[x + 1][y] = map[x][y];
                x--;
                continue;
            }
        }
    }
}