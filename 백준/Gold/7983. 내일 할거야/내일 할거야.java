import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Node> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            list.add(new Node(b - a + 1, b, a));
        }
        Collections.sort(list, (x, y) -> Integer.compare(x.end, y.end));
        int time = list.get(n-1).end+1;
        int gap = 0;
        for (int i = n-1; i >=0 ; i--) {

            if (list.get(i).end <= time) {
                time = list.get(i).end - list.get(i).d;
            }else{
                time -=list.get(i).d;
            }
//            System.out.println(time+" "+list.get(i).end);
//            System.out.println(gap);

        }
        System.out.println(time);
    }

    static class Node {
        int start, end;
        int d;

        public Node(int start, int end, int d) {
            this.start = start;
            this.end = end;
            this.d = d;
        }
    }
}