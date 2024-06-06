import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        int length = s.length();
        for(int i=0; i<length; i++){
            s= s.substring(1)+ s.charAt(0);
            
            if(checkPossible(s)) answer++;
        }
        
        
        return answer;
    }
    
    public boolean checkPossible(String str){
        Stack<Character> st=new Stack<>();
        
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(c =='[' || c =='(' || c =='{'){
                st.push(c);
            }else{
                if(st.isEmpty()) return false;
                
                if(c ==']'){
                    if(st.peek() == '['){
                        st.pop();
                    }else return false;
                }
                
                if(c =='}'){
                    if(st.peek() == '{'){
                        st.pop();
                    }else return false;
                }
                if(c==')'){
                    if(st.peek() == '('){
                        st.pop();
                    }else return false;
                    
                }
                
                
            }
            
        }
        if(!st.isEmpty()) return false;
        
        return true;
    }
    
    
}