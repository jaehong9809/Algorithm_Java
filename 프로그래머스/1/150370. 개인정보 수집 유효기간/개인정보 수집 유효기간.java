import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        ArrayList<Integer> results = new ArrayList<>();
        
        
        Map<Character, Integer> map = new HashMap<>();
        for(String term : terms){
            String[] s = term.split(" ");
            map.put(s[0].charAt(0), Integer.parseInt(s[1]));
        }
        
        
        for(int i=0; i<privacies.length; i++){
            String[] s = privacies[i].split(" ");
            String[] tmp = s[0].split("\\.");
            int year = Integer.parseInt(tmp[0]);
            int month = Integer.parseInt(tmp[1]);
            int day = Integer.parseInt(tmp[2]);
            
            
            
            
            month+=map.get(s[1].charAt(0));
            year += (month - 1) / 12;
            month = (month - 1) % 12 + 1;
            if(day ==1){
                day = 28;
                month--;
            }else{
                day--;
            }
            if(month==0){
                month=12;
                year--;
            }
            
            String modifiedDate = Integer.toString(year);
            if(month<10){
                modifiedDate += ".0"+month;
            }else{
                modifiedDate += "."+month;
            }
            
            if(day<10){
                modifiedDate += ".0"+day;
            }else{
                modifiedDate += "."+day;
            }
            
            if(modifiedDate.compareTo(today)<0) results.add(i+1);
            
        }
         int[] answer = new int[results.size()];
        
        for(int i=0; i<answer.length; i++){
            answer[i] = results.get(i);
        }
        
        return answer;
    }
    
}