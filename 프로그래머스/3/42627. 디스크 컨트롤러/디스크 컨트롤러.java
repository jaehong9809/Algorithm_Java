import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int n = jobs.length;
        
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        PriorityQueue<Job> pq =new PriorityQueue<>();
        
        int stime=-1;
        int etime=-1;
        int time=0;
        int cnt=0;
        int index =0;
        boolean nowworking = false;
        while(cnt !=n){
            
            while (index<n && jobs[index][0]==time) {
                pq.offer(new Job(jobs[index][0], jobs[index][1]));
                index++;
                   
            }
            
            
            if(!nowworking && !pq.isEmpty()){
                nowworking = true;
                Job job = pq.poll();
                stime = job.t;
                etime = time + job.c;
            }
            
            if(nowworking && etime ==time){
                answer +=(etime - stime);
                cnt++;
                nowworking=false;
                continue;
            }
          
            time++;
        }
        answer/=n;
        return answer;
    }
    
    class Job implements Comparable<Job>{
        int t;
        int c;
        public Job(int t, int c){
            this.t = t;
            this.c = c;
        }
        @Override
        public int compareTo(Job o){
            return this.c - o.c;
        }
    }
}