public class Solution
	{
        // Time Complexity : O(n)
        // Space Complexity : O(n)
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No 
        public int[] ExclusiveTime(int n, IList<string> logs)
        {
            int prevTime = 0;
            Stack<int> st = new Stack<int>();
            int[] result = new int[n];
            foreach (var log in logs)
            {
                string[] splitLog = log.Split(':');
                int currTaskId = int.Parse(splitLog[0]);
                int currTime = int.Parse(splitLog[2]);

                if (splitLog[1] == "start")
                {
                    if (st.Count > 0)
                    {
                        result[st.Peek()] += currTime - prevTime;
                    }
                    prevTime = currTime;
                    st.Push(currTaskId);
                }
                else
                {
                    int popped = st.Pop();
                    result[popped] += (currTime + 1) - prevTime;
                    prevTime = currTime + 1;
                }
            }
            return result;
        }
    }
