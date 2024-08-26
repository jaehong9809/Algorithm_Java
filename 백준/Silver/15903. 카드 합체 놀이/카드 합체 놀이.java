import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] str = br.readLine().split(" ");
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.offer(Long.valueOf(str[i]));
        }

        for (int i = 0; i < m; i++) {
            long a = pq.poll();
            long b = pq.poll();
            pq.offer(a + b);
            pq.offer(a + b);
        }

        long sum=0;
        for (Long i : pq) {
            sum+=i;
        }
        System.out.println(sum);
    }

}