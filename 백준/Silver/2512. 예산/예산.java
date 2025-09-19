import java.util.Arrays;
import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] data=new int[n];

        for (int i = 0; i < n; i++) data[i] = sc.nextInt();

        Arrays.sort(data);

        int m = sc.nextInt();

        int res = bs(m, n, data);
        System.out.println(res);
    }
    static int bs(int m, int n, int[] data){
        int left = 1;
        int right = data[n-1];
        int res=0;
        while (left<=right){
            int mid = (left+ right)/2;
            int total = 0;
            int index = 0;
            for (int i = 0; i < n; i++) {
                if (mid > data[i]){
                    total += data[i];
                }else {
                    total+=mid;
                }
            }
            if(total<=m){
                res = mid;
                left=mid+1;
            }else{
                right = mid-1;
            }
        }
        return res;
    }
}