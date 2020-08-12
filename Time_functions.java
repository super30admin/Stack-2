
//TC - O(N)
//SC - O(N)
import java.util.*;

class Solution1 {
	public int[] exclusiveTime(int n, List<String> logs) {
		int result[] = new int[n];
		if (logs == null || logs.size() == 0)
			return result;
		Stack<Integer> stack = new Stack<>();
		int prev = 0;
		for (String log : logs) {
			String[] strArr = log.split(":");
			int curr = Integer.parseInt(strArr[2]);
			if (strArr[1].equals("start")) {
				if (!stack.isEmpty()) {
					result[stack.peek()] += curr - prev;
				}
				stack.push(Integer.parseInt(strArr[0]));
				prev = curr;
			} else {
				result[stack.pop()] += curr - prev + 1;
				prev = curr + 1;
			}
		}
		return result;
	}
}