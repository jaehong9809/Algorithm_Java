import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int[][] map;
    static int n, k;
    static int[] dx = {0, 0, -1, 1}; 
    static int[] dy = {1, -1, 0, 0};
    static Map<Integer, Node> nodes = new HashMap<>();
    static ArrayList<Integer>[][] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n + 2][n + 2];
        check = new ArrayList[n + 2][n + 2];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < n + 2; j++) {
                if (i == 0 || i == n + 1 || j == 0 || j == n + 1) {
                    map[i][j] = 2;
                }
            }
        }

        for (int i = 0; i <= n + 1; i++) {
            for (int j = 0; j <= n + 1; j++) {
                check[i][j] = new ArrayList<>(); 
            }
        }

        // 말 초기화
        for (int i = 1; i <= k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            nodes.put(i, new Node(a, b, c - 1));
            check[a][b].add(i);
        }

        for (int game = 0; game < 1000; game++) {
            for (int i = 1; i <= k; i++) {
                Node node = nodes.get(i);
                int nx = node.x + dx[node.dir];
                int ny = node.y + dy[node.dir];

                if (map[nx][ny] == 2) {
                    node.dir = changeDir(node.dir);
                    nx = node.x + dx[node.dir];
                    ny = node.y + dy[node.dir];
                    if (map[nx][ny] == 2) continue;
                }

                if (map[nx][ny] == 0) {
                    ArrayList<Integer> result = new ArrayList<>();
                    boolean sign = false;
                    for (int j = 0; j < check[node.x][node.y].size(); j++) {
                        if (check[node.x][node.y].get(j) == i) {
                            sign = true;
                        }
                        if (sign) {
                            result.add(check[node.x][node.y].get(j));
                        }
                    }
                    check[node.x][node.y].removeAll(result);
                    for (Integer integer : result) {
                        check[nx][ny].add(integer);
                        nodes.get(integer).x = nx;
                        nodes.get(integer).y = ny;
                    }
                    if (check[nx][ny].size() >= 4) {
                        System.out.println(game + 1);
                        return;
                    }
                } else if (map[nx][ny] == 1) {
                    ArrayList<Integer> result = new ArrayList<>();
                    boolean sign = false;
                    for (int j = 0; j < check[node.x][node.y].size(); j++) {
                        if (check[node.x][node.y].get(j) == i) {
                            sign = true;
                        }
                        if (sign) {
                            result.add(check[node.x][node.y].get(j));
                        }
                    }
                    Collections.reverse(result);
                    check[node.x][node.y].removeAll(result);
                    for (Integer integer : result) {
                        check[nx][ny].add(integer);
                        nodes.get(integer).x = nx;
                        nodes.get(integer).y = ny;
                    }
                    if (check[nx][ny].size() >= 4) {
                        System.out.println(game + 1);
                        return;
                    }
                }
            }
        }
        System.out.println(-1);
    }

    static int changeDir(int x) {
        if (x == 0) return 1;
        if (x == 1) return 0; 
        if (x == 2) return 3;
        return 2;            
    }

    static class Node {
        int x, y, dir;

        public Node(int x, int y, int dir) {
            this.x = x;
            this.y = y; 
            this.dir = dir;
        }
    }
}