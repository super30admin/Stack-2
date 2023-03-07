//TC: O(n) //length of logs array
//SC: O(n) 


// We use stack for this solution along with 2 pointers
// Prev pointer and curr pointer are both at 0
// For 0 index when stack is empty, we push the first taskId timestamp in stack, curr=the curr element
// prev=0, after pushing in stack, prev=curr (First element is always a start element)
// For the next elements, if its a start task, we capture its time taken by doing currentTimestamp-prev
// and append it to the reults array for that taskId
// Then we push the taskId timestamp in the stack and make new prev=curr
// If the incoming task is an end task, we pop the top of the stack and append its corresponding value
// in the result arr with curr+1-prev
// Because and end task takes the whole time unit and then the next task starts immediately
// Here new prev=curr+1

// NOTE: The top of the stack always the same task as the incoming "END" task

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result=new int[n];
        Stack<Integer> st=new Stack<>();
        int prev=0; //prev timestamp
        for(String log:logs){
            String[] arr=log.split(":"); //0:start:0
            int taskId=Integer.parseInt(arr[0]);
            int curr=Integer.parseInt(arr[2]); //curr is timestamp
            
            if(arr[1].equals("start")){
                if(!st.isEmpty()){
                    result[st.peek()]+=curr-prev;
                }
                st.push(taskId);
                prev=curr;
            } else{
                result[st.pop()]+=curr+1-prev;
                prev=curr+1;
            }
        }
        return result;
    }
}