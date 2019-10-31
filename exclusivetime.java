//Time Complexity:O(log.size())
//SPace Complexity:O(n)
//Approach- I will have a stack to maintain the function id. Whenever the function Id starts, If the stack is not empty, I'll add difference between current and previous value to the index corresponding to the function id at the top of the stack. Else, I'll simply push the function into the stack and update the previous. When a function ends, I'll update the value of the top most function id in the result array and pop it out. 
//This code was executed sucessfully and got accepted in leetcode.

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack=new Stack<>();
        int[] res=new int[n];
        int prev=0;
        for(String s:logs){
            String[] str=s.split(":");
            int cur=Integer.parseInt(str[2]);
            if(str[1].equals("start")){
                if(!stack.isEmpty()){
                    res[stack.peek()]+=cur-prev;
                   
                }
                
                stack.push(Integer.parseInt(str[0]));
                prev=cur;
                
            }
            else{
                res[stack.pop()] += cur-prev +1;
                prev=cur+1;
            }
        }
        return res;
    }
}