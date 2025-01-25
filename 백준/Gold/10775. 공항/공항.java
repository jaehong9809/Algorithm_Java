import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        parent = new int[n+1];
        for (int i = 0; i <=n; i++) {
            parent[i] = i;
        }

        int m = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            int g = Integer.parseInt(br.readLine());
            int root =find(g);
            if(root==0){
                break;
            }
            union(root, root-1);
            cnt++;
        }

        System.out.println(cnt);
    }
    static int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            return parent[x] = find(parent[x]); // 경로 압축
        }
    }
    static boolean union(int a, int b) {
        int roota = find(a);
        int rootb = find(b);

        if (roota == rootb) return false;

        if (roota > rootb) {
            parent[roota] = rootb;
        } else {
            parent[rootb] = roota;
        }
        return true;
    }
}