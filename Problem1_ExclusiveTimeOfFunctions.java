// Time Complexity : o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
     
        if(logs == null || logs.size() == 0) {
            return new int[0];
        }
        Stack<Integer> stack = new Stack<>();

        int prev = 0;
        int current = 0;
        int[] result = new int[n];

        for(String s:logs)
        {
            String[] entry=s.split(":");
            
            current=Integer.parseInt(entry[2]);
            
            if(entry[1].equals("start"))
            {
                if(!stack.isEmpty())
                {
                    result[stack.peek()]+=current-prev;
                    prev=current;
                } 
                stack.push(Integer.parseInt(entry[0]));
            }
            else
            {
                result[stack.pop()]+=(current+1)-prev;
                prev=current+1;
            }
           
        }
        return result;
    }
}