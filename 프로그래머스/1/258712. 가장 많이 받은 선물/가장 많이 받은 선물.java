import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String, Integer> map=new HashMap<>();
        Map<String, Integer> nextMonth = new HashMap<>();
        for(String friend: friends){
            map.put(friend, 0);
            nextMonth.put(friend, 0);
        }
        
        Map<String, Integer> com = new HashMap<>();
        
        for(String gift : gifts){
            String[] split = gift.split(" ");
            map.put(split[0], map.get(split[0])+1);
            map.put(split[1], map.get(split[1])-1);
            
            if(com.containsKey(gift)){
                com.put(gift, com.get(gift)+1);
            }else{
                com.put(gift, 1);
            }
        }
       
        
        for(int i=0; i<friends.length-1; i++){
            for(int j=i+1; j<friends.length; j++){
                if(i==j) continue;
                int a=0;
                int b=0;
                if(com.containsKey(friends[i]+" "+friends[j])){
                    a=com.get(friends[i]+" "+friends[j]);
                }
                
                if(com.containsKey(friends[j]+" "+friends[i])){
                    b= com.get(friends[j]+" "+friends[i]);
                }
                if(a>b){
                    nextMonth.put(friends[i], nextMonth.get(friends[i])+1);
                }else if(a<b){
                    nextMonth.put(friends[j], nextMonth.get(friends[j])+1);
                }else{
                    if(map.get(friends[i])>map.get(friends[j])){
                        nextMonth.put(friends[i], nextMonth.get(friends[i])+1);
                    }else if(map.get(friends[i])<map.get(friends[j])){
                        nextMonth.put(friends[j], nextMonth.get(friends[j])+1);
                    }
                }
            }
        }
        int answer = Collections.max(nextMonth.values());
        return answer;
    }
    
    
}