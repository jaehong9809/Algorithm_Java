class Solution {
    boolean solution(String s) {
        
        int cnt=0;
        for(int i=0; i< s.length(); i++){
            if(s.charAt(i)=='P' || s.charAt(i) =='p'){
                cnt++;
            }
            if(s.charAt(i)=='Y' || s.charAt(i) =='y'){
                cnt--;
            }
            
        }
        
        
        return (cnt==0)? true : false;
    }
}