import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.LockInfo;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<int[]> sub = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] arr = br.readLine().split(" ");
            sub.add(new int[]{Integer.parseInt(arr[0]), Integer.parseInt(arr[1])});
        }
        Collections.sort(sub, (a, b) -> a[0] - b[0]);

        int index =0;
        int[] sum = new int[n];
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.endtime - b.endtime);
        PriorityQueue<Node> availablepq = new PriorityQueue<>((a, b) -> a.index - b.index);
        for (int i = 0; i < n; i++) {
            int start = sub.get(i)[0];
            int end = sub.get(i)[1];

            while (!pq.isEmpty() && pq.peek().endtime < start) {
                availablepq.add(pq.poll());
            }

            if(!availablepq.isEmpty()){
                Node poll = availablepq.poll();
                poll.endtime = end;
                sum[poll.index]++;
                pq.offer(poll);
            }else{
                pq.offer(new Node(index, end));
                sum[index++]=1;
            }
        }
        System.out.println(index);
        for (int i = 0; i < index; i++) {
            System.out.print(sum[i] + " ");
        }
    }

    static class Node {
        int endtime;
        int index;

        public Node(int index, int endtime) {
            this.index = index;
            this.endtime = endtime;
        }
    }


}