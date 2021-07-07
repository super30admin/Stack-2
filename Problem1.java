//Time : O(n)
//Space:O(n)
//LeetCode:Yes

//Approach:
//1.Have a stack and an array of size tasks.
//2. Now in logs if a task is starting, if stack is empty ,push it to stack and store this time as previous value
//3. Now again if a new task starts , then add the time i.e current value time - previous time for already existing task in stack.
//4.Else if a task is stopping then pop task from stack and update this task's time in the array by adding current value-previous value.
// Finally,return array.
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];
        int prev = 0;
        for(String log : logs){
            String[] strs = log.split(":");
            int current = Integer.parseInt(strs[2]);
            if(strs[1].equals("start")){
                if(!stack.isEmpty()){
                    result[stack.peek()] += current - prev-1;
                }
                stack.push(Integer.parseInt(strs[0]));
            }
            else{
                result[stack.pop()] += current-prev+1;
            }
            prev = current;
        }
        return result;
    }
}
