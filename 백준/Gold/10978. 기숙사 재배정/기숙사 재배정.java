import java.util.Scanner;

class Main{
    public static long factorial(int n) {
        long result = 1L;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static long derangement(int n) {
        long result = 0L;
        long fact = factorial(n);
        for (int k = 0; k <= n; k++) {
            result += (k % 2 == 0 ? 1 : -1) * fact / factorial(k);
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] d = new long[21];

        for (int i = 1; i <=20 ; i++) {
            d[i] = derangement(i);
        }
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            System.out.println(d[n]);
        }
    }
}