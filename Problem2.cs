public class Solution
	{
        // Time Complexity : O(n)
        // Space Complexity : O(n)
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No 
        public bool IsValid(string s)
        {
            Stack<char> st = new Stack<char>();
            int n = s.Length;
            for (int i = 0; i < n; i++)
            {
                char c = s[i];
                if (c == '(')
                {
                    st.Push(')');
                }
                else if (c == '{')
                {
                    st.Push('}');
                }
                else if (c == '[')
                {
                    st.Push(']');
                }
                else if (st.Count == 0 || st.Pop() != c)
                {
                    return false;
                }
            }
            if (st.Count > 0)
                return false;
            return true;
        }
    }
