import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] data=new int[n+1];
        st =  new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;

        for (int i = 0; i < x; i++) {
            sum+=data[i];
        }
        int max = sum;
        int cnt=1;
        for (int i = x; i < n; i++) {
            sum-=data[i-x];
            sum += data[i];

            if (max < sum) {
                max = sum;
                cnt=1;
            } else if (max == sum) {
                cnt++;
            }
        }
        if(max==0){
            System.out.println("SAD");
            return;
        }
        System.out.println(max);
        System.out.println(cnt);
    }
}