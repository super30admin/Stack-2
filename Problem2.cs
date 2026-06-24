// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
I traverse through the string, for each opening '(', '[' or '{' bracket I push the corresponding closing bracket to the stack. 
If I come across a closing bracket I check if stack is empty or the topmost element in stack does not match with the closing bracket, if
any of these conditions are true I return false. Else after traversing all characters in the string, I return true.
*/

public class Solution
{
    public bool IsValid(string s)
    {
        Stack<char> st = new();

        for (int i = 0; i < s.Length; i++)
        {
            if (s[i] == '(')
            {
                st.Push(')');
            }

            else if (s[i] == '[')
            {
                st.Push(']');
            }

            else if (s[i] == '{')
            {
                st.Push('}');
            }

            else if (st.Count == 0 || st.Pop() != s[i])
            {
                return false;
            }
        }

        return st.Count == 0;
    }
}