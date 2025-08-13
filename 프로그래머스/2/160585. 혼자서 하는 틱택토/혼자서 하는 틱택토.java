class Solution {
    public int solution(String[] board) {
        int answer = -1;
        int oCnt = 0;
        int xCnt = 0;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(board[i].charAt(j) =='O'){
                    oCnt++;
                }
                else if(board[i].charAt(j)=='X'){
                    xCnt++;
                }
            }
        }
        if(!((oCnt==xCnt)||(oCnt==xCnt+1))) return 0;
        
        int oStickCnt = 0;
        int xStickCnt = 0;
        
        for(int i=0; i<3; i++){
            if(board[i].charAt(0) ==board[i].charAt(1) &&board[i].charAt(1) ==board[i].charAt(2)){
                if(board[i].charAt(0) =='O') oStickCnt++;
                else if(board[i].charAt(0)=='X') xStickCnt++;
            }
            
            if(board[0].charAt(i) == board[1].charAt(i) && board[1].charAt(i) == board[2].charAt(i)){
                if(board[0].charAt(i)=='O') oStickCnt++;
                else if(board[0].charAt(i)=='X') xStickCnt++;
            }
        }
        
        if(board[0].charAt(0) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(2)){
            if(board[0].charAt(0) =='O') oStickCnt++;
            else if(board[0].charAt(0)=='X') xStickCnt++;
        }
        
        if(board[0].charAt(2) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(0)){
            if(board[0].charAt(2) =='O') oStickCnt++;
            else if(board[0].charAt(2)=='X') xStickCnt++;
        }
        
        if(xStickCnt>0 && oStickCnt>0) return 0;
        
        if(oStickCnt>0){
            if(oCnt == xCnt+1){
                return 1;
            }else{
                return 0;
            }
        }
        
        if(xStickCnt>0){
            if(oCnt ==xCnt){
                return 1;
            }else{
                return 0;
            }
        }
        
        return 1;
    }
}