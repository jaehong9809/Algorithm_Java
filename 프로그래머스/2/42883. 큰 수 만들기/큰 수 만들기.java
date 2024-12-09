import java.util.*;
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        int index = 0;
        StringBuilder  sb=new StringBuilder();
        
        for(int i=0; i<number.length()-k; i++){
            int max = 0;
            for(int j=index; j<=k+i; j++){
                if(max < number.charAt(j)-'0'){
                    max = number.charAt(j) - '0';
                    index = j+1;
                }
            }
            sb.append(max);
        }
        
        return sb.toString();
    }
}