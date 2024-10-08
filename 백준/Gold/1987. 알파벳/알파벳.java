import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static char[][] matrix;
    static int n;
    static int m;
    static boolean[][] visited;
    static Set<Character> set = new HashSet<>();
    static int[][] cntMatrix;
    static int max=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        if(n==1&&m==1){
            System.out.println(1);
            return;
        }
        sc.nextLine();
        matrix = new char[n][m];
        visited = new boolean[n][m];
        cntMatrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < m; j++) {
                matrix[i][j] = str.charAt(j);
            }
        }

        /*set.add(matrix[0][0]);
        visited[0][0]=true;*/
        //cntMatrix[0][0]=1;
        dfs(0, 0, 0);
        //dfs(0, 0);
        /*for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(cntMatrix[i][j]+" ");
            }
            System.out.println();
        }*/
        System.out.println(max);
    }

    public static void dfs(int startx, int starty, int count) {
        if (set.contains(matrix[startx][starty])) {
            max = Math.max(count, max);
            return;
        }else{
            set.add(matrix[startx][starty]);

            for (int i = 0; i < 4; i++) {
                int nextx = dx[i] + startx;
                int nexty = dy[i] + starty;
                if (!(nextx >= 0 && nextx < n && nexty >= 0 && nexty < m)) continue;
                dfs(nextx, nexty, count+1);
            }

            set.remove(matrix[startx][starty]);
        }

    }

    public static void dfs(int startx, int starty) {
       // System.out.println(matrix[startx][starty]);
        if (max < cntMatrix[startx][starty]) {
            max=cntMatrix[startx][starty];
        }
        for (int i = 0; i < 4; i++) {
            int nextx = dx[i] + startx;
            int nexty = dy[i] + starty;

            if (!(nextx >= 0 && nextx < n && nexty >= 0 && nexty < m)) continue;

            if (visited[nextx][nexty]) continue;

            if (!set.contains(matrix[nextx][nexty])) {
                visited[nextx][nexty]=true;
                cntMatrix[nextx][nexty] = cntMatrix[startx][starty] + 1;
                set.add(matrix[nextx][nexty]);
                dfs(nextx, nexty);
                set.remove(matrix[nextx][nexty]);
                visited[nextx][nexty]=false;
            }
        }
    }
}