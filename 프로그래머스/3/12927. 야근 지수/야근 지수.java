import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        
        for(int time : works){
            pq.offer(time);
        }
        
        while(n!=0){
            if(pq.isEmpty()){
                return 0;
            }
            int max = pq.poll();
            max--;
            if(max!=0) pq.offer(max);
            n--;
        }
        while(!pq.isEmpty()){
            int now = pq.poll();
            answer+=now*now;
        }
        return answer;
    }
}