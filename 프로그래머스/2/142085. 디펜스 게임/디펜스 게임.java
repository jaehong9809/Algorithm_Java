import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int sum=0;
        
        
        for(int i=0; i<enemy.length; i++){
            sum+=enemy[i];
            pq.add(enemy[i]);
            
            if (sum > n) {
                if (k > 0) {
                    k--;
                    sum -= pq.poll(); 
                } else {
                    return answer; 
                }
            }
            answer=i+1;
        }
        return answer;
    }
}