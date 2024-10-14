import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main{
    static int n, k;
    static LinkedList<Integer> link = new LinkedList<>();
    static int[] robots;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k= sc.nextInt();
        robots=new int[n];
        for (int i = 1; i <=2*n; i++) {
            link.add(sc.nextInt());
        }
        int time = 0;
        int cnt= 0;
        while (cnt<k){
//            System.out.println("==robot==");
//            for (int i = 0; i < n; i++) {
//                System.out.print(robots[i]+" ");
//            }
//            System.out.println();
//            System.out.println("==belt==");
//            for (int i = 0; i < n; i++) {
//                System.out.print(link.get(i)+" ");
//            }
//            System.out.println();
//            for (int i = n; i < 2*n; i++) {
//                System.out.print(link.get(i)+" ");
//            }
//            System.out.println();
            //함께 회전
            for (int i = n-1; i >=1; i--) {
                robots[i]= robots[i-1];
            }
            robots[0]=0;

            Integer remove = link.remove(2 * n - 1);
            link.add(0, remove);

            //
            for (int i = n-1; i >=0; i--) {
                if(i==n-1){
                    robots[i] = 0;
                    continue;
                }
                if(robots[i]==1 &&robots[i+1]==0&& link.get(i+1)>=1 ){
                    robots[i+1] = robots[i];
                    link.set(i+1, link.get(i+1)-1);
                    robots[i]=0;
                }
            }
            if(link.get(0)>=1){
                robots[0]=1;
                link.set(0, link.get(0)-1);
            }

            cnt=0;
            for (int i = 0; i < 2 * n; i++) {
                if(link.get(i)==0){
                    cnt++;
                }
            }
            time++;
        }

        System.out.println(time);
    }
}