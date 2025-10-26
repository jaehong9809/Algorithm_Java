import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        // String 버전 또는 Int 버전 선택
        boolean useStringVersion = false; // false로 바꾸면 int 버전 실행


        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            if (useStringVersion) {
                String a = String.format("%04d", Integer.parseInt(s[0]));
                String b = String.format("%04d", Integer.parseInt(s[1]));
                sb.append(bfsString(a, b)).append('\n');
            } else {
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                sb.append(bfsInt(a, b)).append('\n');
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.print(sb);
    }

    // ============ String 버전 ============
    static String bfsString(String start, String target) {
        if (start.equals(target)) return "";

        Queue<String> q = new ArrayDeque<>();
        boolean[] visited = new boolean[10000];
        String[] command = new String[10000];
        int[] parent = new int[10000];

        int startNum = Integer.parseInt(start);
        q.offer(start);
        visited[startNum] = true;
        command[startNum] = "";

        while (!q.isEmpty()) {
            String now = q.poll();
            int nowNum = Integer.parseInt(now);

            // D
            int nextNum = (nowNum * 2) % 10000;
            String next = String.format("%04d", nextNum);
            if (!visited[nextNum]) {
                visited[nextNum] = true;
                command[nextNum] = "D";
                parent[nextNum] = nowNum;
                q.offer(next);
                if (next.equals(target)) return buildPath(parent, command, nextNum, startNum);
            }

            // S
            nextNum = nowNum == 0 ? 9999 : nowNum - 1;
            next = String.format("%04d", nextNum);
            if (!visited[nextNum]) {
                visited[nextNum] = true;
                command[nextNum] = "S";
                parent[nextNum] = nowNum;
                q.offer(next);
                if (next.equals(target)) return buildPath(parent, command, nextNum, startNum);
            }

            // L
            next = now.substring(1) + now.charAt(0);
            nextNum = Integer.parseInt(next);
            if (!visited[nextNum]) {
                visited[nextNum] = true;
                command[nextNum] = "L";
                parent[nextNum] = nowNum;
                q.offer(next);
                if (next.equals(target)) return buildPath(parent, command, nextNum, startNum);
            }

            // R
            next = now.charAt(3) + now.substring(0, 3);
            nextNum = Integer.parseInt(next);
            if (!visited[nextNum]) {
                visited[nextNum] = true;
                command[nextNum] = "R";
                parent[nextNum] = nowNum;
                q.offer(next);
                if (next.equals(target)) return buildPath(parent, command, nextNum, startNum);
            }
        }
        return "-1";
    }

    // ============ Int 버전 ============
    static String bfsInt(int start, int target) {
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

            // L (1234 -> 2341)
            next = (now % 1000) * 10 + now / 1000;
            if (!visited[next]) {
                visited[next] = true;
                command[next] = "L";
                parent[next] = now;
                q.offer(next);
                if (next == target) return buildPath(parent, command, target, start);
            }

            // R (1234 -> 4123)
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