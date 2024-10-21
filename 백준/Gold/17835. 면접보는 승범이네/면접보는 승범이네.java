import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int n, m, k;

    static class Node implements Comparable<Node> {
        int y;
        long cost;

        public Node(int y, long cost) {
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.cost, o.cost);
        }
    }

    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(b).add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            list.add(tmp);
        }


        long[] dijkstra = dijkstra();
        long max = -1;
        long index = 0;

        for (int i = 1; i <= n; i++) {
            if (max < dijkstra[i]) {
                max = dijkstra[i];
                index = i;
            }
        }
        System.out.println(index);
        System.out.println(max);
    }

    static long[] dijkstra() {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        long[] d = new long[n + 1];
        Arrays.fill(d, Long.MAX_VALUE);

        for (Integer i : list) {
            priorityQueue.offer(new Node(i, 0));
            d[i] = 0;
        }

        while (!priorityQueue.isEmpty()) {
            Node poll = priorityQueue.poll();

            if (poll.cost > d[poll.y]) continue;

            for (int i = 0; i < graph.get(poll.y).size(); i++) {
                int nextNode = graph.get(poll.y).get(i).y;
                long cost = d[poll.y] + graph.get(poll.y).get(i).cost;
                if (d[nextNode] > cost) {
                    d[nextNode] = cost;
                    priorityQueue.offer(new Node(nextNode, cost));
                }
            }
        }

        return d;
    }
}