import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] studies=new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            studies[i][0] = Integer.parseInt(str[0]);
            studies[i][1] = Integer.parseInt(str[1]);
        }

        Arrays.sort(studies, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (pq.isEmpty()) {
                pq.offer(new Node(studies[i][0], studies[i][1]));
            }else{
                if(pq.peek().end <= studies[i][0]){
                    pq.poll();
                    pq.offer(new Node(studies[i][0], studies[i][1]));
                }else{
                    pq.offer(new Node(studies[i][0], studies[i][1]));
                }
            }
            if (max < pq.size()) {
                max = pq.size();
            }
        }

        System.out.println(max);
    }
    static class Node implements Comparable<Node>{
        int start;
        int end;
        int interval;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
            this.interval = end-start;
        }

        @Override
        public int compareTo(Node o) {
            return this.end - o.end;
        }
    }
}