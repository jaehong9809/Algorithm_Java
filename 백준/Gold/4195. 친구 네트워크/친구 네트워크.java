import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int f = Integer.parseInt(br.readLine());

            Map<String, Integer> map = new HashMap<>();
            int index = 1;
            parent = new int[1000001];

            Arrays.fill(parent, -1);

            for (int i = 0; i < f; i++) {
                String[] rel = br.readLine().split(" ");

                if (!map.containsKey(rel[0]))
                    map.put(rel[0], index++);
                if (!map.containsKey(rel[1]))
                    map.put(rel[1], index++);
                int a = map.get(rel[0]);
                int b = map.get(rel[1]);

                union(a, b);
                System.out.println(parent[find(a)] * (-1));

            }

        }
    }

    static public int find(int x) {
        if (parent[x] < 0) return x;
        return parent[x] = find(parent[x]);
    }

    static public void union(int a, int b) {
        int roota = find(a);
        int rootb = find(b);

        if(roota == rootb) return;

        if (roota < rootb) {
            parent[roota] += parent[rootb];
            parent[rootb] = roota;
        } else {
                parent[rootb] += parent[roota];
            parent[roota] = rootb;
        }
    }

}