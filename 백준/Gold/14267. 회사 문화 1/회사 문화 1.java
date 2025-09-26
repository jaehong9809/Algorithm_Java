import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int n, m;
    static ArrayList<Integer>[] graph;
    static int[] point;
    static boolean[] vi;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n + 1];
        vi = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        point = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        st.nextToken();
        for (int i = 2; i <= n; i++) {
            int a = Integer.parseInt(st.nextToken());
            graph[a].add(i);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            point[a] += b;
        }
        dfs(1);

        for (int i = 1; i <=n ; i++) {
            System.out.print(point[i]+" ");
        }
    }
    static void dfs(int start){
        if(vi[start]){
            return;
        }
        for (int i = 0; i < graph[start].size(); i++) {
            int next = graph[start].get(i);
            if(vi[next]) continue;
            point[next] +=point[start];
            dfs(next);
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();


        queue.offer(start);

        while (!queue.isEmpty()) {
            Integer now = queue.poll();

            for (int i = 0; i < graph[now].size(); i++) {
                Integer next = graph[now].get(i);
                if (vi[next]) continue;
                queue.offer(next);
                point[next] +=point[now];
            }
        }
    }

}