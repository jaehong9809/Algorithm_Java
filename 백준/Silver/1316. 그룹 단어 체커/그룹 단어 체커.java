import java.util.*;
class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n=sc.nextInt();
        sc.nextLine();
        int cnt=0;
        for(int i=0; i<n; i++){
            String str=sc.nextLine();
            Set<Character> set=new HashSet<>();
            char ch='0';
            boolean sign=true;
            for(int j=0; j<str.length(); j++){
                if(ch!=str.charAt(j)){
                    if(set.contains(str.charAt(j))){
                        sign=false;
                        break;
                    }
                    else{
                        ch=str.charAt(j);
                        set.add(ch);
                    }
                }
            }
            if(sign) cnt++;
        }
        System.out.println(cnt);

    }
}