// Time Complexity : The time complexity is O(n) where n is the length of the logs list
// Space Complexity : The space complexity is O(n) where n is the length of the logs list
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {

        int[] output = new int[n];
        Stack<Integer> s = new Stack<>();
        int prev = 0;

        for(String log:logs){

            String[] str = log.split(":");
            int cur = Integer.parseInt(str[2]);

            if(!s.isEmpty()){
                // start
                if(str[1].equals("start")){
                    output[s.peek()] += cur - prev;
                    prev = cur;
                    s.push(Integer.parseInt(str[0]));
                }
                // end
                else{
                    output[s.pop()] += cur - prev + 1;
                    prev = cur + 1;
                }
            }
            else{
                s.push(Integer.parseInt(str[0]));
            }

        }

        return output;

    }
}