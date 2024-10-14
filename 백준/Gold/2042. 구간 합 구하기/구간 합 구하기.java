import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static long[] arr;
    static long[] tree;
    static int n;

    // 세그먼트 트리 초기화
    public static void init() {
        for (int i = 0; i < n; i++) {
            tree[n + i] = arr[i];
        }
        for (int i = n - 1; i > 0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }

    // 특정 값을 업데이트
    public static void update(int idx, long value) {
        idx += n; // 리프 노드의 위치로 이동
        tree[idx] = value; // 값 변경
        while (idx > 1) {
            idx /= 2;
            tree[idx] = tree[idx * 2] + tree[idx * 2 + 1]; // 상위 노드 갱신
        }
    }

    // 구간 합을 구함
    public static long sum(int left, int right) {
        left += n; // 리프 노드로 변환
        right += n;
        long result = 0;
        while (left <= right) {
            if (left % 2 == 1) result += tree[left++]; // 왼쪽이 홀수이면 결과에 더하고 다음으로 이동
            if (right % 2 == 0) result += tree[right--]; // 오른쪽이 짝수이면 결과에 더하고 이전으로 이동
            left /= 2;
            right /= 2;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new long[n];
        tree = new long[2 * n]; // 세그먼트 트리 크기는 2 * n

        // 배열 초기화
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        // 세그먼트 트리 초기화
        init();

        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                // b번째 수를 c로 바꾸는 작업
                update(b - 1, c);
            } else if (a == 2) {
                // b번째 수부터 c번째 수까지의 합을 구하는 작업
                System.out.println(sum(b - 1, (int) c - 1));
            }
        }
    }
}
