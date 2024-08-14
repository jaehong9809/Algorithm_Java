import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int N, K, L;
    static int[][] map;
    static Queue<Dir> queue = new LinkedList<>();

    static int dir = 0;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int x = 1;
    static int y = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];

        for (int i = 0; i < K; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int col = Integer.parseInt(str.nextToken());
            int row = Integer.parseInt(str.nextToken());
            map[col][row] = 2;
        }

        L = Integer.parseInt(br.readLine());

        for (int i = 0; i < L; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(str.nextToken());
            String dir = str.nextToken();

            queue.offer(new Dir(time, dir.charAt(0)));
        }
        int nowTime = 0;

        map[y][x] =1;

        LinkedList<int[]> snake = new LinkedList<>();
        snake.add(new int[]{x, y});


        while (true) {
            if (!queue.isEmpty()) {
                Dir peek = queue.peek();
                int tmpTime = peek.time;
                char tmpDir = peek.dir;
                if (nowTime == tmpTime) {
                    queue.poll();
                    if (tmpDir == 'D') {
                        dir++;
                        if(dir>3){
                            dir=0;
                        }
                    }else{
                        dir--;
                        if(dir<0){
                            dir=3;
                        }
                    }
                }
            }

            int nx = x + dx[dir];
            int ny = y + dy[dir];
            nowTime++;

            if((nx<1 || nx>N || ny<1 || ny>N) || map[ny][nx]==1){
                break;
            }
            snake.add(new int[]{nx, ny});
            if(map[ny][nx]!=2){
                map[snake.get(0)[1]][snake.get(0)[0]]=0;
                snake.remove(0);

            }
            map[ny][nx]=1;
            x = nx;
            y= ny;

//            for (int i = 1; i <=N ; i++) {
//                for (int j = 1; j <=N ; j++) {
//                    System.out.print(map[i][j]+" ");
//                }
//                System.out.println();
//            }
        }
        System.out.println(nowTime);
    }

    static class Dir {
        int time;
        char dir;

        public Dir(int time, char dir) {
            this.time = time;
            this.dir = dir;
        }
    }
}