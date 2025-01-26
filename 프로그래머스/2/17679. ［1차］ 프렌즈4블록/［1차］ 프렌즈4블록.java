class Solution {
    static int M, N;
    static char[][] map;
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        M = m;
        N = n;
        map = new char[M][N];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                map[i][j] = board[i].charAt(j);
            }
        }
        while(true){
            if(!check()){
                break;
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == ' ') answer++;
            }
        }
        
        
        return answer;
    }
    
    static boolean check(){
        boolean[][] visited = new boolean[M][N];
        boolean sign = false;
        for(int i=0; i<M-1; i++){
            for(int j=0; j<N-1; j++){
                char c = map[i][j];
                if(c ==' ') continue;
                if(c == map[i+1][j] && c == map[i][j+1] && c== map[i+1][j+1]){
                    visited[i][j] = true;
                    visited[i+1][j] = true;
                    visited[i][j+1] = true;
                    visited[i+1][j+1] = true;
                    sign = true;
                }
            }
        }
        if(!sign) return false;
        
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(visited[i][j]){
                    map[i][j] = ' ';
                }
            }
        }        
        
        for(int i=0; i<N; i++){
            String str = "";
            for(int j=M-1; j>=0; j--){
                str+=map[j][i];
            }
            str = str.replaceAll(" ", "");
            
            for(int j=0; j<str.length(); j++){
                map[M-j-1][i] = str.charAt(j);
            }
            for(int j = M-str.length()-1; j>=0; j--){
                map[j][i] = ' ';
            }
        }
        return sign;
    }
}