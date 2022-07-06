using System;
using System.Collections.Generic;

namespace Algorithms
{
    /// Time Complexity : O(n)
    // Space Complexity :O(n)
    // Did this code successfully run on Leetcode :Yes
    // Any problem you faced while coding this :  Referred Online
    public class ValidParanthesis
    {
        public bool IsValid(string s)
        {
            Stack<char> st = new Stack<char>();
            List<char> oList = new List<char>();
            oList.Add('(');
            oList.Add('{');
            oList.Add('[');

            char[] sArray = s.ToCharArray();
            for (int i = 0; i < sArray.Length; i++)
            {
                char c = sArray[i];
                if (IsOpeningParathesis(c, oList))
                {
                    st.Push(c);
                }
                else
                {
                    if (st.Count != 0)
                    {
                        char m = st.Pop();
                        if (!MatchingParathesis(m, c)) return false;
                    }
                    else
                    {
                        return false;
                    }
                }
            }
            return st.Count == 0;

        }

        private bool IsOpeningParathesis(char c, List<char> oList)
        {
            if (oList.Contains(c))
            {
                return true;
            }
            else
            {
                return false;
            }

        }
        private bool MatchingParathesis(char c, char p)
        {
            bool result = false;
            if (c == '(' && p == ')')
            {
                result = true;
            }
            else if (c == '{' && p == '}')
            {
                result = true;
            }
            else if (c == '[' && p == ']')
            {
                result = true;
            }
            return result;
        }
    }
}
