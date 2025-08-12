import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int n, m;
    static int[] indegree;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        indegree = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            String[] s = br.readLine().split(" ");

            for (int j = 1; j < s.length - 1; j++) {
                int now = Integer.parseInt(s[j]);
                int next = Integer.parseInt(s[j + 1]);
                graph[next].add(now);
                indegree[now]++;
            }
        }

        topologicalSort();
    }

    static void topologicalSort() {
        Queue<Integer> q = new ArrayDeque<>();
        Stack<Integer> res = new Stack<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            Integer now = q.poll();
            res.add(now);
            for (Integer i : graph[now]) {
                indegree[i]--;
                if (indegree[i] == 0) {
                    q.offer(i);
                }
            }
        }
        if (res.size() != n) {
            System.out.println(0);
            return;
        }
        while (!res.isEmpty()) {
            System.out.println(res.pop());
        }
    }
}