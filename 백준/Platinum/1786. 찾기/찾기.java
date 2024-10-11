import java.util.ArrayList;
import java.util.Scanner;

class Main{
    static ArrayList<Integer> res = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String pattern = sc.nextLine();
        kmp(text, pattern);

        System.out.println(res.size());
        for (Integer re : res) {
            System.out.print(re+" ");
        }
    }

    public static int[] computeArray(String pattern){
        int m = pattern.length();
        int[] lps = new int[m];
        int len = 0;
        int i=1;

        lps[0] = 0;

        while (i<m){
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }else {
                if(len!= 0 ){
                    len = lps[len-1];
                }else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public static void kmp(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int[] lps = computeArray(pattern);

        int i=0;
        int j=0;
        while (i<n){
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }

            if(j==m){
                res.add(i - j+1);
                j= lps[j-1];
            } else if (i < n && pattern.charAt(j) != text.charAt(i)) {
                if(j!=0){
                    j = lps[j-1];
                }else{
                    i++;
                }
            }
        }
    }
}