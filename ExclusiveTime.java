import java.util.List;
import java.util.Stack;
//Time Complexity : O(N)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * Take a stack and push to the stack if its a start. Maintain an array for
 * result. Also maintain a previous time to track the call time taken.
 * Initially, if the stack is empty, push the current start time. From next
 * iteration, if its a start, update the peek index with total difference of
 * curr time and previous time. Then push to the stack. If it is an end, then
 * pop out the top element and update its time with difference of current time
 * and previous time + 1. finally return the result array.
 *
 */
class Solution {
	public int[] exclusiveTime(int n, List<String> logs) {
		int[] ans = new int[n];
		Stack<Integer> stack = new Stack<>();
		int prevTime = 0;
		for (String s : logs) {
			String[] split = s.split(":");
			int currTime = Integer.parseInt(split[2]);
			if (split[1].equals("start")) {
				if (!stack.isEmpty())
					ans[stack.peek()] += currTime - prevTime;
				stack.push(Integer.parseInt(split[0]));
				prevTime = currTime;
			} else {
				ans[stack.pop()] += currTime - prevTime + 1;
				prevTime = currTime + 1;
			}
		}
		return ans;
	}
}
