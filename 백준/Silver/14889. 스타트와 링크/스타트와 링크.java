import java.util.Scanner;

class Main{
    static int n;
    static boolean[] visited;
    static int[][] matrix;
    static int min=Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        visited = new boolean[n+1];
        matrix=new int[n+1][n+1];

        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <= n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        dfs(0, 1);
        System.out.println(min);
    }
    public static void check(){
        int team1=0;
        int team2=0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i==j)continue;
                if(visited[i] && visited[j]){
                    team1+=matrix[i][j];
                } else if (!visited[i] && !visited[j]) {
                    team2+=matrix[i][j];
                }
            }
        }

        min = Math.min(min, Math.abs(team1 - team2));
    }
    public static void dfs(int depth, int start){
        if (depth==n/2){
            check();
            return;
        }

        for (int i = start; i <=n ; i++) {
            if (!visited[i]){
                visited[i]=true;
                dfs(depth+1, i);
                visited[i]=false;
            }
        }

    }



}