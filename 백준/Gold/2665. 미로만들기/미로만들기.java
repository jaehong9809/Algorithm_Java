import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Main {
    static int n;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] d;
    static int INF = (int)1e9;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        d = new int[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j) - '0';
                d[i][j] = INF;
            }
        }

        dijkstra();
        System.out.println(d[n-1][n-1]);
    }
    public static void dijkstra(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0, 0));
        d[0][0]=0;

        while (!pq.isEmpty()) {
            Node poll = pq.poll();
            int x = poll.x;
            int y = poll.y;
            int cost = poll.cost;
            if(d[x][y] <cost) continue;

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                if(nx<0 || nx>=n || ny<0 || ny>=n) continue;

                int tmp = d[x][y];
                if(map[nx][ny]==0){
                    tmp++;
                }
                if(d[nx][ny] >tmp){
                    d[nx][ny] = tmp;
                    pq.offer(new Node(nx, ny, tmp));
                }


            }
        }
    }

    static class Node implements Comparable<Node>{
        int x, y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}