import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int n;
    static int[][] matrix;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        matrix = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= n / 2; i++) {
            visited = new boolean[n + 1];
            func(0, 1, i);
        }
        System.out.println(min);
    }

    static void func(int depth, int start, int limit) {
        if (depth == limit) {
            int teamA = 0;
            int teamB = 0;


            for (int i = 1; i <= n; i++) {
                if (visited[i]) {
                    for (int j = i + 1; j <= n; j++) {
                        if (i == j) continue;
                        if (visited[j]) teamA += matrix[i][j] + matrix[j][i];
                    }
                } else {
                    for (int j = i + 1; j <= n; j++) {
                        if (i == j) continue;
                        if (!visited[j]) teamB += matrix[i][j] + matrix[j][i];
                    }
                }
            }
            min = Math.min(Math.abs(teamA - teamB), min);
            return;
        }
        for (int i = start; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                func(depth + 1, i + 1, limit);
                visited[i] = false;
            }
        }
    }
}