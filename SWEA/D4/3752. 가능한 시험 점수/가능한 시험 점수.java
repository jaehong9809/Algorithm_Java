import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int TC = 1 ; TC<=t; TC++) {
			int n = Integer.parseInt(br.readLine());
			
			int[] list = new int[n];
			String[] str = br.readLine().split(" ");
			int total = 0;
			for(int i=0; i<n; i++) {
				list[i] = Integer.parseInt(str[i]);
				total+=list[i];
			}
			boolean[] dp = new boolean[10001];
			dp[0] = true;
			int max = 0;
			for (int i : list) {
			    // max부터 0까지 역순으로 순회!
			    for (int j = max; j >= 0; j--) {
			        if (dp[j]) {
			            dp[j + i] = true;
			        }
			    }
			    // 최대 점수 한계치는 그냥 이번 배점(i)을 더해주면 됩니다.
			    max += i; 
			}
			int result=0;
			for(int i=0; i<=10000; i++) {
				if(dp[i]) result++;
			}
			
			
			System.out.println("#"+TC+" "+result);
		}
	}
	
	public static void bfs() {
		
		
		
	}
}

