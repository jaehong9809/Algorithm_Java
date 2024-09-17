import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i <= 26; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            int start = str[0].charAt(0) - 'a';
            int end = str[2].charAt(0) - 'a';
            graph.get(start).add(end);
        }

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            String[] str = br.readLine().split(" ");
            int start = str[0].charAt(0) - 'a';
            int end = str[2].charAt(0) - 'a';

            if (bfs(start, end)) {
                System.out.println("T");
            } else {
                System.out.println("F");
            }
        }
        br.close();
    }

    static boolean bfs(int start, int end) {
        boolean[] visited = new boolean[27];
        visited[start] = true;
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        
        while (!queue.isEmpty()) {
            int now = queue.poll();
            
            if (now == end) return true;
            
            for (int i = 0; i < graph.get(now).size(); i++) {
                int next = graph.get(now).get(i);
                
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
        return false;
    }

}