import java.util.Arrays;
import java.util.Scanner;

class Main {
    static int n;
    static int[] data;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        data=new int[n];

        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
        }

        Arrays.sort(data);
        int start=0;
        int end = n-1;
        int min = Integer.MAX_VALUE;
        int left =0 ;
        int right = n-1;
        while (start<end){
            int val = data[start]+data[end];
            if(min > Math.abs(val)){
                min = Math.abs(val);
                left = start;
                right = end;
            }
            if (Math.abs(start - end)==1) {
                break;
            }
            if(val > 0){
                end--;
            }else{
                start++;
            }
        }
        System.out.println(data[left]+" "+data[right]);
    }
}