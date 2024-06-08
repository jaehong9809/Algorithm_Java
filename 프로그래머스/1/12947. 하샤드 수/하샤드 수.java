class Solution {
    public boolean solution(int x) {
        String tmp = Integer.toString(x);
        int a = 0;
        for(int i=0; i<tmp.length(); i++){
            a+=tmp.charAt(i) - '0';
            
        }
        return (x%a ==0)? true: false;
    }
}