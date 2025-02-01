import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        ArrayList<String> results = new ArrayList<>();
        PriorityQueue<Plan> pq = new PriorityQueue<>();    
        Stack<Plan> toDoList = new Stack<>();

        // 우선순위 큐에 데이터 추가
        for (String[] plan : plans) {
            pq.offer(new Plan(plan[0], plan[1], Integer.parseInt(plan[2])));
        }

        Plan now = pq.poll();
        int time = now.start;

        while (!pq.isEmpty()) {
            Plan plan = pq.peek();  // 다음 과제 확인

            if (time + now.playtime > plan.start) { 
                // 현재 과제가 다음 과제의 시작 시간보다 늦게 끝나면
                now.playtime -= (plan.start - time); // 남은 playtime을 조정
                toDoList.push(now); // 중단된 과제 저장
                now = pq.poll(); // 다음 과제로 변경
                time = now.start; // 새로운 과제 시작 시간으로 설정
            } else {
                // 현재 과제를 정상적으로 끝낼 수 있는 경우
                time += now.playtime;
                results.add(now.name);
                
                if (!toDoList.isEmpty()) {
                    now = toDoList.pop();
                } else if (!pq.isEmpty()) {
                    now = pq.poll();
                    time = now.start;
                }
            }
        }

        // 마지막 과제 추가
        results.add(now.name);

        // 스택에 남은 과제 처리
        while (!toDoList.isEmpty()) {
            results.add(toDoList.pop().name);
        }

        return results.toArray(new String[0]);
    }

    static class Plan implements Comparable<Plan> {
        String name;
        int start;
        int playtime;

        public Plan(String name, String start, int playtime) {
            String[] str = start.split(":");
            this.name = name;
            this.start = Integer.parseInt(str[0]) * 60 + Integer.parseInt(str[1]);
            this.playtime = playtime;
        }

        @Override
        public int compareTo(Plan o) {
            return this.start - o.start;
        }
    }
}
