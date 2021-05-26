//Time Complexity : O(m). m is the number of function calls
//Space Complexity : O(m/2) and asymptotically O(m), here m/2 is the number of start function callswhich are pushed into the stack . 
For every start there is an end. Hence m/2. 
// Did this code successfully run on Leetcode : yes
// Your code here along with comments explaining your approach
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        //Stack is used to keep track of all the process id's with start function
        Stack<Integer> stack = new Stack<>();
        int prev = 0;//keep track of prev time stamp to get the total time used
        stack.push(0);
        //iterate through the string
        for(int i=1;i<logs.size();i++){
            String temp = logs.get(i);
            //split each string by :
            String str[] = temp.split(":");
            //System.out.println(str[0]);
            //now str[0]-->id, str[1]-->start or end, str[2]-->timestamp
            int cur = Integer.parseInt(str[2]);//timestamp of current process
            //if start
            if(str[1].equals("start")){
                 //add the time taken by this current process so far to result 
                if(!stack.isEmpty())
                   result[stack.peek()] +=  cur - prev;
            //add id to stack
                stack.push(Integer.parseInt(str[0]));
                //update the prev before moving to next process
                prev = cur;
            }
            if(str[1].equals("end")){
                //pop from stack and update the time of the current process
                result[stack.pop()] += cur - prev + 1;
                //update the prev
                prev = cur+1;
            }
        }
        return result;
    }
}