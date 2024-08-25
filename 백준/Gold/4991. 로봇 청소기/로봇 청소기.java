import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int w, h;
    StringBuilder sb = new StringBuilder();
    static List<int[]> dusts;
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static ArrayList<ArrayList<int[]>> graph;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            result = Integer.MAX_VALUE;
            if (w == 0 && h == 0) break;
            dusts = new ArrayList<>();
            map = new char[h][w];
            int robotindex = 0;
            int index = 0;

            for (int i = 0; i < h; i++) {
                String str = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = str.charAt(j);
                    if (map[i][j] == 'o') {
                        dusts.add(new int[]{i, j});
                        robotindex = index;
                        index++;
                    }
                    if (map[i][j] == '*') {
                        dusts.add(new int[]{i, j});
                        index++;
                    }
                }
            }

            graph = new ArrayList<>();
            for (int i = 0; i < dusts.size(); i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < dusts.size() - 1; i++) {
                for (int j = i + 1; j < dusts.size(); j++) {
                    int cost = bfs(dusts.get(i), dusts.get(j));
                    if (cost == -1) continue;

                    graph.get(i).add(new int[]{j, cost});
                    graph.get(j).add(new int[]{i, cost});
                }
            }

            boolean[] visited = new boolean[dusts.size()];
            visited[robotindex] = true;
            permutation(robotindex, 0, 0, visited);
            System.out.println(result == Integer.MAX_VALUE ? -1 : result);

        }
    }

    static void permutation(int start, int depth, int sum, boolean[] visited) {
        if (depth == dusts.size() - 1) {
            result = Math.min(result, sum);
            return;
        }

        for (int[] next : graph.get(start)) {
            if (!visited[next[0]]) {
                visited[next[0]] = true;
                permutation(next[0], depth + 1, sum + next[1], visited);
                visited[next[0]] = false;
            }
        }
    }

    private static int bfs(int[] start, int[] end) {
        Queue<int[]> q = new LinkedList<>();
        int[][] visited = new int[h][w];
        q.offer(start);
        visited[start[0]][start[1]] = 1;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            if (now[0] == end[0] && now[1] == end[1]) return visited[now[0]][now[1]] - 1;
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;

                if (visited[nx][ny] == 0 && map[nx][ny] != 'x') {
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = visited[now[0]][now[1]] + 1;
                }
            }
        }
        return -1;
    }
}