import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            sb.append(bfs(a, b)).append('\n');
        }
        System.out.print(sb);
    }

    static String bfs(int start, int target) {
        if (start == target) return "";

        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[10000];
        String[] command = new String[10000];
        int[] parent = new int[10000];

        q.offer(start);
        visited[start] = true;
        command[start] = "";

        while (!q.isEmpty()) {
            int now = q.poll();

            // D
            int next = (now * 2) % 10000;
            if (!visited[next]) {
                visited[next] = true;
                command[next] = "D";
                parent[next] = now;
                q.offer(next);
                if (next == target) return buildPath(parent, command, target, start);
            }

            // S
            next = now == 0 ? 9999 : now - 1;
            if (!visited[next]) {
                visited[next] = true;
                command[next] = "S";
                parent[next] = now;
                q.offer(next);
                if (next == target) return buildPath(parent, command, target, start);
            }

            // L
            next = (now % 1000) * 10 + now / 1000;
            if (!visited[next]) {
                visited[next] = true;
                command[next] = "L";
                parent[next] = now;
                q.offer(next);
                if (next == target) return buildPath(parent, command, target, start);
            }

            // R
            next = (now / 10) + (now % 10) * 1000;
            if (!visited[next]) {
                visited[next] = true;
                command[next] = "R";
                parent[next] = now;
                q.offer(next);
                if (next == target) return buildPath(parent, command, target, start);
            }
        }
        return "-1";
    }

    static String buildPath(int[] parent, String[] command, int target, int start) {
        StringBuilder sb = new StringBuilder();
        int cur = target;
        while (cur != start) {
            sb.append(command[cur]);
            cur = parent[cur];
        }
        return sb.reverse().toString();
    }
}