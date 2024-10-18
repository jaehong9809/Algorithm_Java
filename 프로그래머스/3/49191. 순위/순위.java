import java.util.*;
class Solution {
    static int INF = (int)1e9;
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] matrix=new int[n+1][n+1];
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n;j++){
                if(i==j) continue;
                matrix[i][j] = INF;
            }
        }
        
        for(int[] result : results){
            matrix[result[0]][result[1]]=1;
        }

        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k]+matrix[k][j]);
                }
            }
        }
        // for(int i=1; i<=n; i++){
        //     for(int j=1; j<=n; j++){
        //         if(matrix[i][j]!=INF){
        //                             System.out.print(matrix[i][j]+" ");
        //         }else{
        //                             System.out.print("M ");
        //         }
        //     }
        //     System.out.println();
        // }
        
        for(int i=1; i<=n; i++){
            int sum=0;
            for(int j=1; j<=n; j++){
                if(matrix[i][j]!=INF && matrix[i][j]!=0 ){
                    sum++;
                }
                if(matrix[j][i]!=INF && matrix[j][i]!=0){
                    sum++;
                }
            }
            if(sum==n-1) answer++;
        }
        
        return answer;
    }
    
}