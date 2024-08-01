import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];


        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j)-'0';
            }
        }
        if(n==1||m==1){
            boolean sign = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(map[i][j]==1){
                        sign=true;
                    }
                }
            }
            if(sign) System.out.println(1);
            else System.out.println(0);
            return;
        }
        int cnt=0;
        while (true){
            boolean sign = true;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(map[i][j]==1){
                        sign=false;
                    }
                }
            }
            function(map);


            if (sign)break;
            cnt++;
        }
        System.out.println(cnt*cnt);

    }
    static void function(int[][] map){
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < m-1; j++) {
                if (map[i][j] == 1 && map[i + 1][j]==1 && map[i][j + 1]==1 && map[i + 1][j + 1]==1) {
                    map[i][j] = 1;
                }else{
                    map[i][j]=0;
                }
            }
        }
        n--;
        m--;
    }


}