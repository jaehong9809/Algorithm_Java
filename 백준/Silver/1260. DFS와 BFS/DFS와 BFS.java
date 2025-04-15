import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    static int n, m, v;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input=br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < m; i++) {
            String input2 = br.readLine();
            st = new StringTokenizer(input2);
            int a, b;
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for (int i = 0; i <=n ; i++) {
            Collections.sort(graph.get(i));
        }
        visited=new int[n+1];
        dfs(v);
        System.out.println();
        visited=new int[n+1];
        bfs(v);
        System.out.println();

    }

    private static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        visited[v]=1;
        while (!q.isEmpty()) {
            int now = q.poll();
            System.out.print(now+" ");
            for (int i = 0; i < graph.get(now).size(); i++) {
                if (visited[graph.get(now).get(i)] == 0) {
                    q.offer(graph.get(now).get(i));
                    visited[graph.get(now).get(i)]=1;
                }
            }
        }
    }

    private static void dfs(int v) {
        visited[v]=1;
        System.out.print(v+" ");
        for (int i = 0; i < graph.get(v).size(); i++) {
            if(visited[graph.get(v).get(i)]==0){
                dfs(graph.get(v).get(i));
            }
        }
    }
}