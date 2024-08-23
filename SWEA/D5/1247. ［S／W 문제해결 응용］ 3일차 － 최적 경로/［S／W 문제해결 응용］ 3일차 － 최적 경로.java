import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Solution {
	static boolean[] visited;
	static int n;
	static int companyx;
	static int companyy;
	static int homex;
	static int homey;
	static int[][] customers;
	static int[] arr;
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int testcase = 1; testcase<=T; testcase++) {
			n = Integer.parseInt(br.readLine());
			arr=new int[n];
			visited=new boolean[n];
			String[] str = br.readLine().split(" ");
			min = Integer.MAX_VALUE;
			companyx = Integer.parseInt(str[0]);
			companyy = Integer.parseInt(str[1]);
			homex = Integer.parseInt(str[2]);
			homey = Integer.parseInt(str[3]);
			
			customers = new int[n][2];
			int index=0;
			for(int i=4; i<(n+2)*2; i+=2) {
				customers[index][0] = Integer.parseInt(str[i]);
				customers[index][1] = Integer.parseInt(str[i+1]);
				index++;
			}
			
			permutation(0);
			System.out.println("#"+testcase+" "+min);
			
		}
		
		
	}
	
	public static void permutation(int depth) {
		if(depth == n ) {
			int distance=Math.abs(companyx - customers[arr[0]][0])+
					Math.abs(companyy - customers[arr[0]][1]);
			distance += Math.abs(homex - customers[arr[n-1]][0])+
					Math.abs(homey - customers[arr[n-1]][1]);
			
			for(int i=0; i<n-1; i++) {
				int nowIndex =arr[i];
				int nextIndex = arr[i+1];
				
				int dist = Math.abs(customers[nowIndex][0]-customers[nextIndex][0])+
						Math.abs(customers[nowIndex][1]-customers[nextIndex][1]);
				
				distance+=dist;
				if(min<=dist) return;
			}
			
			min = Math.min(distance, min);
			
			return;
		}
		
		
		for(int i=0; i<n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[depth]=i;
				permutation(depth+1);
				visited[i]=false;
			}
			
		}
		
	}
	

}