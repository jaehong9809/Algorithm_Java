import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
    final static int[] dx = {1, 0, -1, 0};
    final static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int T;
        T = sc.nextInt();
        
        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            
            int[][] map = new int[n + 2][n + 2];
            
            int dir = 0;
            
            int x = 1;
            int y = 1;
            
            //테두리를 모두 -1 로 입력
            for (int i = 0; i < n + 2; i++) {
                map[0][i] = -1;
                map[i][0] = -1;
                map[n + 1][i] = -1;
                map[i][n + 1] = -1;
            }

            int num = 1;

            while (true) {
                //숫자입력
                map[y][x] = num++;

                //주위에 0 있는지 체크
                boolean flag = false;
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (map[ny][nx] == 0) {
                        flag = true;
                    }
                }
                if (!flag) {
                    break;
                }

                //조거에 의해서 방향 바꾸기
                if (map[y + dy[dir]][x + dx[dir]] != 0) {
                    dir++;
                    if (dir > 3) {
                        dir = 0;
                    }
                }

                x = x + dx[dir];
                y = y + dy[dir];
            }

            //출력...
            System.out.println("#" + test_case);
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}