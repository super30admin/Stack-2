// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int [] result = new int[n];
        Stack<Integer> s = new Stack<Integer>();
        int curr=0, prev=0;
        for (String log : logs) {
            String[] array = log.split(":");
            curr = Integer.parseInt(array[2]);
            if (array[1].equals("start")) {
                int id= Integer.parseInt(array[0]);
                if(!s.isEmpty()) {
                    result[s.peek()] += curr - prev;
                }
                s.push(id);
                prev=curr;
            } else {
                if (array[1].equals("end")) {
                    int id= Integer.parseInt(array[0]);
                    result[s.pop()] += curr - prev +1;
                    prev= curr +1;
                }
            }
        }
        return result;
    }
}
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c: s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } 
            else if (c == '{') {
                stack.push('}');
            }
            else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
