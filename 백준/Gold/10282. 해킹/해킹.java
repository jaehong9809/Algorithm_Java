import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int INF = 1_000_000_000;
    static ArrayList<Node>[] graph;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph = new ArrayList[n + 1];

            dp = new int[n + 1];
            Arrays.fill(dp, INF);
            dp[c] = 0;

            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                graph[b].add(new Node(a, s));
            }
            dijkstra(c);
            int cnt = 0;
            int max = Integer.MIN_VALUE;
            for (int i = 1; i <= n; i++) {
                if (dp[i] != INF) {
                    cnt++;
                    max = Math.max(dp[i], max);
                }
            }
            System.out.println(cnt + " " + max);
        }
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        set.add(start);
        pq.offer(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node poll = pq.poll();
            int now = poll.x;
            int cost = poll.y;

            if (dp[now] < cost) continue;
            for (int i = 0; i < graph[now].size(); i++) {
                int nextNode = graph[now].get(i).x;
                int nextCost = graph[now].get(i).y;
                if (dp[nextNode] > nextCost + cost) {
                    dp[nextNode] = nextCost + cost;
                    pq.offer(new Node(nextNode, nextCost + cost));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Node o) {
            return this.y - o.y;
        }
    }
}