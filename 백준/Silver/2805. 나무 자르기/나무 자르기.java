import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		System.out.println(bs(m, arr));

	}

	static long bs(int target, int[] arr) {
		long left = 0;
		long right = arr[arr.length - 1];
		long res = 0;
		while (left <= right) {
			long mid = (left + right) / 2;
			long total = 0;
			
			for(int i : arr) {
				if(i > mid) {
					total+=i-mid;
				}
			}
			
			if(total>=target) {
				res = mid;
				left = mid+1;
				
			}else {
				right = mid-1;
			}
		}

		return res;
	}
}