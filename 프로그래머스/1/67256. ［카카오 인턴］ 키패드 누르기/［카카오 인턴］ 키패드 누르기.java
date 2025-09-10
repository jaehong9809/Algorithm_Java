import java.util.*;
class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb =new StringBuilder();
        Hand left = new Hand(1, 4);
        Hand right = new Hand(3, 4);
        
        for(int number :  numbers){
            if(number ==1){
                left.x = 1;
                left.y = 1;
                sb.append("L");
            }else if(number==4){
                left.x = 1;
                left.y = 2;
                sb.append("L");
            }else if(number==7){
                left.x = 1;
                left.y = 3;
                sb.append("L");
            }else if(number==3){
                right.x = 3;
                right.y = 1;
                sb.append("R");
            }else if(number==6){
                right.x = 3;
                right.y = 2;
                sb.append("R");
            }else if(number==9){
                right.x = 3;
                right.y = 3;
                sb.append("R");
            }else if(number==2){
                int leftDist = Math.abs(2 - left.x) +Math.abs(1 - left.y) ;
                int rightDist = Math.abs(2 - right.x) +Math.abs(1 - right.y);
                if(leftDist == rightDist){
                    if(hand.equals("right")){
                        sb.append("R");
                        right.x = 2;
                        right.y = 1;
                        
                    }else{
                        sb.append("L");
                        left.x = 2;
                        left.y = 1;
                    }
                }else if(leftDist < rightDist){
                    sb.append("L");
                    left.x = 2;
                    left.y = 1;
                }else{
                    sb.append("R");
                    right.x = 2;
                    right.y = 1;
                }
            }else if(number==5){
                int leftDist = Math.abs(2 - left.x) +Math.abs(2 - left.y) ;
                int rightDist = Math.abs(2 - right.x) +Math.abs(2 - right.y);
                if(leftDist == rightDist){
                    if(hand.equals("right")){
                        sb.append("R");
                        right.x = 2;
                        right.y = 2;
                    }else{
                        sb.append("L");
                        left.x = 2;
                        left.y = 2;
                    }
                }else if(leftDist < rightDist){
                    sb.append("L");
                    left.x = 2;
                    left.y = 2;
                }else{
                    sb.append("R");
                    right.x = 2;
                    right.y = 2;
                }
            }else if(number==8){
                int leftDist = Math.abs(2 - left.x) +Math.abs(3 - left.y) ;
                int rightDist = Math.abs(2 - right.x) +Math.abs(3 - right.y);
                if(leftDist == rightDist){
                    if(hand.equals("right")){
                        sb.append("R");
                        right.x = 2;
                        right.y = 3;
                    }else{
                        sb.append("L");
                        left.x = 2;
                        left.y = 3;
                    }
                }else if(leftDist < rightDist){
                    sb.append("L");
                    left.x = 2;
                    left.y = 3;
                }else{
                    sb.append("R");
                    right.x = 2;
                    right.y = 3;
                }
            }else if(number==0){
                int leftDist = Math.abs(2 - left.x) +Math.abs(4 - left.y) ;
                int rightDist = Math.abs(2 - right.x) +Math.abs(4 - right.y);
                if(leftDist == rightDist){
                    if(hand.equals("right")){
                        sb.append("R");
                        right.x = 2;
                        right.y = 4;
                    }else{
                        sb.append("L");
                        left.x = 2;
                        left.y = 4;
                    }
                }else if(leftDist < rightDist){
                    sb.append("L");
                    left.x = 2;
                    left.y = 4;
                }else{
                    sb.append("R");
                    right.x = 2;
                    right.y = 4;
                }
            }
            
            
        }
        
        return sb.toString();
    }
    class Hand{
        int x,y;
        public Hand(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}