
import java.util.*;
import java.io.*;

class Main {
	static boolean[] visited;
	static int[] data;
	static int n;
	static int[] arr;
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		data = new int[n];
		arr = new int[n];
		String[] tmp = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			data[i] = Integer.parseInt(tmp[i]);
		}

		visited = new boolean[n];

		func(0);
		System.out.println(max);
	}

	public static void func(int depth) {
		if (n == depth) {
			int sum = 0;
			for (int i = 0; i < n - 1; i++) {
				sum += Math.abs(data[arr[i + 1]] - data[arr[i]]);
			}
			max = Math.max(max, sum);

			return;
		}

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[depth] = i;
				func(depth + 1);
				visited[i] = false;
			}
		}

	}
}