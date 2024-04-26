import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main{
    static int n;
    static int m;
    static int[][] matrix;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m= sc.nextInt();
        matrix=new int[n][m];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < m; j++) {
                matrix[i][j] = str.charAt(j) - '0';
            }
        }

        bfs(0, 0);
        System.out.println(matrix[n-1][m-1]);

    }

    public static void bfs(int startX, int startY){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX=dx[i]+poll[0];
                int nextY=dy[i]+poll[1];
                if(nextX>=0 &&nextX<n&&nextY>=0&&nextY<m){
                    if(matrix[nextX][nextY]==1){
                        queue.offer(new int[]{nextX, nextY});
                        if(nextX==startX&& nextY==startY) continue;
                        matrix[nextX][nextY] = matrix[poll[0]][poll[1]]+1;
                    }
                }

            }
        }


    }
}