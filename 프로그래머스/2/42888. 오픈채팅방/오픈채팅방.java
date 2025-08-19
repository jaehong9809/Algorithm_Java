import java.util.*;
class Solution {
    public String[] solution(String[] record) {

        Map<String, String> map=new HashMap<>();
        
        for(String str : record) {
        	String[] words = str.split(" ");
        	if(words[0].equals("Enter")) {
        		map.put(words[1],words[2]);
        	}
        	if(words[0].equals("Change")) {
        		map.put(words[1], words[2]);
        	}
        }
        ArrayList<String> results=new ArrayList<>();
        for(String str:record) {
        	String[] words = str.split(" ");
        	if(words[0].equals("Enter")) {
        		results.add(map.get(words[1])+"님이 들어왔습니다.");
        	}
        	if(words[0].equals("Leave")) {
        		results.add(map.get(words[1])+"님이 나갔습니다.");
        	}
        }
        
        String[] answer = results.toArray(new String[0]);        
        
        return answer;
    }
}