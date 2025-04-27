import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        long[] count = new long[m]; // 나머지별 등장 횟수
        st = new StringTokenizer(br.readLine());
        
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            sum += num;
            int mod = (int)(sum % m);
            count[mod]++;
        }

        long answer = count[0]; // 누적합 % m == 0인 경우는 바로 정답에 포함

        for (int i = 0; i < m; i++) {
            if (count[i] >= 2) {
                // 같은 나머지 중 2개를 고르는 경우의 수 = nC2 = n*(n-1)/2
                answer += count[i] * (count[i] - 1) / 2;
            }
        }
        
        System.out.println(answer);
    }
}
