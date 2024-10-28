import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int[][] matrix = new int[v + 1][v + 1];

        for (int i = 0; i <= v; i++) {
            for (int j = 0; j <= v; j++) {
                if (i == j) continue;
                matrix[i][j] = INF;
            }
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            matrix[a][b] = c;
        }

        for (int k = 1; k <= v; k++) {
            for (int a = 1; a <= v; a++) {
                for (int b = 1; b <= v; b++) {
                    matrix[a][b] = Math.min(matrix[a][b], matrix[a][k] + matrix[k][b]);
                }
            }
        }
        int res = Integer.MAX_VALUE;

        for (int i = 1; i <= v - 1; i++) {
            for (int j = i + 1; j <= v; j++) {
                if (i == j) continue;
                res = Math.min(res, matrix[i][j] + matrix[j][i]);
            }
        }

        System.out.println(res < INF ? res : -1);
    }
}