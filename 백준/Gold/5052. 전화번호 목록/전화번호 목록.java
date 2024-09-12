import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] data=new String[n];

            for (int i = 0; i < n; i++) {
                data[i] = br.readLine();
            }
            Arrays.sort(data);

            boolean sign = false;
            for (int i = 0; i < n-1; i++) {
                if (data[i + 1].startsWith(data[i])) {
                    sign=true;
                    break;
                }
            }
            if (sign) System.out.println("NO");
            else System.out.println("YES");
        }

    }
}