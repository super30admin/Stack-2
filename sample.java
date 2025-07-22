// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        int prevtime = 0;
        for (String log : logs) {
            String[] parts = log.split(":");
            int functionid = Integer.parseInt(parts[0]);
            String type = parts[1];
            int timestamp = Integer.parseInt(parts[2]);
            if (type.equals("start")) {
                if (!stack.isEmpty()) {
                    result[stack.peek()] += timestamp - prevtime;
                }
                stack.push(functionid);
                prevtime = timestamp;
            } else {
                result[stack.peek()] = result[stack.peek()] + timestamp - prevtime + 1;
                stack.pop();
                prevtime = timestamp + 1; // The next time slot available for a function to run is at timestamp + 1.
            }

        }
        return result;

    }
}

//

public class Solution {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty())
                    return false;
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}