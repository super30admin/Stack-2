//Time Complexity : O(n), n -> Number of given logs
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
package problem1;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions {
	public int[] exclusiveTime(int n, List<String> logs) {
		if (logs == null || logs.size() == 0 || n == 0) {
			return new int[0];
		}

		int[] ans = new int[n];
		int prev = 0;
		int curr = 0;

		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < logs.size(); i++) {
			String[] entry = logs.get(i).split(":");
			curr = Integer.parseInt(entry[2]);
			// Start
			if (entry[1].equals("start")) {
				if (!stack.isEmpty()) {
					ans[stack.peek()] += curr - prev;
					prev = curr;
				}
				stack.push(Integer.parseInt(entry[0]));
			}
			// End
			else {
				ans[stack.pop()] += curr + 1 - prev;
				prev = curr + 1;
			}
		}

		return ans;
	}

	private void print(int[] time) {
		for (int fn : time) {
			System.out.print(fn + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ExclusiveTimeOfFunctions obj = new ExclusiveTimeOfFunctions();
		int n = 3;
		List<String> logs = Arrays.asList("0:start:0", "1:start:2", "2:start:3", "2:end:4", "1:end:5", "0:end:6");
		System.out.print("Exclusive time of each function: ");
		int[] ans = obj.exclusiveTime(n, logs);
		obj.print(ans);
	}

}
