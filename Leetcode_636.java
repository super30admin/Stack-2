//For every start: Update last element present in stack index value in result by peeking it. Put element in stack. Update prev=curr
//For every end: Update last element present in stack index value in result by popping it from stack. Update prev=curr+1 
//TC: O(n)
//SC: O(n)
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {

        int[] ans=new int[n];

        Stack<Integer> stack=new Stack<>();
        int prev=0;

        for(String log:logs){
            String[] arr=log.split(":");
            int curr=Integer.parseInt(arr[2]);

            int idx=Integer.parseInt(arr[0]);

            if(arr[1].equals("start")){
                if(!(stack.isEmpty())){
                    ans[stack.peek()]+=curr-prev;
                }
                stack.push(idx);
                prev=curr;
            }else{
                ans[stack.pop()]+=curr+1-prev;
                prev=curr+1;
            }
        }

        return ans;
        
    }
}
