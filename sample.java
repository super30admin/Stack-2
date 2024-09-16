// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Your code here along with comments explaining your approach:

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if(logs.size() == 0 || n==0) return new int[] {};
        
        Stack<Integer> st = new Stack<Integer>();
        int [] op = new int[n];
        int prev=0;
        for(String log : logs) {
            String arr[]= log.split(":");
            int curr = Integer.parseInt(arr[2]);
            if(arr[1].equals("start")) {
                if(!st.isEmpty())
                    op[st.peek()] += curr - prev;
                    st.push(Integer.parseInt(arr[0]));
                   prev = curr;
            }
            else {
                if(!st.isEmpty())
                    op[st.pop()] += curr - prev + 1;
                prev = curr + 1;
            }
        }
        return op;
    }
}

// Time Complexity : O(n)
// Space Complexity : worst case O(n)
// Did this code successfully run on Leetcode : Yes
// Your code here along with comments explaining your approach:

class Solution {
    public boolean isValid(String s) {
          
        if( s == null || s.length() == 0) return true;
        
        Stack<Character> st = new Stack<>();
        
        //Keep on pushing the closing brackets '(' to the stack for respecting opening ')'
        // when you see a closing bracket pop an item from stack and check if it matches
        for(int i=0; i<s.length(); i++)
        {
            char c = s.charAt(i);
            if(c == '{') st.push('}');
            else if(c=='(') st.push(')');
            else if(c=='[') st.push(']');
            else if(st.isEmpty() || st.pop()!=c) return false;
        }
        
        if(!st.isEmpty()) return false;
        
        return true;
    }
}