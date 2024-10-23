import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int n = queue1.length;
        long sum1 = 0;
        long sum2 = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for(int i=0; i<n; i++){
            sum1+=queue1[i];
            q1.offer(queue1[i]);
            sum2+=queue2[i];
            q2.offer(queue2[i]);
        }
        
        if((sum1+sum2) %2!=0) return -1;
        int cnt=0;
        while(sum1!=sum2){
            if(sum1 < sum2){
                int poll = q2.poll();
                q1.offer(poll);
                sum2-=poll;
                sum1+=poll;
            }else if(sum1 > sum2){
                int poll = q1.poll();
                q2.offer(poll);
                sum1-=poll;
                sum2+=poll;
            }
            cnt++;
            if(cnt>300000) return -1;
        }
        return cnt;
    }
}