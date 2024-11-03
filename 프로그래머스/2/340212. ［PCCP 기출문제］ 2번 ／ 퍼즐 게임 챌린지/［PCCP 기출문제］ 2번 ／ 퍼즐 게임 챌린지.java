import java.util.*;
class Solution {
    static ArrayList<Node> list = new ArrayList<>();
    static long l ;
    static int n;
    public int solution(int[] diffs, int[] times, long limit) {
        
        n = diffs.length;
        l = limit;
        
        for(int i=0; i<n; i++){
            list.add(new Node(diffs[i], times[i]));
        }
        
        int answer = bsc();
         if (answer == 0) {
            answer = 1;
        }
        return answer;
    }
    public int bsc(){
        int start =1;
        int end = 100000;
        int result =0;
        while(start<=end){
            int mid = (start+end)/2;
            boolean b = cal(mid);
            
            if(b){
                end = mid-1;
            }else{
                start=mid+1;
            }
            
        }
        return start;
    }
    
    public boolean cal(long level){
        
        long time =0;
        for(int i=0; i<n; i++){
            Node node = list.get(i);
            if(node.diff <=level){
                time +=node.time;
            }else{
                if(i==0){
                    time+=(node.diff - level) * (node.time )+node.time;
                }else{
                    time +=(node.diff - level) * (node.time + list.get(i-1).time)+node.time;     
                }
                
            }
            
            if(time>l){
                return false;
            }
        }        
        
        return true;
    }
    
    
    class Node  {
        int diff;
        int time;
        public Node(int diff, int time){
            this.diff = diff;
            this.time = time;
        }
       
    }
    
    
}