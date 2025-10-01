

// Time Complexity: O(m) where m is the number of logs
// Space Complexity: O(n) where n is the number of functions

//We use stack to keep track of the function calls and a prev variable to keep track of the previous timestamp.
//When we encounter a start log, we update the exclusive time of the function at the top of the stack.
//When we encounter an end log, we pop the function from the stack and update its exclusive time.
//Finally, we return the ans array which contains the exclusive time of each function.


class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int ans[]=new int[n];
        Stack<Integer> stk=new Stack<>();
        int prev=0;

        for(String s:logs){
            String a[]=s.split(":");
            int id=Integer.parseInt(a[0]);
            String type=a[1];
            int curr=Integer.parseInt(a[2]);
            
            if(type.equals("start")){
                if(!stk.isEmpty())
                    ans[stk.peek()]+=curr-prev;
                stk.push(id);
            }else{
                curr=curr+1;
                ans[stk.pop()]+=curr-prev;
            }
            prev=curr;
        }
        return ans;
    }
}