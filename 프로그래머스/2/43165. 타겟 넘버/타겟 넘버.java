class Solution{
 
    static int len = 1;
    static int cnt=0;
    static int[] nums;
    static int tar;
    static public int solution(int[] numbers,int target){
        len = numbers.length;
        nums = numbers.clone();
        tar = target;
        dfs(0, 0);
        int answer=cnt;
        return answer;
    }

    static public void dfs(int depth, int result){
        if (depth == len) {
            if (tar == result) {
                cnt++;
            }
            return;
        }

        dfs(depth + 1, result + nums[depth]);

        dfs(depth + 1, result - nums[depth]);
    }
}