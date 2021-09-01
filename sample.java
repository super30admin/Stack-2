// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if(logs == null || logs.size() == 0) {
            return new int[0];
        }
        Stack<Integer> stack = new Stack<>();
        
        int prev = 0;
        int current = 0;
        int[] result = new int[n];
        
        for(String s : logs) {
            String[] parts = s.split(":");
            current = Integer.parseInt(parts[2]);
            
            if(parts[1].equals("start")) {
                if(!stack.isEmpty()) {
                    result[stack.peek()] +=  current - prev;
                    prev = current;
                }
                stack.push(Integer.parseInt(parts[0]));
            } else {
                result[stack.pop()] += (current+1) - prev;
                prev = current + 1;
            }
            
        }
        return result;
    }
}




// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public boolean isValid(String s) {
        
        if(s.length() % 2 != 0) {
            return false;
        }
        
        Stack<Character> stack = new Stack();
        
       for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            
            if (current == '(' || current == '{' || current == '[')
                stack.push(current);
            
            else if (stack.isEmpty())
                return false;
            
            else if (current == ')' && stack.pop() != '(')
                return false;
            
            else if (current == ']' && stack.pop() != '[')
                return false;
            
            else if (current == '}' && stack.pop() != '{')
                return false;
        }
        
        return stack.isEmpty();
    }
}