import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n;
    static int[][] map;
    static int[][] visited;
    static boolean[][] visited2;
    static Map<Integer, ArrayList<Node>> hashmap = new HashMap<>();
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new int[n][n];
        visited2 = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int tmp = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == 0 && map[i][j] == 1) {
                    ArrayList<Node> list = bfs(i, j, tmp);
                    hashmap.put(tmp, list);
                    tmp++;
                }
            }
        }

        for (Integer index : hashmap.keySet()) {
            for (Node node : hashmap.get(index)) {
                visited2 = new boolean[n][n];
                bfs2(node.x, node.y, index);
            }
        }

        System.out.println(min);
    }

    static void bfs2(int x, int y, int index) {
        boolean sign = true;
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if (map[nx][ny] == 0) {
                sign = false;
                break;
            }
        }
        if (sign) {
            return;
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(x, y));
        visited2[x][y] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + now.x;
                int ny = dy[i] + now.y;
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;

                if (visited[nx][ny] != index && !visited2[nx][ny]) {
                    if (map[nx][ny] == 1) {
                        min = Math.min(min, now.cnt);
                        return;
                    }
                    queue.offer(new Node(nx, ny, now.cnt + 1));
                    visited2[nx][ny] = true;
                }
            }
        }
    }


    static ArrayList<Node> bfs(int x, int y, int index) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(x, y));
        visited[x][y] = index;
        ArrayList<Node> list = new ArrayList<>();

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            list.add(now);
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + now.x;
                int ny = dy[i] + now.y;
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;

                if (visited[nx][ny] == 0 && map[nx][ny] == 1) {
                    queue.offer(new Node(nx, ny));
                    visited[nx][ny] = index;
                }
            }
        }

        return list;
    }

    static class Node {
        int x, y, cnt = 0;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}