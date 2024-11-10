import java.util.*;

class Main {
    static int a, b, c, d;
    static Set<String> set = new HashSet<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt();
        int res = bfs();
        System.out.println(res);
    }

    static int bfs() {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(0, 0, 0));

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if(now.a ==c && now.b ==d){
                return now.cnt;
            }
            for (int i = 0; i < 6; i++) {
                Node next = new Node(now.a, now.b, now.cnt+1);
                if (i == 0) {
                    next.a = 0;
                } else if (i == 1) {
                    next.a = a;
                } else if (i == 2) {
                    next.b = 0;
                } else if (i == 3) {
                    next.b = b;
                } else if (i == 4) {
                    int rest = a - next.a;
                    if(rest >= next.b ){
                        next.a +=next.b;
                        next.b=0;
                    }else{
                        next.a = a;
                        next.b -=rest;
                    }
                } else {
                    int rest = b - next.b;
                    if(rest >= next.a ){
                        next.b +=next.a;
                        next.a=0;
                    }else{
                        next.b = b;
                        next.a -=rest;
                    }
                }
                String tmp = next.a+" "+next.b;
                if(set.contains(tmp)){
                    continue;
                }
                set.add(tmp);

                queue.offer(next);
            }
        }
        return -1;
    }

    static class Node {
        int a;
        int b;
        int cnt=0;
        public Node(int a, int b, int cnt) {
            this.a = a;
            this.b = b;
            this.cnt = cnt;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "a=" + a +
                    ", b=" + b +
                    ", cnt=" + cnt +
                    '}';
        }
    }

}