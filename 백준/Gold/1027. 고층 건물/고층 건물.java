import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n =sc.nextInt();

        int[] data = new int[n];


        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
        }
        int max = -1;
        for (int i = 0; i < n; i++) {
            int cnt =0;
            double tmp=0;
            for (int j = i-1; j >=0 ; j--) {
                double s = (double) (data[i] - data[j])/(i-j);

                if (j == i - 1 || tmp > s) {
                    cnt++;
                    tmp = s;
                }
            }
            tmp=0;
            for (int j = i+1; j <n ; j++) {
                double s =(double) (data[i] - data[j])/(i-j);

                if (j == i +1 || tmp < s) {
                    cnt++;
                    tmp = s;
                }
            }
            if (max < cnt) {
                max = cnt;
            }
        }
        System.out.println(max);
    }
}