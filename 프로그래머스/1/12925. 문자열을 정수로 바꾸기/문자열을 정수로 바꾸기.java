class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int c = s.charAt(0);
        
        if('0'<=c && c<='9'){
            answer = Integer.parseInt(s);
        }
        else{
            if(c =='+'){
                answer = Integer.parseInt(s.substring(1));
            }else{
                answer = Integer.parseInt(s.substring(1))*(-1);
            }
                        
        }
        
        return answer;
    }
}