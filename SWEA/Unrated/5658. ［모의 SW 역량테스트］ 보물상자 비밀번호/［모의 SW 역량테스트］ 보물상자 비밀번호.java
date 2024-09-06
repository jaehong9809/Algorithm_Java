import java.util.*;

public class Solution {
    static int n, k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            n = sc.nextInt();
            k = sc.nextInt();

            int length = n/4;
            Queue<Character> queue = new LinkedList<>();
            sc.nextLine();
            String tmp = sc.nextLine();
            for (int i = 0; i < n; i++) {
                queue.offer(tmp.charAt(i));
            }
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < length; i++) {
                queue.offer(queue.poll());
                int cnt=0;
                String str= "";

                for (Character c : queue) {
                    str+=c;
                    cnt++;
                    if (cnt==length){
                        set.add(Integer.parseInt(str, 16));
                        str="";
                        cnt=0;
                    }
                }
            }

            ArrayList<Integer> result = new ArrayList<>(set);

            Collections.sort(result, Collections.reverseOrder());
            System.out.println("#"+tc+" "+result.get(k-1));

        }

    }
}