import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        int T = sc.nextInt();
        
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] data = new int[n];
            for (int i = 0; i < n; i++) {
                data[i] = sc.nextInt();
            }
            
            // 우선순위 큐 설정
            PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());
            PriorityQueue<Integer> right = new PriorityQueue<>();
            ArrayList<Integer> result = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                int num = data[i];
                
                // 왼쪽 힙이 비어있거나 num이 왼쪽 힙의 최대값보다 작거나 같으면 왼쪽 힙에 추가
                if (left.isEmpty() || num <= left.peek()) {
                    left.offer(num);
                } else {
                    right.offer(num);
                }
                
                // 왼쪽 힙의 크기가 오른쪽 힙보다 2개 이상 클 경우 오른쪽 힙으로 이동
                if (left.size() > right.size() + 1) {
                    right.offer(left.poll());
                }
                // 오른쪽 힙의 크기가 왼쪽 힙보다 클 경우 왼쪽 힙으로 이동
                else if (right.size() > left.size()) {
                    left.offer(right.poll());
                }
                
                // 중앙값을 수집
                if (i % 2 == 0) {
                    result.add(left.peek());
                }
            }
            
            // 결과를 StringBuilder에 추가
            sb.append(result.size()).append("\n");
            for (int i = 0; i < result.size(); i++) {
                sb.append(result.get(i)).append(" ");
                if ((i + 1) % 10 == 0) {
                    sb.append("\n");
                }
            }
            if (result.size() % 10 != 0) {
                sb.append("\n");
            }
        }
        
        System.out.print(sb.toString());
    }
}