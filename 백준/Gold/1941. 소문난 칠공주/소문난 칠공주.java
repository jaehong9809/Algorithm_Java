import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

class Main{
    static int[][] map =new int[5][5];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int result=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < 5; j++) {
                if(str.charAt(j)=='S') map[i][j]=1;
            }
        }
        comb(0, 0, new ArrayList<>());
        System.out.println(result);
    }
    static void comb(int start, int depth, ArrayList<int[]> path){
        if(depth ==7){
            if(isValid(path)){
                result++;
            }
            return;
        }
        for (int i = start; i < 25; i++) {
            int x = i/5;
            int y = i%5;
            path.add(new int[]{x, y});
            comb(i+1, depth+1, path);
            path.remove(path.size()-1);
        }
    }
    static boolean isValid(ArrayList<int[]> path){
        boolean[][] selected = new boolean[5][5];
        for (int[] ints : path) {
            selected[ints[0]][ints[1]] = true;
        }

        Queue<int[]> q = new ArrayDeque<>();
        int[] start = path.get(0);
        q.offer(start);
        selected[start[0]][start[1]] = false;

        int connected = 1;
        int sCount = map[start[0]][start[1]];

        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx<0 ||nx>=5 || ny<0 || ny>=5) continue;
                if(!selected[nx][ny]) continue;

                q.offer(new int[]{nx, ny});
                selected[nx][ny] = false;
                connected++;
                sCount+=map[nx][ny];
            }
        }
        return connected==7 && sCount>=4;
    }
}