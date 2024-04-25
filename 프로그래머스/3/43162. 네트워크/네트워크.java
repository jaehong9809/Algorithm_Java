import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static boolean[] visited;

    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i, computers);
                answer++;
            }
        }
        return answer;
    }

    public void bfs(int start, int[][] computers) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            Integer now = queue.poll();
            for (int i = 0; i < computers.length; i++) {
                if (now == i) continue;
                if (computers[now][i] == 1) {
                    int next = i;

                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
        }
    }
}