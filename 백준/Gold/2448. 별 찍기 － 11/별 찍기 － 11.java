import java.util.Scanner;

class Main {
    static char[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 2차원 배열 초기화
        map = new char[n][2 * n - 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {
                map[i][j] = ' ';
            }
        }

        drawStars(0, n - 1, n);

        // 출력 최적화: StringBuilder를 사용
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {
                sb.append(map[i][j]);
            }
            sb.append('\n'); // 줄 바꿈
        }
        System.out.print(sb.toString());
    }

    public static void drawStars(int x, int y, int size) {
        if (size == 3) { // 가장 작은 삼각형 (기본 조건)
            map[x][y] = '*';
            map[x + 1][y - 1] = '*';
            map[x + 1][y + 1] = '*';
            map[x + 2][y - 2] = '*';
            map[x + 2][y - 1] = '*';
            map[x + 2][y] = '*';
            map[x + 2][y + 1] = '*';
            map[x + 2][y + 2] = '*';
            return;
        }

        int newSize = size / 2; // 크기를 반으로 나눔
        drawStars(x, y, newSize); // 위쪽 삼각형
        drawStars(x + newSize, y - newSize, newSize); // 왼쪽 아래 삼각형
        drawStars(x + newSize, y + newSize, newSize); // 오른쪽 아래 삼각형
    }
}