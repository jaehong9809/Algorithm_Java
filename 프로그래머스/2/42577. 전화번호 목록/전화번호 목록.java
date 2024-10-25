import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        int n = phone_book.length;
        Arrays.sort(phone_book);
        
        for(int i=1; i<n; i++){
            if(phone_book[i].startsWith(phone_book[i-1])){
                return false;
            }
        }
        
        return answer;
    }
}