import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<String>[] queues = new Queue[n];
        for (int i = 0; i < n; i++) {
            queues[i] = new ArrayDeque<>();
        }

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (String string : s) {
                queues[i].offer(string);
            }
        }
        String[] answer = br.readLine().split(" ");

        for (String string : answer) {
            boolean sign = false;
            for (int i = 0; i < n; i++) {
                if (queues[i].isEmpty()) continue;

                if (queues[i].peek().equals(string)) {
                    queues[i].poll();
                    sign = true;
                }
            }
            if (!sign) {
                System.out.println("Impossible");
                return;
            }
        }
        for (int i = 0; i < n; i++) {
            if(!queues[i].isEmpty()){
                System.out.println("Impossible");
                return;
            }
        }

        System.out.println("Possible");
    }
}