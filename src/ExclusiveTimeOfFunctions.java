// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


/**
 * https://leetcode.com/problems/exclusive-time-of-functions/
 * 
 * Use stack to store start entries, end entry found, record time of that function,
 * if entry found on stack, its a parent function, push current functions time into parent functions difference
 * since we need to subtract child function runtime from parent function
 *
 */
class Solution {
    class Pair{
        int function;
        int start;
        int diff;
        
        public Pair(int f, int s, int d) {
            function = f;
            start = s;
            diff = d;
        }
    }
    public int[] exclusiveTime(int n, List<String> logs) {
        if(logs == null || logs.size() == 0) return new int[0];
        
        int[] res = new int[n];
        Stack<Pair> st = new Stack<>();
        
        for(String log: logs){
            String[] arr = log.split(":");
            
            if(arr[1].equals("start")) { //start entry
                Pair p = new Pair(Integer.parseInt(arr[0]), Integer.parseInt(arr[2]), 0);
                st.push(p);
            }else {//end entry
                Pair p = st.pop();
                int time = Integer.parseInt(arr[2]) - p.start + 1 - p.diff;
                res[p.function]+= time;
                
                //time that need to be neglected by parent function - current functions runtime plus any difference current function
                //got from its child functions
                int diff = time + p.diff;
                if(!st.isEmpty()){
                       st.peek().diff+=diff;   
                }
            }
        }
        
        return res;
    }
}