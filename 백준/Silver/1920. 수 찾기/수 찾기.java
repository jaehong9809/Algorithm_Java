import java.util.Arrays;
import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] data=new int[n];
        for (int i = 0; i < n; i++) {
            data[i]=sc.nextInt();
        }
        Arrays.sort(data);

        int m=sc.nextInt();

        for (int i = 0; i < m; i++) {
            int target=sc.nextInt();
            if(binarySearch(data, target)>=0) System.out.println(1);
            else System.out.println(0);
        }

    }
    static int binarySearch(int[] data, int target){
        int start=0;
        int end=data.length-1;

        while (start<=end){
            int mid=(start+end)/2;

            if(data[mid]==target)return mid;
            else if(data[mid]<target) start=mid+1;
            else end=mid-1;


        }
        return -1;
    }

}