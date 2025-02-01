import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] data = new int[n];
        int maxVal = 0;

        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
            maxVal = Math.max(maxVal, data[i]);
        }

        int[] count = new int[maxVal + 1];
        for (int num : data) {
            count[num]++;
        }

        int[] result = new int[maxVal + 1];

        for (int i = 1; i <= maxVal; i++) {
            if (count[i] == 0) continue;

            for (int j = i * 2; j <= maxVal; j += i) {
                if (count[j] > 0) {
                    result[i] += count[j];
                    result[j] -= count[i];
                }
            }
        }

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = result[data[i]];
        }

        for (int i : answer) {
            System.out.print(i+" ");
        }
    }
}
