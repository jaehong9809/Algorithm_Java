import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int n;
    static int[] indegree;
    static int[] cost;
    static ArrayList<Integer>[] graph;
    static int[] results;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        indegree = new int[n + 1];
        cost = new int[n + 1];
        graph = new ArrayList[n + 1];
        results = new int[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            String[] s = br.readLine().split(" ");
            cost[i] = Integer.parseInt(s[0]);

            for (int j = 1; j < s.length - 1; j++) {
                graph[Integer.parseInt(s[j])].add(i);
                indegree[i]++;
            }
        }

        topolSort();
        for (int i = 1; i <=n ; i++) {
            System.out.println(results[i]);
        }
    }

    static void topolSort() {
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
                results[i] = cost[i];
            }
        }
        while (!q.isEmpty()) {
            Integer now = q.poll();

            for (int i = 0; i < graph[now].size(); i++) {
                indegree[graph[now].get(i)]--;
                results[graph[now].get(i)] = Math.max(results[graph[now].get(i)], results[now] + cost[graph[now].get(i)]);
                
                if (indegree[graph[now].get(i)] == 0) {
                    q.offer(graph[now].get(i));
                }
            }
        }

    }
}