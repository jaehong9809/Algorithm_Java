
import java.util.PriorityQueue;
import java.util.Scanner;

class Main {
    static int n;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n= sc.nextInt();
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            long tmp= sc.nextLong();
            pq.offer(tmp);
        }
        long total=0;
        if(n==1){
            System.out.println(0);
            return;
        }
        if(n==2){
            System.out.println(pq.poll()+pq.poll());
            return;
        }
        while (pq.size()!=2){
            long a=pq.poll();
            long b=pq.poll();
            total=total+a+b;
            pq.offer(a+b);
        }
        System.out.println(total+pq.poll()+pq.poll());
    }
}