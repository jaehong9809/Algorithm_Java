import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        PriorityQueue<Computer> pq = new PriorityQueue<>();
        
        for(int i=0; i<24; i++){
            int nowUserNum = players[i];
            
            while(true){
                if(pq.isEmpty()) break;
                
                if(pq.peek().end <=i){
                    pq.poll();
                }else{
                    break;
                }
            }
            
            if(nowUserNum >=m){
                int cnt = (nowUserNum / m) - pq.size();
                
                if(cnt<=0) continue;
                else answer+=cnt;
                
                for(int j=0; j<cnt; j++){
                    pq.add(new Computer(i, i+k));
                }
                
            }
        }
        
        return answer;
    }
    class Computer implements Comparable<Computer>{
        int start, end;
        public Computer(int start, int end){
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Computer o){
            return this.start - o.start;
        }
    }
}