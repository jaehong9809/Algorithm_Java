import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main{
    static int n, m;
    static int[][] matrix=new int[1001][1001];
    static int[] visited = new int[1001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n= sc.nextInt();
        m= sc.nextInt();
        for (int i = 0; i < m; i++) {
            int a, b;
            a= sc.nextInt();
            b= sc.nextInt();
            matrix[a][b]=1;
            matrix[b][a]=1;
        }
        int cnt=0;
        for (int i = 1; i <=n ; i++) {
            if(visited[i]==0){
                bfs(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static void bfs(int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        visited[i]=1;
        while (!queue.isEmpty()){
            int now=queue.poll();
            for (int j = 1; j <=n ; j++) {
                if(matrix[now][j]==1&&visited[j]==0){
                    queue.offer(j);
                    visited[j]=1;
                }
            }
        }
    }

}