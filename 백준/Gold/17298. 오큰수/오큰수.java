import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> st = new Stack<>();


        int[] data=new int[n+1];

        String[] str = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            data[i] = Integer.parseInt(str[i-1]);
        }
        int[] results = new int[n+1];

        for(int i=n; i>=1; i--){
            while (!st.isEmpty() && st.peek() <= data[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                results[i] = st.peek();
            }else{
                results[i] = -1;
            }
            st.push(data[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <=n ; i++) {
            sb.append(results[i]).append(" ");
        }
        System.out.println(sb);

    }
}