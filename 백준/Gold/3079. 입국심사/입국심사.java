import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int n, m;
    static int[] arr;
    static long start;
    static long end ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        long max=-1;
        for (int i = 0; i <n ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(arr[i], max);
        }
        start=0;
        end=max*m;
        long result=Long.MAX_VALUE;
        while (start <= end) {
            long mid = (start+end)/2;
            long sum=0;
            for (int i = 0; i < n; i++) {
                long count = mid / arr[i];

                if (sum >= m) {
                    break;
                }
                sum+=count;
            }

            if (sum >= m) {
                end = mid-1;
                result = Math.min(result, mid);
            }else{
                start = mid+1;
            }
        }

        System.out.println(result);
    }
}