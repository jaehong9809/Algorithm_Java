import java.util.*;
class Solution {
    static long min=(long)1e15;
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        binarySearch(n, times);
                
        answer=min;
        return answer;
    }
    public static void binarySearch(int n, int[] times){
        long start=times[0];
        long end=(long)(times[times.length-1]*(long)n);
        
        while(start<=end){
            long mid=(start+end)/2;
            long sum=0;
            for(int i=0; i<times.length; i++){
                sum+=mid/times[i];
            }
            if(sum>=n){
                
                min=Math.min(mid, min);
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        
    }
}