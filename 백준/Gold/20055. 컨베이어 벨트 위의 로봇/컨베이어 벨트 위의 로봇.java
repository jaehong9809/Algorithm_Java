import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main {
    static int n, k;
    static LinkedList<Integer> link = new LinkedList<>();
    static int[] robots;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        robots = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= 2 * n; i++) {
            link.add(Integer.parseInt(st.nextToken()));
        }
        int time = 0;
        int cnt = 0;
        while (cnt < k) {

            //함께 회전 ==================================
            for (int i = n - 1; i >= 1; i--) {
                robots[i] = robots[i - 1];
            }
            robots[0] = 0;

            Integer remove = link.remove(2 * n - 1);
            link.add(0, remove);
            //==========================================

            //로봇이동==================================
            for (int i = n - 1; i >= 0; i--) {
                if (i == n - 1) {
                    robots[i] = 0;
                    continue;
                }
                if (robots[i] == 1 && robots[i + 1] == 0 && link.get(i + 1) >= 1) {
                    robots[i + 1] = robots[i];
                    link.set(i + 1, link.get(i + 1) - 1);
                    robots[i] = 0;
                }
            }
            //======================================

            //로봇올리기=============================
            if (link.get(0) >= 1) {
                robots[0] = 1;
                link.set(0, link.get(0) - 1);
            }
            //===================================

            //개수 세기===========================
            cnt = 0;
            for (int i = 0; i < 2 * n; i++) {
                if (link.get(i) == 0) {
                    cnt++;
                }
            }
            //===================================
            time++;
        }

        System.out.println(time);
    }
}