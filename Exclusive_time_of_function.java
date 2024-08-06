// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> s = new Stack<>();
        int result[] = new int[n];
        int curr = 0;
        int prev = 0;

        for(String log : logs){
            String[] strArray = log.split(":");
            curr = Integer.parseInt(strArray[2]);

            if(strArray[1].equals("start")){
                if(!s.isEmpty()){
                    result[s.peek()] += curr - prev;
                }
                s.push(Integer.parseInt(strArray[0]));
                prev = curr;
            }
            else{
                result[s.pop()] += curr + 1 - prev;
                prev = curr + 1;
            }
        }
        return result;
    }
}
