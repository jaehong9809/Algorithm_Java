import java.util.Scanner;

class Main{
    static int n, m;
    static int[] arr;
    static int max=-1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if (max < arr[i]) {
                max=arr[i];
            }
        }
        m=sc.nextInt();

        System.out.println(binarySearch());
    }

    public static int binarySearch(){
        int left = 0;
        int right = max;
        while (left <= right) {
            int mid = (left+right)/2;
            int total =0;
            for (int i = 0; i < n; i++) {
                if (mid < arr[i]) {
                    total+=mid;
                }else{
                    total+=arr[i];
                }
            }

            if(total>m){
                right = mid-1;
            }else{
                left = mid+1;

            }
        }
        return right;
    }
}