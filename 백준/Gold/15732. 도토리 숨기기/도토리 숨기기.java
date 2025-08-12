import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int n, k;
    static long d;
    static int[] boxes = new int[1000001];
    static long[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());
        k = Integer.parseInt(stringTokenizer.nextToken());
        d = Long.parseLong(stringTokenizer.nextToken());

        arr = new long[k][3];

        for (int i = 0; i < k; i++) {
            String[] s = br.readLine().split(" ");
            long start = Long.parseLong(s[0]);
            long end = Long.parseLong(s[1]);
            long gap = Long.parseLong(s[2]);
            arr[i][0] = start;
            arr[i][1] = end;
            arr[i][2] = gap;
        }
        System.out.println(bfs());

    }

    static long bfs() {
        long start = 1;
        long end = 1000000000;
        while (start < end) {
            long mid = (start + end) / 2;
            long total = 0;

            for (int i = 0; i < k; i++) {
                long a = arr[i][0];
                long b = arr[i][1];
                long c = arr[i][2];
                if (mid<a) continue;
                long x = Math.min(mid, b);
                total+=(x-a)/c+1;
                if(total>=d) break;;
            }

            if(total>=d)end=mid;
            else start = mid+1;
        }
        return start;
    }
}