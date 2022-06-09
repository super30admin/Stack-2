using System;
using System.Collections.Generic;
using System.Text;

namespace Array
{
    public class ValidParanthesis
    {
        /*
         * T.C: O(N) since traversing through all the element
         * S.C: O(N) stack contains paranthesis in the scring
         * 
         */
        public bool IsValid(string s)
        {
            if (s == null || s.Length == 0) return false;

            Stack<char> stack = new Stack<char>();

            for (int i = 0; i < s.Length; i++)
            {
                char c = s[i];

                if (c == '(')
                {
                    stack.Push(')');
                }
                else if (c == '{')
                {
                    stack.Push('}');
                }
                else if (c == '[')
                {
                    stack.Push(']');
                }
                else if (stack.Count == 0 || stack.Pop() != c)
                {
                    return false;
                }
            }

            return stack.Count == 0 ? true : false;
        }
    }
}
