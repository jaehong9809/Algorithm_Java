import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> st = new Stack<>();

        int index = 0;
        int now = 1;
        StringBuilder sb = new StringBuilder();

        while (now <= n) {
            if (!st.isEmpty() && st.peek() == arr[index]) {
                index++;
                st.pop();
                sb.append("-\n");
                continue;
            }
            if (arr[index] >= now) {
                st.push(now++);
                sb.append("+\n");
            }else {
                System.out.println("NO");
                return;
            }
        }
        while (!st.isEmpty()) {
            Integer pop = st.pop();
            if (pop != arr[index]) {
                System.out.println("NO");
                return;
            }
            index++;
            sb.append("-\n");
        }
        bw.write(sb.toString());
        bw.close();

    }
}