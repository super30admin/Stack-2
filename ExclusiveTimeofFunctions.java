
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

import java.util.*;

public class ExclusiveTimeofFunctions {

	public int[] exclusiveTime(int n, List<String> logs) {

		int[] res = new int[n];
		int currentTimeStamp = 0, priorTimeStamp = 0;
		Stack<Integer> stack = new Stack<Integer>();

		for (String log : logs) {

			String[] arr = log.split(":");
			currentTimeStamp = Integer.parseInt(arr[2]);
			int funcId = Integer.parseInt(arr[0]);

			if (arr[1].equals("start")) {
				if (!stack.isEmpty()) {
					res[stack.peek()] += currentTimeStamp - priorTimeStamp;
				}
				stack.push(funcId);
				priorTimeStamp = currentTimeStamp;
			} else {

				res[funcId] += currentTimeStamp - priorTimeStamp + 1;
				stack.pop();
				priorTimeStamp = currentTimeStamp + 1;

			}

		}

		return res;

	}

	public static void main(String[] args) {

		List<String> logs = new ArrayList<>();
		logs.add("0:start:0");
		logs.add("1:start:2");
		logs.add("1:end:5");
		logs.add("0:end:6");

		ExclusiveTimeofFunctions e = new ExclusiveTimeofFunctions();
		int[]  res = e.exclusiveTime(2, logs);
		for(int i: res) {
			System.out.println(i);
		}

	}

}
