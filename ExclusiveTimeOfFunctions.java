// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
    	Stack<Integer> stack = new Stack<>();
    	int[] result = new int[n];

    	int priorTimestamp = 0, currentTimestamp = 0;

    	for(String log: logs) {
    		// 0: function id
    		// 1: event
    		// 2: timestamp
    		String[] token = log.split(":");

    		int functionId = Integer.parseInt(token[0]);
    		currentTimestamp = Integer.parseInt(token[2]);

    		// stack 0:s:0, prev = 0
    		// current: 2
    		if(token[1].equals("start")) {
    			if(!stack.isEmpty())
    				result[stack.peek()] += currentTimestamp - priorTimestamp;
    			stack.push(functionId);
    		} else {
    			result[functionId] += currentTimestamp - priorTimestamp + 1;
    			stack.pop();
    			priorTimestamp = currentTimestamp + 1;
    		}
    	}

    	return result;
        
    }
}