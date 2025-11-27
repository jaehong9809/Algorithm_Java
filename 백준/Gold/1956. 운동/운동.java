import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int v, e;
    static int[][] map;
    static int INF = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        map = new int[v + 1][v + 1];
        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                if (i == j) continue;
                map[i][j] = INF;
            }
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[a][b] = c;
        }


        for (int k = 1; k <= v; k++) {
            for (int a = 1; a <= v; a++) {
                for (int b = 1; b <= v; b++) {
                    map[a][b] = Math.min(map[a][b], map[a][k] + map[k][b]);
                }
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= v; i++) {
            int tmpMin = Integer.MAX_VALUE;
            for (int j = 1; j <= v; j++) {
                if (i == j) continue;
                tmpMin = Math.min(tmpMin, map[i][j] + map[j][i]);
            }
            min = Math.min(min, tmpMin);
        }
        System.out.println(min < INF ? min : -1);
    }
}