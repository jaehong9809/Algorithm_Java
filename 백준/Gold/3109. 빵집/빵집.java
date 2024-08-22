import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
    static int R, C;
    static int[][] map;
    static int[] dCol = {1, 0, -1};
    static int[] dRow = {1, 1, 1};
    static int cnt = 0;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        visited=new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                if (str.charAt(j) == '.') {
                    map[i][j] = 0;
                } else {
                    map[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < R; i++) {
            if (bfs(i)) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static boolean bfs(int col) {

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{col, 0});

        while (!stack.isEmpty()) {

            int[] now = stack.pop();
            visited[now[0]][now[1]] = true;
            if (now[1] == C - 1) {
                return true;
            }
            for (int i = 0; i < 3; i++) {

                int nCol = now[0] + dCol[i];
                int nRow = now[1] + dRow[i];

                if (nCol < 0 || nCol >= R || nRow < 0 || nRow >= C) continue;


                if (!visited[nCol][nRow] && map[nCol][nRow] != 1) {
                    stack.push(new int[]{nCol, nRow});
                }
            }
        }
        return false;
    }

}