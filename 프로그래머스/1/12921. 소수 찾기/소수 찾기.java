class Solution {
    public int solution(int n) {
        
        int answer =0;
        for(int i = 2; i<=n; i++){
            boolean sign = true;
            for(int j=2; j<=Math.sqrt(i); j++){
                if(i % j ==0){
                    sign = false;
                    break;
                }
            }
            if(sign) answer++;
            
        }
        
        return answer;
    }
}