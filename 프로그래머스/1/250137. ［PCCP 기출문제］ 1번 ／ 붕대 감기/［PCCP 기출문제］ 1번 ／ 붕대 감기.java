class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        int index = 0;
        int cnt = 0;
        int n = attacks.length;
        
        for(int i=1; i<=attacks[n-1][0]; i++){
            if (i != attacks[index][0]){
                answer += bandage[1];
                cnt++;
                if (cnt == bandage[0]){
                    answer += bandage[2];
                    cnt = 0;
                }
                if (answer > health) answer = health;
            } else {
                cnt = 0;
                answer -= attacks[index][1];
                index++;
                if (answer <= 0) return -1;
            }
        }
        
        
        
        return answer;
    }
}