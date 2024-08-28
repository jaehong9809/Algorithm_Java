import java.util.ArrayList;
import java.util.Scanner;

class Main {
    static int k;
    static int[] data;
    static ArrayList<Integer>[] floors;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        data = new int[(int) Math.pow(2, k) + 1];

        floors = new ArrayList[k];

        for (int i = 0; i < k; i++) {
            floors[i] = new ArrayList<>();
        }
        for (int i = 1; i <= Math.pow(2, k) - 1; i++) {
            data[i] = sc.nextInt();
        }

        int n = (int) Math.pow(2, k) / 2;
        func(n, n / 2, 0);

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < floors[i].size(); j++) {
                System.out.print(floors[i].get(j) + " ");
            }
            System.out.println();
        }
    }

    static void func(int mid, int length, int floor) {
        if (floor == k) return;
        floors[floor].add(data[mid]);
        func(mid - length, length / 2, floor + 1);
        func(mid + length, length / 2, floor + 1);
    }
}