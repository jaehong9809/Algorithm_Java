import java.util.*;
class Solution {
	static boolean[] visited;
	static int[] arr;
	static String[][] copy;
	static ArrayList<ArrayList<Integer>> results=new ArrayList<>();
    static public int solution(String[][] relation) {
        int answer = 0;
        int length = relation.length;
        int colcnt = relation[0].length;
        copy = relation.clone();
        arr=new int[colcnt];
        visited=new boolean[colcnt];
        
        
        for(int i=1; i<=colcnt; i++) {
        	dfs(0, 0, i, colcnt);
        }
        
        
        answer = results.size();
        return answer;
    }
    
    
    static public void dfs(int start, int depth, int max, int colcnt) {
    	if(depth ==max) {
    		check(max);
    		return;
    	}
    	
    	for(int i=start; i<colcnt; i++) {
    		if(!visited[i]) {
    			visited[i] = true;
    			arr[depth]=i;
    			dfs(i, depth+1, max, colcnt);
    			visited[i]=false;
    		}
    		
    		
    	}
    	
    	
    }
    
    static void check(int max) {
    	Set<String> set=new HashSet<>();
    	
    	for(int i=0; i<copy.length; i++) {
    		String str="";
    		for(int j=0; j<max; j++) {
    			str+=copy[i][arr[j]]+" ";
    		}
    		set.add(str);
    	}
    	
    	if(set.size()==copy.length) {
    		String str="";
    		for(int j=0; j<max; j++) {
    			str+=arr[j]+" ";
    		}
 
    		for(int i=0; i<results.size(); i++) {
      			boolean sign=false;
    			for(int j=0; j<results.get(i).size(); j++) {
    				if(!str.contains(results.get(i).get(j).toString())) {
    					sign=true;
    				}
    				
    			}
    			if(!sign)return;
    			
    		}

			ArrayList<Integer> tmp = new ArrayList<>();
	    	for(int j=0; j<max; j++) {
	    		tmp.add(arr[j]);
	    	}    				
	    		
	    	results.add(tmp);


    	}
    	
    }
    
}