import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        
        int n = str.length();
        str += str;
        int aCnt = 0;
        
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'a') aCnt++;
        }
        
        int min = 1001;
        
        for (int i = 0; i < n; i++) {
            int bCnt = 0;
            
            for (int j = i; j < i + aCnt; j++) {
                if (str.charAt(j) == 'b') bCnt++;
            }
            min = Math.min(min, bCnt);
        }
        
        System.out.println(min);
    }

}