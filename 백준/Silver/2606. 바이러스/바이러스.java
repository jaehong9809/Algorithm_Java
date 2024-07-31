import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main{
    static int matrix[][];
    static int v, e;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        v = Integer.parseInt(br.readLine());
        e = Integer.parseInt(br.readLine());
        matrix=new int[v+1][v+1];
        for (int i = 0; i < e; i++) {
            String s = br.readLine();
            StringTokenizer st=new StringTokenizer(s);
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            matrix[a][b]=1;
            matrix[b][a]=1;
        }
        int result=bfs(1);
        System.out.println(result);
    }

    public static int bfs(int startx) {
        int cnt=0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startx);
        int visited[]=new int[v+1];
        visited[startx]=1;
        while (!queue.isEmpty()){
            int now=queue.poll();
            for (int i = 1; i <=v ; i++) {
                if(matrix[now][i]==1&&visited[i]!=1){
                    queue.offer(i);
                    visited[i]=1;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}