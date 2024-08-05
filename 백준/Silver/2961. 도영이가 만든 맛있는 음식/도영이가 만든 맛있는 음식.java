import java.io.*;
import java.util.StringTokenizer;

class Main{
    static int N;
    static int[][] foods;
    static int[] arr;
    static boolean[] visited;
    static long diffMin=Long.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        foods=new int[11][2];
        arr=new int[11];
        visited= new boolean[11];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            foods[i][0] = Integer.parseInt(st.nextToken());
            foods[i][1] = Integer.parseInt(st.nextToken());
        }


        for (int i = 1; i <=N ; i++) {
            dfs(0, i, 0);
        }
        System.out.println(diffMin);
    }

    static void dfs(int depth, int max, int start){
        if(depth==max){
            long tmpMul=1;
            long tmpSum=0;
            for (int i = 0; i < max; i++) {
                tmpMul*=foods[arr[i]][0];
                tmpSum+=foods[arr[i]][1];
            }
            diffMin = Math.min(diffMin, Math.abs(tmpMul - tmpSum));
            return;
        }

        for (int i = start; i <N ; i++) {
            if (!visited[i]) {
                visited[i]=true;
                arr[depth]=i;
                dfs(depth+1, max, i);
                visited[i]=false;
            }
        }
    }
}