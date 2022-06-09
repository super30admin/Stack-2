using System;
using System.Collections.Generic;
using System.Text;

namespace Array
{
    public class ExclusiveTimeOfFunction
    {
      /*
      * T.C:O(max(n,m) where n is no of functions and m is number of longs 
      * S.C: O(n) no of items in the stack.
      */
        public int[] ExclusiveTime(int n, IList<string> logs)
        {
            if (n == 0) return new int[] { };

            Stack<int> stack = new Stack<int>();
            int curr = 0, prev = 0;
            int[] result = new int[n];

            foreach (string log in logs)
            {
                string[] strarray = log.Split(":");
                curr = int.Parse(strarray[2]);

                if (strarray[1].Equals("start"))
                {
                    if (stack.Count != 0)
                    {
                        result[stack.Peek()] += curr - prev;
                    }
                    prev = curr;
                    stack.Push(int.Parse(strarray[0]));
                }
                else
                {
                    if (stack.Count != 0)
                    {
                        result[stack.Pop()] += (curr + 1) - prev;
                        prev = curr + 1;
                    }
                }
            }

            return result;

        }
    }
}
