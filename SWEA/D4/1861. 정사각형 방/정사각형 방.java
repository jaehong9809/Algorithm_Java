import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int n;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int TESTCASE = 1; TESTCASE <= T; TESTCASE++) {
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] str = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(str[j]);
                }
            }
            int maxCnt = -1;
            int maxNumber = -1;
            for (int col = 0; col < n; col++) {
                for (int row = 0; row < n; row++) {
                    int nowCol = col;
                    int nowRow = row;
                    boolean isPossible = false;

                    for (int i = 0; i < 4; i++) {
                        int nCol = nowCol + dx[i];
                        int nRow = nowRow + dy[i];

                        if (nCol < 0 || nCol >= n || nRow < 0 || nRow >= n) continue;

                        if (map[nCol][nRow] - map[nowCol][nowRow] == 1) {
                            isPossible = true;
                            break;
                        }
                    }
                    if (isPossible) {
                        int cnt = bfs(nowCol, nowRow);

                        if (cnt == maxCnt) {
                            if (maxNumber > map[nowCol][nowRow]) {
                                maxNumber = map[nowCol][nowRow];
                                continue;
                            }
                        }

                        if (cnt > maxCnt) {
                            maxCnt = cnt;
                            maxNumber = map[nowCol][nowRow];
                        }


                    }
                }
            }
            System.out.println("#" + TESTCASE + " " + maxNumber + " " + maxCnt);
        }
    }

    public static int bfs(int nowCol, int nowRow) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(nowCol, nowRow));
        int[][] visited = new int[n][n];
        visited[nowCol][nowRow] = 1;

        int max = -1;

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (max < visited[now.col][now.row]) {
                max = visited[now.col][now.row];
            }

            for (int i = 0; i < 4; i++) {
                int nCol = now.col + dx[i];
                int nRow = now.row + dy[i];
                if (nCol < 0 || nCol >= n || nRow < 0 || nRow >= n) continue;

                if (map[nCol][nRow] - map[now.col][now.row] == 1) {
                    visited[nCol][nRow] = visited[now.col][now.row] + 1;
                    queue.offer(new Node(nCol, nRow));
                }
            }
        }
        return max;
    }

    static class Node {
        int col;
        int row;

        public Node(int col, int row) {
            this.col = col;
            this.row = row;
        }
    }

}