import java.util.Scanner;

class Main {
    static int n, m, k;
    static int[][][] stickers;
    static int[][] stickers_size;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 노트북 행 크기
        m = sc.nextInt(); // 노트북 열 크기
        k = sc.nextInt(); // 스티커 개수
        map = new int[n][m]; // 노트북 맵
        stickers = new int[k][][]; // 스티커 배열 저장
        stickers_size = new int[k][2]; // 스티커 크기 저장 (행, 열)

        // 스티커 입력 받기
        for (int i = 0; i < k; i++) {
            int a = sc.nextInt(); // 스티커의 행 크기
            int b = sc.nextInt(); // 스티커의 열 크기
            int[][] tmp = new int[a][b];
            stickers_size[i][0] = a;
            stickers_size[i][1] = b;
            for (int j = 0; j < a; j++) {
                for (int l = 0; l < b; l++) {
                    tmp[j][l] = sc.nextInt();
                }
            }
            stickers[i] = tmp;
        }

        // 스티커 붙이기 시도
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < 4; j++) { // 0도, 90도, 180도, 270도 회전
                if (find(i)) {
                    break; // 붙였으면 다음 스티커로
                }
                rotate(i); // 90도 회전
            }
        }

        // 최종 결과 계산
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    cnt++;
                }
            }
        }

        // 노트북 상태 출력
        System.out.println(cnt);
    }

    // 스티커를 90도 회전
    public static void rotate(int index) {
        int[][] rotatedMatrix = new int[stickers_size[index][1]][stickers_size[index][0]]; // 행과 열 바꿈

        for (int i = 0; i < stickers_size[index][0]; i++) {
            for (int j = 0; j < stickers_size[index][1]; j++) {
                rotatedMatrix[j][stickers_size[index][0] - 1 - i] = stickers[index][i][j];
            }
        }

        // 크기 변경 (회전했으므로 행과 열을 교환)
        int tmp = stickers_size[index][0];
        stickers_size[index][0] = stickers_size[index][1];
        stickers_size[index][1] = tmp;

        // 회전된 스티커로 갱신
        stickers[index] = rotatedMatrix;
    }

    // 현재 스티커를 붙일 수 있는지 확인
    static boolean check(int index, int x, int y) {
        for (int i = 0; i < stickers_size[index][0]; i++) {
            for (int j = 0; j < stickers_size[index][1]; j++) {
                if (stickers[index][i][j] == 1 && map[x + i][y + j] == 1) {
                    return false; // 스티커가 겹침
                }
            }
        }
        return true;
    }

    // 스티커를 노트북에 붙임
    static void print(int index, int x, int y) {
        for (int i = 0; i < stickers_size[index][0]; i++) {
            for (int j = 0; j < stickers_size[index][1]; j++) {
                if (stickers[index][i][j] == 1) {
                    map[x + i][y + j] = 1;
                }
            }
        }
    }

    // 스티커를 붙일 위치를 찾음
    static boolean find(int index) {
        // 스티커가 노트북 안에 들어가는지 확인
        for (int i = 0; i <= n - stickers_size[index][0]; i++) {
            for (int j = 0; j <= m - stickers_size[index][1]; j++) {
                if (check(index, i, j)) {
                    print(index, i, j); // 붙일 수 있으면 스티커 붙이기
                    return true;
                }
            }
        }
        return false;
    }
}