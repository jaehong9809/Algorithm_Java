import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

class Main {
    static int n, m,k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        long[] data = new long[n+1] ;
        long[] tree = new long[n * 4];

        for (int i = 1; i <= n; i++) {
            data[i] = Long.parseLong(br.readLine());
        }
        init(data, tree, 1, 1, n);

        for (int i = 0; i <m+k; i++) {
            st = new StringTokenizer(br.readLine());
            int a =Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c =Long.parseLong(st.nextToken());
            if(a ==1){
                update(data, tree, 1, 1, n, b, c);
            }else{
                System.out.println(query(tree, 1, 1, n, b, (int)c));
            }
        }

    }

    static void init(long[] data, long[] tree, int node, int start, int end) {
        if (start == end) {
            tree[node] = data[start];
        } else {
            init(data, tree, node * 2, start, (start + end) / 2);
            init(data, tree, node * 2 + 1, (start + end) / 2 + 1, end);
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }
    }

    static void update(long[] data, long[] tree, int node, int start, int end, int index, long val) {
        if (index < start || index > end) {
            return;
        }
        if (start == end) {
            data[index] = val;
            tree[node] = val;
            return;
        }
        update(data, tree, node * 2, start,(start + end) / 2, index, val);
        update(data, tree, node * 2 + 1, (start + end) / 2 + 1, end, index, val);
        tree[node] = tree[node*2] +tree[node*2+1];
    }

    static long query(long[] tree, int node, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return 0;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }
        long lsum = query(tree, node * 2, start, (start + end) / 2, left, right);
        long rsum = query(tree, node * 2 + 1, (start + end) / 2 + 1, end, left, right);
        return lsum + rsum;
    }


}