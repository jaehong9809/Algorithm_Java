import java.util.Arrays;
import java.util.Scanner;


class Solution
{
    static boolean[] visited=new boolean[9];
    static int[] arr = new int[9];
    static int win;
    static int lose;
    static int[] A;
    static int[] B;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            win=0;
            lose=0;
            boolean[] numbers = new boolean[19];
            A = new int[9];
            B = new int[9];

            for (int i = 0; i < 9; i++) {
                A[i] = sc.nextInt();
                numbers[A[i]]=true;
            }
            int index=0;
            for (int i = 1; i <=18 ; i++) {
                if (!numbers[i]) {
                    B[index++]=i;
                }
            }

            permutation(0);
            System.out.println("#"+test_case+" "+win+" "+lose);
        }
    }

    static void permutation(int depth){
        if(depth==9){
            int aScore=0;
            int bScore=0;

            for (int i = 0; i < 9; i++) {
                if(A[i]>B[arr[i]]){
                    aScore+=A[i]+B[arr[i]];
                }else{
                    bScore+=A[i]+B[arr[i]];
                }
            }
            if(aScore>bScore){
                win++;
            }
            if(aScore<bScore){
                lose++;
            }
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (!visited[i]) {
                visited[i]=true;
                arr[depth]=i;
                permutation(depth+1);
                visited[i]=false;
            }
        }

    }

}