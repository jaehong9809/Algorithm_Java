import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
    static int n, m;
    static int[] inDegree;
    static ArrayList<Integer>[] graph;
    static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        inDegree = new int[n + 1];
        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
            inDegree[b]++;
        }
        topologySort();
        for (Integer i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static void topologySort() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer now = queue.poll();
            result.add(now);
            for (int i = 0; i < graph[now].size(); i++) {
                int next = graph[now].get(i);
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
    }
}