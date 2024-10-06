import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while ((str = br.readLine()) != null) {
            long x = Long.parseLong(str) * (10000000);

            int n = Integer.parseInt(br.readLine());
            long[] data = new long[n];

            for (int i = 0; i < n; i++) {
                data[i] = Long.parseLong(br.readLine());
            }

            Arrays.sort(data);
            int start = 0;
            int end = n - 1;
            boolean sign = false;
            while (start < end) {
                long sum = data[start] + data[end];
                if (sum == x) {
                    sign = true;
                    break;
                }
                if (sum > x) {
                    end--;
                } else {
                    start++;
                }
            }
            if (sign) System.out.println("yes " + data[start] + " " + data[end]);
            else System.out.println("danger");
            str = null;
        }

    }
}