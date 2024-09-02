import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
    static int w, h;
    static char[][] map;
    static int x, y;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static StringBuilder sb = new StringBuilder();
    static ArrayList<int[]> fires;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int TEST_CASE = 0; TEST_CASE < T; TEST_CASE++) {
            w = sc.nextInt();
            h = sc.nextInt();
            map = new char[h][w];
            fires = new ArrayList<>();
            sc.nextLine();
            for (int i = 0; i < h; i++) {
                String str = sc.nextLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = str.charAt(j);
                    if (map[i][j] == '@') {
                        x = i;
                        y = j;
                    }
                    if (map[i][j] == '*') {
                        fires.add(new int[]{i, j});
                    }
                }
            }
            int res = bfs();
            if (res < 0) {
                sb.append("IMPOSSIBLE\n");
            } else {
                sb.append(res + "\n");
            }

        }
        System.out.print(sb);
    }
    public static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        int[][] fireVisited = new int[h][w];
        int[][] characterVisited = new int[h][w];

        for (int[] fire : fires) {
            queue.offer(new Node(fire[0], fire[1], false));
            fireVisited[fire[0]][fire[1]] = 1;
        }

        queue.offer(new Node(x, y, true));
        characterVisited[x][y] = 1;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + now.x;
                int ny = dy[i] + now.y;

                if (now.isCharacter) {
                    if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
                        return characterVisited[now.x][now.y];
                    }
                    if (characterVisited[nx][ny] != 0 || fireVisited[nx][ny] != 0 || map[nx][ny] != '.') continue;

                    characterVisited[nx][ny] = characterVisited[now.x][now.y] + 1;
                    queue.offer(new Node(nx, ny, true));
                } else {
                    if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                    if (fireVisited[nx][ny] != 0 || map[nx][ny] == '#') continue;

                    fireVisited[nx][ny] = fireVisited[now.x][now.y] + 1;
                    queue.offer(new Node(nx, ny, false));
                }
            }
        }
        return -1;
    }
//    public static int bfs() {
//        Queue<Node> queue = new LinkedList<>();
//        int[][] visited = new int[h][w];
//
//
//        Node node = new Node(x, y);
//
//        node.isCharacter = true;
//
//        queue.offer(node);
//        visited[x][y] = 1;
//
//        for (int[] fire : fires) {
//            queue.offer(new Node(fire[0], fire[1]));
//            visited[fire[0]][fire[1]] = -2;
//        }
//
//        while (!queue.isEmpty()) {
//            Node now = queue.poll();
////            for (int i = 0; i < h; i++) {
////                for (int j = 0; j < w; j++) {
////                    System.out.print(map[i][j]+" ");
////                }
////                System.out.println();
////            }
////            System.out.println();
//            for (int i = 0; i < 4; i++) {
//                int nx = dx[i] + now.x;
//                int ny = dy[i] + now.y;
//
//                if (now.isCharacter) {
//                    if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
//                        return visited[now.x][now.y];
//                    }
//                    if (visited[nx][ny] == -2) continue;
//                    if (map[nx][ny] == '.') {
//                        visited[nx][ny] = visited[now.x][now.y] + 1;
//                        map[nx][ny] = '@';
//                        Node node1 = new Node(nx, ny);
//                        node1.isCharacter = true;
//                        queue.offer(node1);
//                    }
//                } else {
//                    if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
//                    if (visited[nx][ny] == -2) continue;
//                    if (map[nx][ny] != '#') {
//                        queue.offer(new Node(nx, ny));
//                        visited[nx][ny] = -2;
//                        map[nx][ny] = '*';
//                    }
//                }
//            }
//        }
//        return -1;
//    }

    static class Node {
        int x, y;
        boolean isCharacter = false;

        public Node(int x, int y, boolean isCharacter) {
            this.x = x;
            this.y = y;
            this.isCharacter = isCharacter;
        }
    }
}