import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] data= new int[n];
        String str = br.readLine();

        for (int i = 0; i < n; i++) {
            if(str.charAt(i)=='R'){
                data[i]=0;
            }else if(str.charAt(i)=='G'){
                data[i]= 1;
            }else{
                data[i]=2;
            }
        }
        int[] tmp = data.clone();

        int r=0, g=0, b=0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i <= n-3; i++) {
            if(tmp[i]!=0){
                for (int j = i; j <i+3 ; j++) {
                    tmp[j]++;
                    if(tmp[j]>=3)tmp[j]=0;
                }
                r++;
            }


            if(tmp[i]!=0){
                for (int j = i; j <i+3 ; j++) {
                    tmp[j]++;
                    if(tmp[j]>=3)tmp[j]=0;
                }
                r++;

            }
        }
        boolean sign = true;
        for (int i = 0; i < n; i++) {
            if(tmp[i]!=0){
                sign=false;
                break;
            }
        }
        if(sign) min =Math.min(min, r);
        tmp = data.clone();

        for (int i = 0; i <= n-3; i++) {
            if(tmp[i]!=1){
                for (int j = i; j <i+3 ; j++) {
                    tmp[j]++;
                    if(tmp[j]>=3)tmp[j]=0;

                }
                g++;
            }
            if(tmp[i]!=1){
                for (int j = i; j <i+3 ; j++) {
                    tmp[j]++;
                    if(tmp[j]>=3)tmp[j]=0;

                }
                g++;
            }
        }
        sign = true;
        for (int i = 0; i < n; i++) {
            if(tmp[i]!=1){
                sign=false;
                break;
            }
        }
        if(sign) min =Math.min(min, g);

        tmp = data.clone();
        for (int i = 0; i <= n-3; i++) {
            if(tmp[i]!=2){
                for (int j = i; j <i+3 ; j++) {
                    tmp[j]++;
                    if(tmp[j]>=3)tmp[j]=0;

                }
                b++;
            }
            if(tmp[i]!=2){
                for (int j = i; j <i+3 ; j++) {
                    tmp[j]++;
                    if(tmp[j]>=3)tmp[j]=0;

                }
                b++;
            }
        }
        sign = true;
        for (int i = 0; i < n; i++) {
            if(tmp[i]!=2){
                sign=false;
                break;
            }
        }

        if(sign) min =Math.min(min, b);

        if(min ==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);

    }
}