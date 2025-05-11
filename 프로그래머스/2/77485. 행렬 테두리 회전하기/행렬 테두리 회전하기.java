import java.util.*;
class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] map = new int[rows+1][columns+1];
        int val =1;
        for(int i=1; i<= rows; i++){
            for(int j=1; j<=columns; j++){
                map[i][j] = val++;
            }
        }
        int index =0;
        
        for(int[] query: queries){
            int x1 = query[0];
            int y1 = query[1];
            int x2 = query[2];
            int y2 = query[3];
            int firstNum = map[x1][y2];
            int min = firstNum;

            for(int i=y2-1; i>=y1; i--){
                min = Math.min(min, map[x1][i]);
                map[x1][i+1] = map[x1][i];
            }

            for(int i=x1+1; i<=x2; i++){
                min = Math.min(min, map[i][y1]);
                map[i-1][y1] = map[i][y1];
            }

            for(int i=y1+1; i<=y2; i++){
                min = Math.min(min, map[x2][i]);
                map[x2][i-1] = map[x2][i];
            }

            for(int i=x2-1; i>=x1; i--){
                min = Math.min(min, map[i][y2]);
                map[i+1][y2] = map[i][y2];
            }

            map[x1+1][y2] = firstNum;
            answer[index] = min;
            index++;
        }
        
        
        
        return answer;
    }
}