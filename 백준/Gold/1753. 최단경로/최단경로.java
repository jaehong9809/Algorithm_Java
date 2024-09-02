import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Main {
    static int INF = (int)1e9;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v =sc.nextInt();
        int e =sc.nextInt();
        int k = sc.nextInt();

        int[] d = new int[v+1];
        Arrays.fill(d, INF);

        ArrayList<Node>[] graph = new ArrayList[v+1];
        for (int i = 1; i <=v ; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph[a].add(new Node(b, c));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(k, 0));
        d[k]=0;
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if(d[now.to]< now.weight) continue;


            for (int i = 0; i < graph[now.to].size(); i++) {
                int nextweight = d[now.to] + graph[now.to].get(i).weight;
                int nextNode = graph[now.to].get(i).to;

                if (d[nextNode] > nextweight) {
                    pq.offer(new Node(nextNode, nextweight));
                    d[nextNode] = nextweight;
                }
            }
        }
        for (int i = 1; i <=v ; i++) {
            if(d[i]==INF){
                System.out.println("INF");
            }else{
                System.out.println(d[i]);
            }
        }

    }

    static class Node implements Comparable<Node>{
        int to,weight;
        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}