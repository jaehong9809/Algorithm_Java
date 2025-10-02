class Solution {
    public int solution(int[] money) {
        int n = money.length;
        
        int[] left = new int[n+1];
        int[] right = new int[n+1];
        
        left[0] = money[0];
        left[1] = Math.max(money[0], money[1]);
        
        for(int i=2; i<n-1; i++){
            left[i] = Math.max(left[i-1], left[i-2] + money[i]);
        }
        
        right[1] = money[1];
        right[2] = Math.max(money[1], money[2]);
        
        for(int i=3; i<n; i++){
            right[i] = Math.max(right[i-1], right[i-2]+money[i]);
        }
        
        int answer = Math.max(left[n-2], right[n-1]);
        return answer;
    }
}