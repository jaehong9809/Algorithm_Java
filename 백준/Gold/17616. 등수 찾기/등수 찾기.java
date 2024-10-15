import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int n, m, x;
    static boolean[] visited1;
    static boolean[] visited2;
    static ArrayList<Integer>[] upgraph;
    static ArrayList<Integer>[] downgraph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        visited1 = new boolean[n + 1];
        visited2 = new boolean[n + 1];
        upgraph = new ArrayList[n + 1];
        downgraph = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            upgraph[i] = new ArrayList<>();
            downgraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            upgraph[a].add(b);
            downgraph[b].add(a);
        }
        int a = bfs(upgraph, visited1, x);
        int b = bfs(downgraph, visited2, x);
        System.out.println(b + " " + (n - a + 1));
    }

    static int bfs(ArrayList<Integer>[] graph, boolean[] visited, int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;
        int cnt = 0;
        while (!queue.isEmpty()) {
            Integer now = queue.poll();
            cnt++;
            for (int i = 0; i < graph[now].size(); i++) {
                int next = graph[now].get(i);

                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
        return cnt;
    }

}