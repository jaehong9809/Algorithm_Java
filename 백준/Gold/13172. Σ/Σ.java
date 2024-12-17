import java.util.Scanner;

class Main {
    static int mod = 1_000_000_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        long sum =0;
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            long invA = modPow(a, mod - 2); 
            long result = (invA * b) % mod;
            sum+=result;
        }
        System.out.println(sum%mod);
    }

    static long modPow(long base, long exp) {
        long result = 1;
        while (exp > 0) {
            if (exp % 2 == 1) { 
                result = (result * base) % mod;
            }
            base = (base * base) % mod; 
            exp /= 2;
        }
        return result;
    }
}