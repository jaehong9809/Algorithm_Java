import java.util.*;
class Solution {
    static int n;
    public boolean solution(String[] phone_book) {
        n = phone_book.length;
        
        Arrays.sort(phone_book, (a, b) -> a.length()- b.length());
        Set<String> set = new HashSet<>();
        
        for(String number : phone_book){
            
            for(int i=1; i<number.length(); i++){
                String subs = number.substring(0, i);
                if(set.contains(subs)){
                    return false;
                }
            }
            set.add(number);
        }
        
        return true;
    }
}