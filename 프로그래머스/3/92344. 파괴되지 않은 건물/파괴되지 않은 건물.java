class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        
        int[][] presum = new int[n+1][m+1];
        
        for(int[] arr : skill){
            int type = arr[0];
            int r1 = arr[1];
            int c1 = arr[2];
            int r2 = arr[3];
            int c2 = arr[4];
            int degree = arr[5] * (type == 1 ? -1 : 1);

            presum[r1][c1] += degree;
            presum[r1][c2 + 1] -= degree;
            presum[r2 + 1][c1] -= degree;
            presum[r2 + 1][c2 + 1] += degree;
        }
        
        for (int i = 0; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                presum[i][j] += presum[i][j - 1];
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                presum[i][j] += presum[i - 1][j];
            }
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j]+presum[i][j]>0) answer++;
            }
        }
        return answer;
    }
}