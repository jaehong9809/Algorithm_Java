import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

class Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        sc.nextLine();
        StringBuilder sb = new StringBuilder();
        for (int TESTCASE = 0; TESTCASE < t; TESTCASE++) {
            String input = sc.nextLine();

            Stack<Character> left = new Stack<>();
            Deque<Character> rightdeq = new LinkedList<>();

            for (int i = 0; i <input.length() ; i++) {
                char c = input.charAt(i);

                if(c=='<'){
                    if(!left.isEmpty()){
                        rightdeq.offerFirst(left.pop());
                    }
                }else if(c=='>'){
                    if(!rightdeq.isEmpty()){
                        left.push(rightdeq.pollFirst());
                    }
                }else if(c=='-'){
                    if(!left.isEmpty()){
                        left.pop();
                    }
                }else{
                    left.push(c);
                }
            }
            for (Character character : left) {
                sb.append(character);
            }
            for (Character character : rightdeq) {
                sb.append(character);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}