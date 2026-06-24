// Time Complexity : O(n) where n is the length of logs
// Space Complexity : O(n) where n is the length of logs
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
I creare a result array of size n where n is the size of logs list and also create a stack. I have initialized prev and current
variables and set them to 0 at first. I start traversing through the logs. If the stack is empty, I push the id of current log
to the stack. Else I check if the log is start or end log - if start log I obtain current time stamp and update the
time taken for execution for the task on top of the stack and then push the current id to the stack. Else if it's an end log, I 
I update the current time stamp by adding 1 to it. I update the time taken for execution for the task on top of the stack
and remove the id from the stack. At the end I return the result array.
*/

public class Solution
{
    public int[] ExclusiveTime(int n, IList<string> logs)
    {
        int[] result = new int[n];
        Stack<int> st = new();
        int prev = 0, current = 0;

        foreach (string log in logs)
        {
            string[] logArray = log.Split(':');
            int id = int.Parse(logArray[0]);
            current = int.Parse(logArray[2]);

            if (st.Count == 0)
            {
                st.Push(id);
            }

            else
            {
                if (logArray[1].Equals("start"))
                {
                    result[st.Peek()] += (current - prev);
                    st.Push(id);
                }

                else
                {
                    current += 1;
                    result[st.Peek()] += (current - prev);
                    st.Pop();
                }
            }

            prev = current;
        }

        return result;
    }
}