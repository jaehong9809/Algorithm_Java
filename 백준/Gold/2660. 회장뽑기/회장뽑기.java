import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static int[][] graph;
    static int INF = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        graph = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == j) continue;
                graph[i][j] = INF;
            }
        }

        while (true) {
            String[] str = br.readLine().split(" ");

            int aNode = Integer.parseInt(str[0]);
            int bNode = Integer.parseInt(str[1]);

            if (aNode == -1 && bNode == -1) {
                break;
            }
            graph[aNode][bNode] = 1;
            graph[bNode][aNode] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int start = 1; start <= n; start++) {
                for (int end = 1; end <= n; end++) {
                    graph[start][end] = Math.min(graph[start][end], graph[start][k] + graph[k][end]);
                }
            }
        }
        int[] scores = new int[n + 1];

        int realMin = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int max = -1;
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] == INF) continue;
                if (max < graph[i][j]) {
                    max = graph[i][j];
                }
            }
            scores[i] = max;
            if (realMin > max) {
                realMin = max;
            }
        }
        String str = "";
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (scores[i] == realMin) {
                cnt++;
                str += i + " ";
            }
        }
        System.out.println(realMin + " " + cnt);
        System.out.println(str);

    }
}