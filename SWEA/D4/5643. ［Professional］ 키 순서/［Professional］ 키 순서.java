import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {
    static int n,m;
    static int[][] matrix;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int TESTCASE = 1; TESTCASE <= T; TESTCASE++) {
            n = Integer.parseInt(br.readLine());
            m = Integer.parseInt(br.readLine());
            matrix = new int[n+1][n+1];
            for (int i = 0; i < m; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                matrix[a][b]=1;
            }
            int ans=0;
            for (int i = 1; i <=n ; i++) {
                if(gtBFS(i)+ltBFS(i) ==n-1){
                    ans++;
                }
            }
            System.out.println("#"+TESTCASE+" "+ans);

        }
    }
    static int gtBFS(int start){
        Queue<Integer> queue=new ArrayDeque<>();
        boolean[] visited=new boolean[n+1];
        queue.offer(start);visited[start]=true;
        int cnt=0;
        while (!queue.isEmpty()) {
            Integer now = queue.poll();
            for (int i = 1; i <=n ; i++) {
                if (!visited[i] && matrix[now][i] != 0) {
                    queue.offer(i);
                    visited[i] =true;
                    cnt++;
                }
            }
        }
        return cnt;
    }
    static int ltBFS(int start){
        Queue<Integer> queue=new ArrayDeque<>();
        boolean[] visited=new boolean[n+1];
        queue.offer(start);visited[start]=true;
        int cnt=0;
        while (!queue.isEmpty()) {
            Integer now = queue.poll();
            for (int i = 1; i <=n ; i++) {
                if (!visited[i] && matrix[i][now] != 0) {
                    queue.offer(i);
                    visited[i] =true;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}