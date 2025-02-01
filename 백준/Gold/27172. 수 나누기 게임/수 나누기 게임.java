import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] data = new int[n];
        int[] result = new int[n];
        int maxVal = 0;

        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
            maxVal = Math.max(maxVal, data[i]);
        }

        boolean[] exists = new boolean[maxVal + 1];
        for (int num : data) {
            exists[num] = true;
        }

        int[] count = new int[maxVal + 1];

        for (int i = 1; i <= maxVal; i++) {
            if (!exists[i]) continue;
            for (int j = i * 2; j <= maxVal; j += i) {
                if (exists[j]) {
                    count[i]++;
                    count[j]--;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            result[i] = count[data[i]];
        }

        for (int i : result) {
            System.out.print(i+" ");
        }
    }
}