import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int TC = 1; TC <= T; TC++) {
            int N = sc.nextInt(); // 접수 창구 수
            int M = sc.nextInt(); // 정비 창구 수
            int K = sc.nextInt(); // 고객 수
            int A = sc.nextInt(); // 관심있는 접수 창구 번호
            int B = sc.nextInt(); // 관심있는 정비 창구 번호

            int[] receptionTimes = new int[N]; // 각 접수 창구의 처리 시간
            int[] repairTimes = new int[M]; // 각 정비 창구의 처리 시간
            int[] customerArrivals = new int[K]; // 고객 도착 시간

            for (int i = 0; i < N; i++) {
                receptionTimes[i] = sc.nextInt();
            }

            for (int i = 0; i < M; i++) {
                repairTimes[i] = sc.nextInt();
            }

            for (int i = 0; i < K; i++) {
                customerArrivals[i] = sc.nextInt();
            }

            Queue<Integer> receptionQueue = new LinkedList<>(); // 접수 대기 큐
            Queue<Integer> repairQueue = new LinkedList<>(); // 정비 대기 큐

            int[] receptionDesk = new int[N]; // 접수 창구 상태
            int[] repairDesk = new int[M]; // 정비 창구 상태

            int[] receptionEndTime = new int[N]; // 접수 창구에서 처리 완료 시간
            int[] repairEndTime = new int[M]; // 정비 창구에서 처리 완료 시간

            Arrays.fill(receptionDesk, -1);
            Arrays.fill(repairDesk, -1);

            int time = 0; // 현재 시간
            int finishedCount = 0; // 처리 완료된 고객 수
            int result = 0; // 결과

            boolean[] visitedReception = new boolean[K]; // 특정 접수 창구를 거친 고객 확인
            boolean[] visitedRepair = new boolean[K]; // 특정 정비 창구를 거친 고객 확인

            while (finishedCount < K) {
                // 고객 도착 처리
                for (int i = 0; i < K; i++) {
                    if (customerArrivals[i] == time) {
                        receptionQueue.add(i);
                    }
                }

                // 접수 창구에서 작업 완료된 고객들을 정비 대기 큐로 이동
                for (int i = 0; i < N; i++) {
                    if (receptionDesk[i] != -1 && receptionEndTime[i] == time) {
                        repairQueue.add(receptionDesk[i]);
                        receptionDesk[i] = -1;
                    }
                }

                // 정비 창구에서 작업 완료된 고객 처리
                for (int i = 0; i < M; i++) {
                    if (repairDesk[i] != -1 && repairEndTime[i] == time) {
                        finishedCount++;
                        if (visitedReception[repairDesk[i]] && visitedRepair[repairDesk[i]]) {
                            result += repairDesk[i] + 1; // 고객 번호는 1부터 시작
                        }
                        repairDesk[i] = -1;
                    }
                }

                // 접수 창구에 고객 배정
                for (int i = 0; i < N; i++) {
                    if (receptionDesk[i] == -1 && !receptionQueue.isEmpty()) {
                        int customer = receptionQueue.poll();
                        receptionDesk[i] = customer;
                        receptionEndTime[i] = time + receptionTimes[i];

                        // 고객이 관심 창구 A를 방문했는지 체크
                        if (i + 1 == A) {
                            visitedReception[customer] = true;
                        }
                    }
                }

                // 정비 창구에 고객 배정
                for (int i = 0; i < M; i++) {
                    if (repairDesk[i] == -1 && !repairQueue.isEmpty()) {
                        int customer = repairQueue.poll();
                        repairDesk[i] = customer;
                        repairEndTime[i] = time + repairTimes[i];

                        // 고객이 관심 창구 B를 방문했는지 체크
                        if (i + 1 == B) {
                            visitedRepair[customer] = true;
                        }
                    }
                }

                // 시간 증가
                time++;
            }

            // 결과 출력
            if (result == 0) {
                System.out.println("#"+TC+" "+-1);
            } else {
                System.out.println("#"+TC+" "+result);
            }

        }

    }
}