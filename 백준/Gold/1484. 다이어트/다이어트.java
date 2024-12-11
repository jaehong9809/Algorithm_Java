import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int start = 1;
        int end = 2;
        boolean sign = false;
        while (end <= 100000*1000) {
            if((end+start) * (end - start) == n){
                System.out.println(end);
                start++;
                end++;
                sign = true;
            }
            else if((end+start) * (end - start) > n){
                start++;
            }else{
                end++;
            }
        }
        if(!sign){
            System.out.println(-1);
        }
    }
}