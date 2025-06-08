import java.util.Arrays;
import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int c = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int left = 1;
        int right = arr[n-1] - arr[0];
        int result = 0;
        while (left <=right){
            int mid = (left+right)/2;

            if (check(arr, c, mid)) {
                result = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }

        }
        System.out.println(result);
    }

    static boolean check(int[] arr, int c, int mid){
        int cnt =1;
        int last = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if(arr[i] - last >=mid){
                cnt++;
                last = arr[i];
            }
        }
        return cnt>=c;
    }
}