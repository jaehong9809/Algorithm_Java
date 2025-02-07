import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        String[] strs = br.readLine().split(" ");
        int[] data = new int[n];
        long[] sum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(strs[i]);
        }

        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + data[i - 1];
        }
        int min = Integer.MAX_VALUE;

        int start = 0;
        int end = 1;
        while (start <= end) {
            if (end > n) break;
            long val = sum[end] - sum[start];
            if (val < s) {
                end++;
            } else {
                min = Math.min(min, end - start);
                start++;
            }
        }
        System.out.println(min==Integer.MAX_VALUE?0 : min);
    }
}