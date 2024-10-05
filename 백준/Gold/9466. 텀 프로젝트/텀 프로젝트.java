import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static boolean[] visited, done;
    static int[] data;
    static ArrayList<Integer> list;
    static int result=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int TESTCASE = 1; TESTCASE <= t; TESTCASE++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            data = new int[n + 1];
            visited = new boolean[n + 1];
            done  = new boolean[n+1];
            for (int i = 1; i <= n; i++) {
                data[i] = Integer.parseInt(st.nextToken());
            }
            result = 0;


            for (int i = 1; i <= n; i++) {
                if (!done[i]) {
                    dfs(i);
                }
            }

            System.out.println(n-result);
        }
    }

    static void dfs(int now) {
        if(done[now]) return;
        if(visited[now]) {
            done[now] = true;
            result++;
        }
        visited[now] = true;
        dfs(data[now]);
        done[now] = true;
        visited[now] = false;
    }
}