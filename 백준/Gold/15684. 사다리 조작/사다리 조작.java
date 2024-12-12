import java.util.Scanner;

class Main {
    static int n, m, h;
    static boolean[][] rows;
    static int min = Integer.MAX_VALUE; // 최소 사다리 수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        h = sc.nextInt();

        rows = new boolean[h + 2][n + 2];

        // 초기 사다리 입력
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            rows[a][b] = true;
        }

        // 사다리를 최대 3개까지 추가하면서 탐색
        for (int i = 0; i <= 3; i++) {
            dfs(0, i);
            if (min != Integer.MAX_VALUE) break; // 최소값을 찾으면 종료
        }

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    // 현재 추가된 사다리 수, 목표 추가 사다리 수
    public static void dfs(int count, int target) {
        if (count == target) {
            if (check()) min = Math.min(min, count);
            return;
        }

        // 사다리를 추가할 위치 탐색
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j < n; j++) { // n개의 세로선 사이에만 사다리를 추가 가능
                if (!rows[i][j] && !rows[i][j - 1] && !rows[i][j + 1]) {
                    // 사다리 추가
                    rows[i][j] = true;
                    dfs(count + 1, target);
                    rows[i][j] = false; // 백트래킹
                }
            }
        }
    }

    // 모든 시작점에서 종료점이 동일한지 확인
    public static boolean check() {
        for (int i = 1; i <= n; i++) {
            int position = i;
            for (int j = 1; j <= h; j++) {
                if (rows[j][position]) position++;
                else if (position > 1 && rows[j][position - 1]) position--;
            }
            if (position != i) return false;
        }
        return true;
    }
}