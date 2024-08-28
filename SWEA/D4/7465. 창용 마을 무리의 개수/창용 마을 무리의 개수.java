import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int TESTCASE = 1; TESTCASE <= t; TESTCASE++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            make(n);

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if(union(a, b)) n--;
            }

            sb.append("#").append(TESTCASE).append(" ").append(n).append("\n");
        }
        System.out.println(sb);
    }

    public static void make(int n) {
        parents = new int[n + 1];
        Arrays.fill(parents, -1);
    }

    public static int findParent(int x) {
        if (parents[x] < 0) return x;

        return parents[x] = findParent(parents[x]);
    }


    public static boolean union(int x, int y) {
        int xParent = findParent(x);
        int yParent = findParent(y);
        if (xParent == yParent) return false;

        if (xParent < yParent) {
            parents[xParent] += parents[yParent];
            parents[yParent] = xParent;
        } else {
            parents[yParent] += parents[xParent];
            parents[xParent] = yParent;
        }

        return true;
    }
}