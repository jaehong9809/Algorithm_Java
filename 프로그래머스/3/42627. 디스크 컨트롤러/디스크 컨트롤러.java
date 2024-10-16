import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int n = jobs.length;
        PriorityQueue<Job> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost); // 작업의 소요 시간 기준으로 정렬
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]); // 작업 요청 시간 기준으로 정렬
        
        int time = 0; // 현재 시간
        int index = 0; // jobs 배열의 인덱스
        int count = 0; // 완료된 작업 수

        while (count < n) {
            // 현재 시간까지 요청된 모든 작업을 우선순위 큐에 추가
            while (index < n && jobs[index][0] <= time) {
                pq.offer(new Job(jobs[index][0], jobs[index][1]));
                index++;
            }

            // 큐가 비어있지 않다면 작업을 하나 꺼내서 처리
            if (!pq.isEmpty()) {
                Job job = pq.poll();
                time += job.cost; // 현재 시간에 소요 시간 추가
                answer += time - job.time; // 요청부터 종료까지 걸린 시간
                count++;
            } else {
                // 큐가 비어있다면 다음 작업의 요청 시간으로 이동
                time = jobs[index][0];
            }
        }

        return answer / n; // 평균값 계산
    }

    class Job {
        int time; // 작업 요청 시간
        int cost; // 작업 소요 시간

        public Job(int time, int cost) {
            this.time = time;
            this.cost = cost;
        }
    }
}
