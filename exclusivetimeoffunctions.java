// TC: O(m)
// SC: O(m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    // TC = O(m), SC = O(m), m = length of logs
    public int[] exclusiveTime(int n, List<String> logs) {
        if(n == 0) return new int[] {};
        int[] result = new int[n];
        Stack<Integer> s = new Stack<>();
        int curr = 0, prev = 0;
        for(String log: logs) {
            String[] strArray = log.split(":");
            curr = Integer.parseInt(strArray[2]); // time part of the log
            if(strArray[1].equals("start")) {
                if(!s.isEmpty()) { // some fn was running previously    
                    result[s.peek()] += curr - prev; // add execution time for the fn, curr takes time of next log entry
                }
                s.push(Integer.parseInt(strArray[0])); // push fn to stack
                prev = curr;
            }
            else { // end
                result[s.pop()] += curr - prev + 1; // +1 to account for end, eg 1:start:2","1:end:5, total = 5-2+1 = 4
                prev = curr + 1; // to take care of 1 unit time block
            }
        }
        return result;
    }
}