class Solution {

    // Time Complexity : 0(max(n,m)) where m is the length of the logs array and n is the no. of processes
// Space Complexity : 0(m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


    public int[] exclusiveTime(int n, List<String> logs) {
        int prev = 0;   //a previous variable to store the time a process had started
        int[] result = new int[n];  //result array to return the total time a process ran as result
        Stack<Integer> st = new Stack<>();  //I declare a stack to store the unfinished processes
        for(String log: logs){  //traversing through the logs list
            String[] s = log.split(":");    //splitting each input in the logs list on the basis of colon to seggregate the process, start or end of process and the time till which it ran
            int curr = Integer.parseInt(s[2]);  //storing the current or the end time of a process till when it ran before finishing or before it is interrupted by some other process
            if(s[1].equals("start")){   //if it is the start of the process
                if(!st.isEmpty()){  //I check if there are already infinished processes in the stack
                    result[st.peek()] += curr-prev; //then we add the total run time for this cycle of the process at that position in the resultant array
                }
                st.push(Integer.parseInt(s[0]));    //then O push the process to the stack as it has not yet ended
                prev = curr;    //we set our previous to current as new process or a process which I have already encountered will have a new start time as the current
            }
            else{
                result[st.pop()] += (curr+1) - prev;    //if a process is ending, then I calculate the current runtime of the process and add it to the previous total and store it in the resultant array where index represents the process no. I add +1 as the process is ending.
                prev = curr + 1;    //we move previous to current + 1 as the next process will begin at a timestamp of +1/
            }
        }
        return result;  //In the end, i return the result
    }
}