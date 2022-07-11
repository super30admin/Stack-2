using System;
using System.Collections.Generic;

namespace Algorithms
{
    public class ExclusiveTimeFunctions
    {
        /// Time Complexity : O(N) 
        // Space Complexity :O(N) 
        // Did this code successfully run on Leetcode :Yes
        // Any problem you faced while coding this :  No 
        public int[] ExclusiveTime(int n, IList<string> logs)
        {
            if (logs == null || logs.Count == 0) return new int[0];
            int[] result = new int[n];
            Stack<int> st = new Stack<int>();
            int prev = 0;
            int curr = 0;
            foreach (var log in logs)
            {
                string[] sp = log.Split(":");
                curr = Int32.Parse(sp[2]);
                //start
                if (sp[1] == "start")
                {
                    if (st.Count != 0)
                    {
                        result[st.Peek()] += curr - prev;
                    }
                    st.Push(Int32.Parse(sp[0]));
                    prev = curr;

                }
                else
                {
                    //end
                    if (st.Count != 0)
                    {
                        result[st.Pop()] += curr - prev + 1;
                    }
                    prev = curr + 1;
                }
            }
            return result;
        }
    }
