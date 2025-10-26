import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] list = new int[n];

        for (int i = 0; i < n; i++) {
            list[i] = sc.nextInt();
        }

        List<Integer> lis = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int now = list[i];
            int pos = binarySearch(lis, now);
            if (pos == lis.size()) {
                lis.add(now);
            }else{
                lis.set(pos, now);
            }
        }

        System.out.println(lis.size());
    }

    static int binarySearch(List<Integer> list, int target) {
        int start = 0;
        int end = list.size();
        while (start < end) {
            int mid = (start+end)/2;

            if (list.get(mid) < target) {
                start= mid+1;
            }else{
                end = mid;
            }
        }
        return start;
    }
}