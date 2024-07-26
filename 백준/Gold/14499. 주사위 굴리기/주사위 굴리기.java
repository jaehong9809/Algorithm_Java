import java.util.*;

class Main {
    static int n, m;
    static int x, y;
    static int k;
    static int[][] map;
    static int[] orders;
    static int top = 0;
    static int bottom = 0;
    static int left = 0;
    static int right = 0;
    static int front = 0;
    static int back = 0;
    static int[] dx = {-1000, 0, 0, -1, 1};
    static int[] dy = {-1000, 1, -1, 0, 0};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();
        k = sc.nextInt();

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        orders = new int[k];
        for (int i = 0; i < k; i++) {
            orders[i] = sc.nextInt();
        }
        // 1:->, 2:<-, 3:^ 4: v
        if (n == 1 && m == 1) {
            System.out.println(0);
            return;
        }
        for (int order : orders) {
            int tmpx = x + dx[order];
            int tmpy = y + dy[order];
            if (tmpx < 0 || tmpx >= n || tmpy < 0 || tmpy >= m) continue;
            if (order == 1) {
                //top left bottom right
                if (map[tmpx][tmpy] == 0) {
                    map[tmpx][tmpy] = right;
                } else {
                    right = map[tmpx][tmpy];
                    map[tmpx][tmpy]=0;
                }
                x = tmpx;
                y = tmpy;
                int tmp = top;
                top = left;
                left = bottom;
                bottom = right;
                right = tmp;
            }
            if (order == 2) {
                // top right bottom left
                if (map[tmpx][tmpy] == 0) {
                    map[tmpx][tmpy] = left;
                } else {
                    left = map[tmpx][tmpy];
                    map[tmpx][tmpy]=0;
                }
                x = tmpx;
                y = tmpy;
                int tmp = top;
                top = right;
                right = bottom;
                bottom = left;
                left = tmp;

            }
            if (order == 3) {
                // top back bottom front
                if (map[tmpx][tmpy] == 0) {
                    map[tmpx][tmpy] = back;
                } else {
                    back = map[tmpx][tmpy];
                    map[tmpx][tmpy]=0;
                }
                x = tmpx;
                y = tmpy;
                int tmp = top;
                top = front;
                front = bottom;
                bottom = back;
                back = tmp;

            }
            if (order == 4) {
                // top front bottom back
                if (map[tmpx][tmpy] == 0) {
                    map[tmpx][tmpy] = front;
                } else {
                    front = map[tmpx][tmpy];
                    map[tmpx][tmpy]=0;
                }
                x = tmpx;
                y = tmpy;
                int tmp = top;
                top = back;
                back = bottom;
                bottom = front;
                front = tmp;


            }
            System.out.println(top);
        }


    }
}