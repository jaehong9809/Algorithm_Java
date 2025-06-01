import java.util.*;

class Main {
    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int TESTCASE = 0; TESTCASE < t; TESTCASE++) {
            int n = sc.nextInt();
            graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < n - 1; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                graph.get(b).add(a);
            }
            int x = sc.nextInt();
            int y = sc.nextInt();
            List<Integer> result1 = func(x, n);

            List<Integer> result2 = func(y, n);

            boolean sign = false;
            
            for (int i = 0; i < result1.size(); i++) {
                for (int j = 0; j < result2.size(); j++) {
                    if (result1.get(i).equals(result2.get(j))) {
                        System.out.println(result1.get(i));
                        sign = true;
                        break;
                    }
                }
                if (sign) break;
            }
        }
    }

    static List<Integer> func(int start, int n) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        boolean[] visited = new boolean[n + 1];

        visited[start] = true;
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            result.add(poll);
            for (int i = 0; i < graph.get(poll).size(); i++) {
                int next = graph.get(poll).get(i);

                if (visited[next]) continue;
                queue.offer(next);
                visited[next] = true;
            }
        }
        return result;
    }
}