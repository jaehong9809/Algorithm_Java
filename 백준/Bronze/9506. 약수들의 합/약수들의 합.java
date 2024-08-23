import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n==-1) break;
			
			int sum=0;
			if(n==1) {
				System.out.println("1 is NOT perfect.");
				continue;
			}
			String string = n + " = 1";
			
			for (int i = 2; i < n; i++) {
				if(n%i==0) {
					sum+=i;
					string+=" + "+i;
				}
			}
			System.out.println( sum+1==n? string : n+" is NOT perfect.");
		}
		
	}
}