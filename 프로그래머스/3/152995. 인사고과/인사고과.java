import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = 0;
        int n = scores.length;
        if (n == 1) {
            return 1;
        }

        int[] values = new int[200000];

        ArrayList<Node> list = new ArrayList<>();

        int max = -1;

        for (int i = 0; i < n; i++) {
            list.add(new Node(scores[i][0], scores[i][1], scores[i][0] + scores[i][1], i));

            values[scores[i][0]] = Math.max(values[scores[i][0]], scores[i][1]);

            max = Math.max(scores[i][0], max);
        }

        Collections.sort(list, (a, b) -> {
            if (a.x == b.x) {
                return Integer.compare(a.y, b.y);
            }
            return Integer.compare(a.x, b.x);
        });

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            if(a.sum == b.sum) {
                return a.index - b.index;
            }
            return Integer.compare(b.sum, a.sum);
        });

        for (int i = 0; i < n; i++) {
            boolean sign = true;
            if (list.get(i).x == max) {
                pq.offer(list.get(i));
                continue;
            }

            for (int j = list.get(i).x + 1; j <= max; j++) {
                if (list.get(i).y < values[j]) {
                    if (list.get(i).index == 0) return -1;
                    sign = false;
                    break;
                }
            }

            if (sign) {
                pq.offer(list.get(i));
            }
        }


        int index = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            index++;
            if (node.index == 0) break;
        }


        return index;
    }

    class Node {
        int x, y;
        int sum;
        int index;
        public Node(int x, int y, int sum, int index) {
            this.x = x;
            this.y = y;
            this.sum = sum;
            this.index = index;
        }
    }
}