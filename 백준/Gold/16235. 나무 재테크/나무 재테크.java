import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    static int n, m, k;
    static int[][] foods;
    static int[][] land;
    static PriorityQueue<Tree> trees = new PriorityQueue<>();
    static PriorityQueue<Tree> deadTrees = new PriorityQueue<>();
    static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1, };
    static int[] dy = {0, 0, -1, 1, -1, -1, 1, 1};
    static class Tree implements Comparable<Tree>{
        int x, y;
        int age;

        public Tree(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }

        @Override
        public int compareTo(Tree o) {
            return this.age - o.age;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        land = new int[n+1][n+1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(land[i], 5);
        }

        foods = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                foods[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            trees.offer(new Tree(a, b, c));
        }

        while (k > 0) {
            one();
            two();
            three();
            four();
            k--;
        }
        System.out.println(trees.size());
    }

    static void one() {
        PriorityQueue<Tree> tmp = new PriorityQueue<>();
        deadTrees = new PriorityQueue<>();
        while (!trees.isEmpty()) {
            Tree peek = trees.peek();
            if (land[peek.x][peek.y] >= peek.age) {
                land[peek.x][peek.y]-= peek.age;
                Tree poll = trees.poll();
                poll.age+=1;
                tmp.add(poll);
            }else {
                deadTrees.offer(trees.poll());
            }
        }
        trees = tmp;
    }

    static void two() {
        while (!deadTrees.isEmpty()) {
            Tree peek = deadTrees.peek();
            land[peek.x][peek.y]+= peek.age/2;
            deadTrees.poll();
        }
    }

    static void three() {
        PriorityQueue<Tree> tmp = new PriorityQueue<>();
        while (!trees.isEmpty()) {
            Tree poll = trees.poll();
            if(poll.age%5==0){
                for (int i = 0; i < 8; i++) {
                    int nx = poll.x + dx[i];
                    int ny = poll.y + dy[i];
                    if(nx<1 ||nx>n ||ny<1 ||ny>n) continue;

                    tmp.offer(new Tree(nx, ny, 1));
                }
            }
            tmp.add(poll);
        }
        trees = tmp;
    }

    static void four() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                land[i][j]+=foods[i][j];
            }
        }
    }
}