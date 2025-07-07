import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        
        List<Pair> list=new ArrayList<>();
        
        for(String file : files){
            boolean sign = false;
            String head = "";
            String number="";
            for(int i=0; i<file.length(); i++){
                if('0'<=file.charAt(i) && file.charAt(i)<='9'){
                    sign=true;
                    number+=file.charAt(i);
                }else{
                    if(sign){
                        break;    
                    }
                    head+=file.charAt(i);
                }
            }
            list.add(new Pair(head.toLowerCase(), Integer.parseInt(number), file));
        }
        Collections.sort(list);
        String[] answer = new String[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i).origin;
        }
        return answer;
    }
    
    public class Pair implements Comparable<Pair> {
        String head;
        int number;
        String origin;
        public Pair(String head, int number, String origin){
            this.head = head;
            this.number=number;
            this.origin = origin;
        }
        
        @Override
        public int compareTo(Pair o){
            if(this.head.equals(o.head)){
                return this.number - o.number;   
            }
            return this.head.compareTo(o.head);
        }
    }
}