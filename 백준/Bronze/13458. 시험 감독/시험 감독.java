import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];

        for (int i = 0; i < n; i++) {
            arr[i]= sc.nextInt();
        }

        int b=sc.nextInt();
        int c=sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i]-=b;
            if(arr[i]<0){
                arr[i]=0;
            }
        }
        long answer=n;
        for (int i = 0; i < n; i++) {
            int tmp = arr[i]/c;

            if(tmp==0){
                if(arr[i]%c!=0){
                    answer++;
                }
            }
            else{
                answer+=tmp;
                if(arr[i]%c!=0){
                    answer++;
                }
            }

        }
        System.out.println(answer);
    }
}