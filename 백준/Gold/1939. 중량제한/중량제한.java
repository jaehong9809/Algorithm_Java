import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main{
    static int n, m;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static int start, end;
    static boolean[] visited;
    static int max, min;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            min = Math.min(c, min);
            max = Math.max(c, max);
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }
        start = sc.nextInt();
        end = sc.nextInt();
        int res=-1;
        while (min <= max) {
            int mid  = (min+max)/2;
            visited = new boolean[n + 1];
            boolean sign = bfs(mid);

            if (sign) {
                min = mid + 1;
                res=mid;
            }else{
                max = mid-1;
            }

        }

        System.out.println(res);
    }

    static boolean bfs(int mid) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            Integer now = q.poll();
            if (now ==end) return true;

            for (int i = 0; i < graph.get(now).size(); i++) {
                int nextNode = graph.get(now).get(i).y;
                int cost = graph.get(now).get(i).weight;
                if (cost >= mid && !visited[nextNode]) {
                    visited[nextNode] = true;
                    q.offer(nextNode);
                }
            }
        }
        return false;
    }


    static class Node{
        int y;
        int weight;

        public Node(int y, int weight) {
            this.y = y;
            this.weight = weight;
        }
    }
}