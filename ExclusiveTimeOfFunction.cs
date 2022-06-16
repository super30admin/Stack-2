// Time Complexity : O(n) n is number of functions
// Space Complexity : O(m) m is number of logs
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public int[] ExclusiveTime(int n, IList<string> logs) {
    if(logs == null || logs.Count == 0)
        return new int[0];
    
    int[] result = new int[n];
    
    Stack<int> s = new Stack<int>();
    int prev = 0;

    foreach(string log in logs)
    {
        string[] splitArray = log.Split(":");
        int curr = Convert.ToInt32(splitArray[2]);
        //If we encounter start, we will add in stack
        //If id changed, we will take current - prev and out it at top id from stack
        if(splitArray[1] == "start")
        {
            //new process came, so update the time of process from top of stack to curr - prev
            if(s.Count > 0)
            {
                result[s.Peek()] += curr - prev;
            }
            s.Push(Convert.ToInt32(splitArray[0]));
            prev = curr;
        }
        else
        {
            if(s.Count > 0)
            {
                //we encountered end, so process is finished, pop it from stack
                //we do curr + 1, because for end, timestamp is end of timestamp, which will be timestamp+1                    
                result[s.Pop()] += curr + 1 - prev;
            }
            //set prev to curr+1 for that same region mentioned above
            prev = curr + 1;
        }
    }
    return result;
}