// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
class Solution {
    public boolean isValid(String s) {
    Stack<Character> st = new Stack<>();
        
    for(int i=0;i<s.length();i++) // iterate over the string
    {
        char c = s.charAt(i); // get the current character
        //pushing closing bracket crresponding to open ones 
        if(c == '(') 
            st.push(')');
        else if(c == '{')
            st.push('}');
        else if(c == '[')
            st.push(']');
        else
        {
            // checking if it is closing bracket with stacks peek or if the stack is empty i.e teh first character is closing bracket
            if(st.isEmpty() || c != st.peek())
                return false;
            else
                st.pop(); // pop the bracket matched
        }
    }
     
        return st.isEmpty(); // if stack is empty then it is valid
    }
}

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int result[] = new int[n];
        //edge case
        if(logs == null || logs.size() == 0)
            return result;
        int prev = 0;
        Stack<Integer> st = new Stack<>(); // to keep track of stopped processes
        
        for(String log: logs) // iterating over logs
        {
            String split[] = log.split(":"); // splitting and storing in string array
            int curr = Integer.parseInt(split[2]); // curr timestamp
            
            if(split[1].equals("start")) // if process is starting
            {
                if(!st.isEmpty()) // stack is not empty i.e other process has to be stopped
                {
                   result[st.peek()] += curr - prev;  // updating the stopped process time till point
                }
                st.push(Integer.parseInt(split[0])); // pushing the index of current process
                prev = curr; // setting previous as current
            }
            else // if process is ending
            {
                result[st.pop()] += curr - prev + 1; // pop the index out of stack and add the time for which the process has now ran ( adding 1 as process runs for end value as well )
                prev = curr + 1; // prev updated as end is 1 based
            }
        }
        
        return result;
    }
}