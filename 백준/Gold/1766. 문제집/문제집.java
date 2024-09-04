import java.util.*;

class Main {
    static int n, m;
    static ArrayList<Integer>[] graph;
    static int[] indegrees;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        graph = new ArrayList[n+1];
        indegrees=new int[n+1];
        for (int i = 1; i <=n ; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a= sc.nextInt();
            int b=sc.nextInt();
            graph[a].add(b);
            indegrees[b]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            if(indegrees[i]==0){
                pq.add(i);
            }
        }

        while (!pq.isEmpty()) {
            Integer now = pq.poll();
            System.out.print(now+" ");
            for (int i = 0; i < graph[now].size(); i++) {
                Integer next = graph[now].get(i);

                if(indegrees[next]>0){
                    indegrees[next]--;
                }

                if (indegrees[next] == 0) {
                    pq.offer(next);
                }
            }

        }
    }
    static class Node{
        int easy;
        int indegree;

        public Node(int easy, int indegree) {
            this.easy = easy;
            this.indegree = indegree;
        }
    }
}