import java.util.*;
import java.io.FileInputStream;

class Solution {
    final static int[] dx = {-1, 1, 0};
    final static int[] dy = {0, 0,-1};

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int T;
        

        for (int test_case = 1; test_case <= 10; test_case++) {
            T = sc.nextInt();
            int[][] map = new int[101][101];
            List<Integer> list = new ArrayList<>();
            int target = -1;
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    map[i][j] = sc.nextInt();
                    if (i == 0) {
                        if (map[i][j] == 1) {
                            list.add(j);
                        }
                    }

                    if (i == 99) {
                        if (map[i][j] == 2) {
                            target = j;
                        }
                    }
                }
            }

            System.out.println("#"+T+" "+bfs(map, target));

//
//            for (int i = 0; i < 100; i++) {
//                for (int j = 0; j < 100; j++) {
//                    System.out.print(map[i][j]+" ");
//                }
//                System.out.println();
//            }

        }
    }

    static int bfs(int[][] map, int target) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{99, target});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 3; i++) {
                int nx = now[1]+dx[i];
                int ny = now[0]+dy[i];
                if (nx < 0 || nx >= 100 || ny < 0 || ny >= 100) {
                    continue;
                }

                if(map[ny][nx]==1){
                    if(i!=2){
                        map[ny][nx]=2;
                        queue.offer(new int[]{ny, nx});
                        break;
                    }
                    map[ny][nx]=2;
                    queue.offer(new int[]{ny, nx});
                }
            }

        }

        for (int i = 0; i <100 ; i++) {
            if(map[0][i]==2){
                return i;
            }
        }
        return -1;
    }

}