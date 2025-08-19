import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] data = new int[n];

        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
        }

        Arrays.sort(data);
        int left = 0;
        int right = n - 1;

        int result = 0;

        while (left < right) {
            int sum = data[left] + data[right];
            if (sum == m) {
                left++;
                right--;
                result++;
            } else if (sum < m) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(result);
    }
}