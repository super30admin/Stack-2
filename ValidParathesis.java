// Time Complexity : o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public boolean isValid(String s) {
        
        if(s==null||s.length()==0||s.length()%2!=0)
            return false;
        
        Stack<Character> stack=new Stack<>();
        
        int n=s.length();
        
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            
            //({[
            if(c=='(')
                stack.push(')');
            else if(c=='{')
                stack.push('}');
            else if(c=='[')
                stack.push(']');
            else
            {
                if(stack.isEmpty()|| c!=stack.pop())
                    return false;
            }
        }
        return stack.isEmpty()?true:false;
    }
}