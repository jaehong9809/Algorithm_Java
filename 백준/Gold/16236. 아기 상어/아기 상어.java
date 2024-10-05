import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Main{
    /*
        물고기

     */
    static int[] dx={-1, 1, 0, 0};
    static int[] dy={0, 0, -1, 1};
    static int[][] matrix;
    static int foodNumber=-1;
    static int n;
    static int sharkSize=2;
    static int eatCount=0;
    static int totalTime=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        matrix=new int[n][n];
        int startx=0;
        int starty=0;
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                matrix[i][j]=Integer.parseInt(s[j]);
                if(matrix[i][j]==9){
                    startx=i;
                    starty=j;
                }
            }
        }
        matrix[startx][starty]=0;
        while (foodNumber!=0){
            //System.out.println(startx+" "+starty+" 로 시작!!!!!");
            foodNumber=0;
            Node next = bfs(startx, starty);
            if(next==null){
                break;
            }
            eatCount++;
            startx=next.x;
            starty=next.y;
            if(eatCount==sharkSize){
                sharkSize++;
                eatCount=0;
            }
            matrix[next.x][next.y]=0;
            totalTime+=next.distance;
            //System.out.println("이동한 거리 "+totalTime+" ----------");
        }
        System.out.println(totalTime);
    }

    private static Node bfs(int startx, int starty) {
        Queue<Pair> queue = new LinkedList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();
        queue.offer(new Pair(startx, starty));
        int[][] visited = new int[n][n];
        visited[startx][starty]=1;

        while (!queue.isEmpty()) {
            Pair now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextx=dx[i]+now.x;
                int nexty=dy[i]+now.y;
                if(nextx<0||nextx>=n||nexty<0||nexty>=n)continue;

                if(visited[nextx][nexty]==0&&matrix[nextx][nexty]<=sharkSize){
                    visited[nextx][nexty]=visited[now.x][now.y]+1;
                    queue.offer(new Pair(nextx, nexty));
                    if(matrix[nextx][nexty]<sharkSize&&matrix[nextx][nexty]!=0){
                        pq.offer(new Node(nextx, nexty,visited[nextx][nexty]-1));
                    }
                }
            }
        }
        foodNumber = pq.size();
        //System.out.println("먹을 수 있는 물고기 "+pq.size()+" 개 있음--------");
        if(pq.size()==0){
            return null;
        }

        return pq.peek();
    }
    static class Node implements Comparable<Node>{
        public int x;
        public int y;
        public int distance;

        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            if(this.distance==o.distance){
                if(this.x==o.x){
                    return this.y-o.y;
                }
                return this.x-o.x;
            }
            return this.distance-o.distance;
        }
    }

    static class Pair{
        public int x;
        public int y;
        public Pair(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
}