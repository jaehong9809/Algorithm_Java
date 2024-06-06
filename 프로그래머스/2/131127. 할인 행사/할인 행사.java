import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        for(int i=0; i<discount.length-10+1; i++){
            Map<String, Integer> map = new HashMap<>();
            
            for(int j=0; j<number.length; j++){
                map.put(want[j], number[j]);
            }
            
            for(int j=i; j<i+10; j++){
                if(!map.containsKey(discount[j]))continue;
                map.put(discount[j], map.get(discount[j])-1);
            }
            boolean sign = true;
            for(Integer num : map.values()){
                if(num>0){
                    sign =false;
                }
            }
            
            if(sign){
                answer++;
            }
            
        }
        
        
        
        
        
        return answer;
    }
}