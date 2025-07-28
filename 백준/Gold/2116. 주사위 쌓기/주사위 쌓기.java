import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    static int n;
    static ArrayList<Dice> list = new ArrayList<>();
    static int[][] dices;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dices = new int[n][6];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                dices[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int realMax = 0;
        for (int startNum = 0; startNum < 6; startNum++) {
            int max = selectMaxWithoutCeilAndFloor(dices[0], startNum);
            int ceilNum = dices[0][findCeil(startNum)];
            for (int i = 1; i < n; i++) {
                int floor = 0;
                for (int j = 0; j < 6; j++) {
                    if (ceilNum == dices[i][j]) {
                        floor = j;
                        break;
                    }
                }
                max += selectMaxWithoutCeilAndFloor(dices[i], floor);
                ceilNum = dices[i][findCeil(floor)];
            }
            realMax = Math.max(realMax, max);
        }
        System.out.println(realMax);
    }

    static int selectMaxWithoutCeilAndFloor(int[] dice, int floorNum) {
        if (floorNum == 0) {
            return Math.max(dice[1], Math.max(dice[3], Math.max(dice[2], dice[4])));
        } else if (floorNum == 1) {
            return Math.max(dice[0], Math.max(dice[5], Math.max(dice[2], dice[4])));
        } else if (floorNum == 2) {
            return Math.max(dice[0], Math.max(dice[5], Math.max(dice[1], dice[3])));
        } else if (floorNum == 3) {
            return Math.max(dice[0], Math.max(dice[5], Math.max(dice[2], dice[4])));
        } else if (floorNum == 4) {
            return Math.max(dice[0], Math.max(dice[5], Math.max(dice[1], dice[3])));
        } else {
            return Math.max(dice[1], Math.max(dice[3], Math.max(dice[2], dice[4])));
        }
    }

    static int findCeil(int floorNum) {
        if (floorNum == 0) {
            return 5;
        } else if (floorNum == 1) {
            return 3;
        } else if (floorNum == 2) {
            return 4;
        } else if (floorNum == 3) {
            return 1;
        } else if (floorNum == 4) {
            return 2;
        } else {
            return 0;
        }
    }

    static class Dice {
        int A, B, C, D, E, F;

        public Dice(int a, int b, int c, int d, int e, int f) {
            A = a;
            B = b;
            C = c;
            D = d;
            E = e;
            F = f;
        }
    }

}