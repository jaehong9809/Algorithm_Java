import java.util.Scanner;

class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] arr = new int[14];
    static int n;
    static boolean[] visited;
    static int[] data;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            n = sc.nextInt();
            if (n == 0) break;

            visited = new boolean[n];
            data = new int[n];
            for (int i = 0; i < n; i++) {
                data[i] = sc.nextInt();
            }
            comb(0, 0);

            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void comb(int start, int depth) {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = data[i];
                comb(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }
}