package Stack2;

	// Time Complexity : O(n)
	// Space Complexity : (n)
	// Did this code successfully run on Leetcode : yes

	class Solution {
	    public int[] exclusiveTime(int n, List<String> logs) {
	        int[] result = new int[n];
	        Stack<Integer> stk = new Stack<>();

	        int prev = 0;
	        for(String log: logs){
	            String[] curLog = log.split(":");
	            int cur = Integer.parseInt(curLog[2]);
	            if(curLog[1].equals("start")){
	                if(!stk.isEmpty()){
	                    result[stk.peek()] += cur - prev;
	                    prev = cur;
	                }
	                stk.push(Integer.parseInt(curLog[0]));
	            } else {
	                result[stk.pop()] += cur -prev + 1;
	                prev = cur+1;
	            }
	        }
	        return result;
	    }
	}
