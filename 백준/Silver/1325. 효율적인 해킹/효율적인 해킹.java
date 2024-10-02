import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static ArrayList<Integer>[] graph;
    static ArrayList<Integer> res = new ArrayList<>();
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[b].add(a);
        }

        int maxReachable = -1;
        for (int i = 1; i <= n; i++) {
            int now = bfs(i);
            if (now > maxReachable) {
                maxReachable = now;
                res.clear();
                res.add(i);
            } else if (now == maxReachable) {
                res.add(i);
            }
        }

        Collections.sort(res);
        for (Integer re : res) {
            System.out.print(re + " ");
        }
    }

    static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        int[] visited = new int[n + 1];
        visited[start] = 1;
        int count = 0; // 도달 가능한 노드 수

        while (!queue.isEmpty()) {
            int poll = queue.poll();
            count++; // 현재 노드 방문

            for (int neighbor : graph[poll]) {
                if (visited[neighbor] == 0) {
                    queue.offer(neighbor);
                    visited[neighbor] = 1; // 방문 표시
                }
            }
        }
        return count; // 도달 가능한 노드 수 반환
    }
}