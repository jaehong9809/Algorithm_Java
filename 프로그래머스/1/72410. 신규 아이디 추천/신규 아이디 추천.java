import java.util.*;
class Solution {
    public String solution(String new_id) {
        new_id = new_id.toLowerCase();
        String answer  = "";
        
        for(int i=0; i<new_id.length(); i++){
            if((int)'a' <= new_id.charAt(i) && new_id.charAt(i)<=(int)'z'){
                answer+=new_id.charAt(i);
                continue;
            }
            if((0<= new_id.charAt(i) - '0') && (new_id.charAt(i) - '0'<=9) ){
                answer+=new_id.charAt(i);
                continue;
            }
            if(new_id.charAt(i)=='-' || new_id.charAt(i)=='.'||new_id.charAt(i)=='_'){
                answer+=new_id.charAt(i);
                continue;
            }
        }
        Stack<Character> st = new Stack<>();
        for(int i=0; i<answer.length(); i++){
            if(!st.isEmpty()&& st.peek().equals('.') &&answer.charAt(i)=='.'){
                continue;
            }
            st.push(answer.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) sb.append(st.pop());
        sb = sb.reverse();
        if(sb.length()>0 &&sb.charAt(0)=='.') sb.deleteCharAt(0);
        if(sb.length()>0 &&sb.charAt(sb.length()-1)=='.') sb.deleteCharAt(sb.length()-1);
        
        if(sb.length()==0)sb.append("a");
        
        if(sb.length()>=16){
            sb = new StringBuilder(sb.substring(0, 15));
        }
        if(sb.length()>0 &&sb.charAt(sb.length()-1)=='.') sb.deleteCharAt(sb.length()-1);
        if(sb.length()==1){
            sb.append(sb.charAt(0));
            sb.append(sb.charAt(0));
        }
        
        if(sb.length()==2){
            sb.append(sb.charAt(1));
        }
        return sb.toString();
    }
}