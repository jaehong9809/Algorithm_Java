import java.util.Scanner;
import java.util.Stack;

class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        for (int test_case = 1; test_case <= 10; test_case++) {
            int T = sc.nextInt();
            sc.nextLine();
            String str = sc.nextLine();


            Stack<Character> stack = new Stack<>();
            boolean flag = true;
            for (int i = 0; i < T; i++) {
                char c = str.charAt(i);

                if (c == ')') {
                    if (!stack.isEmpty()) {
                        if (stack.peek() == '(') {
                            stack.pop();
                        } else {
                            flag = false;
                            break;
                        }
                    } else {
                        flag = false;
                        break;
                    }
                } else if (c == ']') {
                    if (!stack.isEmpty()) {
                        if (stack.peek() == '[') {
                            stack.pop();
                        } else {
                            flag = false;
                            break;
                        }
                    } else {
                        flag = false;
                        break;
                    }
                } else if (c == '}') {
                    if (!stack.isEmpty()) {
                        if (stack.peek() == '{') {
                            stack.pop();
                        } else {
                            flag = false;
                            break;
                        }
                    } else {
                        flag = false;
                        break;
                    }
                } else if (c == '>') {
                    if (!stack.isEmpty()) {
                        if (stack.peek() == '<') {
                            stack.pop();
                        } else {
                            flag = false;
                            break;
                        }
                    } else {
                        flag = false;
                        break;
                    }
                } else {
                    stack.push(c);
                }

            }
            if (flag) {
                System.out.println("#" + test_case + " 1");
            } else {
                System.out.println("#" + test_case + " 0");
            }

        }
    }
}