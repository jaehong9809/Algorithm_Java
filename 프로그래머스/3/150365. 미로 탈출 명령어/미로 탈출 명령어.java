import java.util.*;

class Solution {
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};
    static String[] dirs = {"d", "l", "r", "u"};

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";
        int pathNum = (int) Math.abs(r - x) + (int) Math.abs(c - y);
        if (pathNum > k || (k - pathNum) % 2 != 0) return "impossible";
        while (k > 0) {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 1 || nx > n || ny < 1 || ny > m) continue;
                if ((int) Math.abs(r - nx) + (int) Math.abs(c - ny) > k) continue;
                x = nx;
                y = ny;
                answer += dirs[i];
                break;
            }

            k--;
        }

        return answer;
    }

}