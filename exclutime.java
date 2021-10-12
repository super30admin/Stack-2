// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
          if(n==0) return new int[]{};
        int[] result = new int[n];
        Stack<Integer> s = new Stack<>();
        int prev = 0;
        for(String log:  logs) {
            String[] strArray  = log.split(":");
            int cur = Integer.parseInt(strArray[2]);
            if(strArray[1].equals("start")){
                if(!s.isEmpty()){
                    result[s.peek()] += cur - prev;
                    prev = cur;
                }
                s.push(Integer.parseInt(strArray[0]));
            }
            else{
                result[s.pop()] += cur +1 - prev;
                prev = cur + 1;
            }
        }
        return result;
     }
}