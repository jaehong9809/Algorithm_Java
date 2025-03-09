import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    static int n;
    static String str;
    static int[] alp = new int[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        str = br.readLine();

        int cnt = 0;
        int start =0;
        int end =0;

        int max = -1;

        while (end < str.length()){
            if(alp[str.charAt(end)-'a']==0){
                cnt++;
            }

            alp[str.charAt(end)-'a']++;

            while (n < cnt){
                alp[str.charAt(start)-'a']--;

                if(alp[str.charAt(start)-'a']==0){
                    cnt--;
                }
                start++;
            }
            max = Math.max(max, end-start+1);
            end++;
        }
        System.out.println(max);
    }
}