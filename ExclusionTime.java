// Time Complexity : O(n) where n is the string length
// Space Complexity : O(n) where n is the string length (Stack)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I think if we use Hashmap with { ID : Pair of start and end time} will be complicated but 
                                        //   might to do the job, we dont need to care about order 
                                        //   if we simply parse the string list and O(1) lookup for each ID's and update the start and end time for each of te Id's
/* Your code here along with comments explaining your approach:  For each of the interval, split the string into string array. If the string has start
implies a new job is starting, update the previous as the current value and push the job Id in the stack. If the stack is not empty, peek from it
and store the interval difference in the latest id that has been pushed into the stack. If the string has end word, then simply pop the latest id
from the stack. Update the result by the interval difference of current time - previous time and add it to the old interval time stored in that id.
Update the previous to the next of current since a new interval is about to start.
*/
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
     int[] result = new int[n];
     if(logs == null || logs.size() == 0){return new int[0];}                                   // edge case
     Stack<Integer> stk = new Stack<>();
     int prev = 0;
     for(String s: logs){
         String[] temp = s.split(":");                                                          // Split the string
         int id = Integer.parseInt(temp[0]);                                                    // Job ID
         int curr = Integer.parseInt(temp[2]);                                                  // Current time
         if(temp[1].equals("start")){
             if(!stk.isEmpty()) result[stk.peek()] += curr - prev;                              // update the interval of the previous job
             prev = curr;
             stk.push(id);                                                                      // Push the Id into the stack
         } else
         if(temp[1].equals("end")){                                                             // If the word is end
             stk.pop();                                                                         // Pop from the stack
             result[id] += curr - prev + 1;                                                     // Update the interval in the result index with latest interval addition
             prev = curr + 1;                                                                   // Move the previous next to the current as new interval is going to start
         }
         }        
     return result;
    }
}