import java.util.*;
class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int height = (n + w - 1) / w;
        int[][] arr = new int[w][height];
        
        for (int i = 0; i < n; i++) {
            int col = i / w; 
            int row = (col % 2 == 0) ? i % w : w - 1 - i % w;

            arr[row][col] = i + 1;
        }
      
        int col = 0;
        int row = 0;
        for(int i=0; i<height; i++){
            for(int j=0; j<w; j++){
                if(arr[j][i] == num){
                    col = i;
                    row = j;
                }
            }
        }
        
        for (int i = col; i < height; i++) {
            if (arr[row][i] != 0) {
                answer++;
            } else {
                break;
            }
        }
        
        
        return answer;
    }
}