import java.util.Arrays;
import java.util.Scanner;

class Main{
    static int n, m;
    static int[] data;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();

        data=new int[n];

        for (int i = 0; i < n; i++) {
            data[i]=sc.nextInt();
        }
        Arrays.sort(data);

        for (int i = 0; i < m; i++) {
            int q = sc.nextInt();
            if(binarySearch(q)!=-1){
                System.out.println(lowerBound(q));
            }else{
                System.out.println(-1);
            }
        }
    }
    static int binarySearch(int q){
        int start=0;
        int end=n-1;
        while (start<=end){
            int mid = (start+end)/2;
            if(data[mid] ==q){
                return mid;
            } else if (data[mid]>q) {
                end=mid-1;
            }else {
                start=mid+1;
            }

        }
        return -1;
    }
    static int lowerBound(int q){
        int start=0;
        int end = n;

        while (start<end){
            int mid = (start+end)/2;
            if(data[mid]<q){
                start=mid+1;
            }else{
                end=mid;
            }
        }

        return end;
    }



}