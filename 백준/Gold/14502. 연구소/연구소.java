import java.util.*;

class Main {
    static int n, m;
    static int matrix[][];
    static ArrayList<Pair> virusIndexs = new ArrayList<>();
    static ArrayList<Integer> safeZones = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int tmp = scanner.nextInt();
                matrix[i][j] = tmp;
                if (tmp == 2) {
                    virusIndexs.add(new Pair(i, j));
                }
            }
        }
        for (int i = 0; i < n * m - 2; i++) {
            int firstx = i / m;
            int firsty = i % m;
            if (matrix[firstx][firsty] == 2 || matrix[firstx][firsty] == 1) {
                continue;
            }
            for (int j = i + 1; j < n * m - 1; j++) {
                int secondx = j / m;
                int secondy = j % m;
                if (matrix[secondx][secondy] == 2 || matrix[secondx][secondy] == 1) {
                    continue;
                }
                for (int k = j + 1; k < n * m; k++) {
                    int thirdx = k / m;
                    int thirdy = k % m;
                    if (matrix[thirdx][thirdy] == 2 || matrix[thirdx][thirdy] == 1) {
                        continue;
                    }
                    int tmpMatrix[][] = new int[n][m];
                    for (int a = 0; a < n; a++) {
                        for (int b = 0; b < m; b++) {
                            tmpMatrix[a][b] = matrix[a][b];
                        }
                    }
                    tmpMatrix[firstx][firsty] = 1;
                    tmpMatrix[secondx][secondy] = 1;
                    tmpMatrix[thirdx][thirdy] = 1;
                    safeZones.add(bfs(tmpMatrix));
                }
            }
        }
        System.out.println(Collections.max(safeZones));
    }
    public static int bfs(int[][] tmpMatrix) {
        int cnt = 0;
        Queue<Pair> q = new LinkedList<>();
        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, -1, 1};
        for (Pair virusIndex : virusIndexs) {
            q.offer(new Pair(virusIndex.x, virusIndex.y));
            while (!q.isEmpty()) {
                Pair now = q.poll();
                for (int i = 0; i < 4; i++) {
                    int newx = now.x + dx[i];
                    int newy = now.y + dy[i];
                    if (newx >= 0 && newx < n && newy >= 0 && newy < m) {
                        if (tmpMatrix[newx][newy] == 0) {
                            q.offer(new Pair(newx, newy));
                            tmpMatrix[newx][newy] = 2;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tmpMatrix[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}