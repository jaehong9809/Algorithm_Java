import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<Character> left = new Stack<>();
        Deque<Character> right = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            left.push(input.charAt(i));
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String cmd = br.readLine();

            char init = cmd.charAt(0);
            if (init == 'L') {
                if(left.isEmpty()) continue;
                right.offerFirst(left.pop());
            } else if (init == 'D') {
                if(right.isEmpty()) continue;
                left.push(right.pollFirst());
            } else if (init == 'B') {
                if(left.isEmpty()) continue;
                left.pop();
            }else{
                left.push(cmd.charAt(2));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : left) {
            sb.append(c);
        }
        for (Character c : right) {
            sb.append(c);
        }
        System.out.println(sb);
    }
}