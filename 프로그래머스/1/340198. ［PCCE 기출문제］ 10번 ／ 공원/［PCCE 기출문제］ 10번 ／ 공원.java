import java.util.*;
class Solution {
    public int solution(int[] mats, String[][] park) {
          int rows = park.length;
        int cols = park[0].length;

        // 큰 돗자리부터 확인하기 위해 내림차순 정렬
        Arrays.sort(mats);
        for (int idx = mats.length - 1; idx >= 0; idx--) {
            int size = mats[idx];

            for (int i = 0; i <= rows - size; i++) {
                for (int j = 0; j <= cols - size; j++) {
                    boolean canPlace = true;

                    for (int x = i; x < i + size; x++) {
                        for (int y = j; y < j + size; y++) {
                            if (!park[x][y].equals("-1")) {
                                canPlace = false;
                                break;
                            }
                        }
                        if (!canPlace) break;
                    }

                    if (canPlace) {
                        return size; // 가장 큰 돗자리부터 확인하므로 바로 return
                    }
                }
            }
        }

        return -1; // 어떤 돗자리도 못 깔면 -1
    }
}