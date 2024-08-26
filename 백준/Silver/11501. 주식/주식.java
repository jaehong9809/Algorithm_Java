import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        for (int TESTCASE = 1; TESTCASE <= T; TESTCASE++) {
            int n = Integer.parseInt(br.readLine());
            int[] data = new int[n + 1];
            String[] str = br.readLine().split(" ");

            int max =0;

            for (int i = 0; i < n; i++) {
                data[i] = Integer.parseInt(str[i]);
            }
            int cnt=0;
            long sum=0;
            for (int i = 0; i < n; i++) {
                int now = data[i];
                boolean sign = false;

                for (int j = i+1; j <n ; j++) {
                    if(now<=data[j]){
                        sign=true;
                        break;
                    }
                }
                if(i == n-1){
                    sum+= (long) cnt *data[i];
                    break;
                }
                if (sign) {
                    sum-=data[i];
                    cnt++;
                }else{
                    sum+= (long) cnt *data[i];
                    cnt=0;
                }
            }
            sb.append(sum).append("\n");

        }
        System.out.println(sb.toString());

    }
}