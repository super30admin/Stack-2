//https://leetcode.com/problems/exclusive-time-of-functions/
/*
Time: O(n) where n = logs.size() 
Space: O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        int prevTime = 0, currID = 0;
        Stack<Integer> stack = new Stack<>();

        for (String log : logs) {
            String[] split = log.split(":");
            int funcID = Integer.parseInt(split[0]);
            boolean start = split[1].equals("start");
            int currTime = Integer.parseInt(split[2]);

            if (!start)
                currTime++; // inc all end times by 1 initially, because end time is also consumed

            res[currID] += (currTime - prevTime);

            if (start) // add to stack
            {
                stack.push(currID);
                currID = funcID;
            }

            else // end. Finished, so pop it out
            {
                currID = stack.pop();
            }

            prevTime = currTime;
        }

        return res;

    }

}
